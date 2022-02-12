package src;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import java.awt.geom.Area;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


class Game implements Setup {
    
    public static int score;
    public static String level;
    public static Sprite bola; // OU Bola bola
    public static Sprite raquete; // OU Raquete raquete
    public static ArrayList<ElementoConsumivel> listaDebuffs;
    public static ArrayList<Sprite> listaTijolos;   // OU: ArrayList<Tijolo>
    public static ArrayList<ElementoConsumivel> listaBuffs;
    public static JPanel painel;
    public static JLabel labelScore; // JLabel para exibir o nome "score"
    public static JLabel labelScoreNumeros; // JLabel por onde serão exibidos os números
    private static Random gerar = new Random();
    private static boolean jogando = true;
    private static JFrame tela;
   
// public static BufferStrategy strategy;

    //FUNCAO PRINCIPAL DO JOGO
    public static void main(String[] args) throws InterruptedException{
          Game.startSetup();
    }
    
    private static void startSetup() {
            Game.score = 000;
            Game.bola = new Bola( Setup.INICIA_BOLA_X , Setup.INICIA_BOLA_Y, 50, 50, new JLabel());
            Game.raquete = new Raquete( (int) Setup.INICIA_RAQUETE_X, (int) Setup.INICIA_RAQUETE_Y, 100, 100, new JLabel() );
            Game.listaTijolos = new ArrayList<>(); 
            Game.listaDebuffs = new ArrayList<>();
            Game.listaBuffs = new ArrayList<>();
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            // 7 linhas com 8 colunas cada (80x28)
            for( int linha=0, alturaTijolo=28+10;  linha < 7; linha++){
                    for( int coluna=0, larguraTijolo = 80+10;  coluna < 8; coluna++){
                            
                            // rosa, vermelha, laranja, amarela, verde, azul, roxo
                            String cor="", newPath="", pathIMG = "C:\\Users\\Patrick\\Documents\\NetBeansProjects\\BreakoutPOO\\src\\imagens\\";
                            switch(linha){
                                  case 0:  cor = "rosa";  newPath = pathIMG.concat("rosa.png");  break;
                                  case 1:  cor = "vermelho"; newPath =  pathIMG.concat("vermelho.png"); break;
                                  case 2:  cor = "laranja"; newPath = pathIMG.concat("laranja.png");  break;
                                  case 3:  cor = "amarelo";  newPath = pathIMG.concat("amarelo.png");  break;
                                  case 4:  cor = "verde"; newPath = pathIMG.concat("verde.png"); break;
                                  case 5:  cor = "azul"; newPath = pathIMG.concat("azul.png"); break;
                                  case 6:  cor = "roxo";  newPath = pathIMG.concat("roxo.png"); break;
                            }
                        
                            Tijolo tijolo = new Tijolo( 50+(coluna * larguraTijolo),  100 + (linha*alturaTijolo) ,  new JLabel(), cor);
                            tijolo.carregaImagem(newPath);
                            Dimension dimensaoTijolo = tijolo.obterComponenteTijolo().getMinimumSize();
                            tijolo
                                    .obterComponenteTijolo()
                                        .setBounds(
                                                tijolo.getX(), // getX() pertence a super-classe Sprite!
                                                    tijolo.getY(), 
                                                        dimensaoTijolo.width, 
                                                             dimensaoTijolo.height
                                    );
                            
                            Game.listaTijolos.add( tijolo );
                    }
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            int[][] coordBuffs = new int[][]{  { (Setup.WIDTH/2), 20 },    { (Setup.WIDTH)-100, 20 },   { (Setup.WIDTH)-100, 500 },  { Setup.WIDTH/2, 430 } }; 
            
              // CRIANDO 4 BUFFs  (OU MOEDAS)
            for ( int b= 0;  b < coordBuffs.length; b++  ){
                
                   Buff buff = new Buff( coordBuffs[b][0], coordBuffs[b][1], new JLabel() ) ;
                   Game.listaBuffs.add(  buff  );
                   buff.carregaImagem("C:\\Users\\Patrick\\Documents\\NetBeansProjects\\BreakoutPOO\\src\\imagens\\coin.png");
                   
                   Dimension dimensaoBuff = buff.obterComponenteBuff().getPreferredSize();   
                   buff.obterComponenteBuff()
                                    .setBounds(   // SETANDO A HITBOX DA LABEL
                                            buff.getX(), 
                                                  buff.getY(),  
                                                        dimensaoBuff.width,  
                                                              dimensaoBuff.height 
                                    );  
                   
                    buff.setImageWidth( dimensaoBuff.width); 
                    buff.setImageHeight( dimensaoBuff.height );
            }
            
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           
         
            // CRIANDO 10 DEBUFFs (OU POWER UPS)
            for( int i = 0; i < 10; i++ ){
                    int[] xy = Game.gerarMatrizCoordenadas(); // coordenada aleatoria 1
                
                    ElementoConsumivel debuff = new Debuff(     xy[0],    xy[1],    new JLabel()   );
                    Game.listaDebuffs.add( debuff );
                   // ElementoConsumivel buff = Game.listaBuffs.get( index );
                    debuff.carregaImagem("C:\\Users\\Patrick\\Documents\\NetBeansProjects\\BreakoutPOO\\src\\imagens\\debuff.png");
                    Dimension dimensaoDeBuff  = debuff.obterComponenteDebuff().getPreferredSize();
                    debuff.obterComponenteDebuff().setBounds( debuff.getX(), debuff.getY(), dimensaoDeBuff.width, dimensaoDeBuff.height );
                    debuff.setImageWidth(dimensaoDeBuff.width);
                    debuff.setImageHeight(dimensaoDeBuff.height);
            }
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
          
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            bola.carregaImagem("C:\\Users\\Patrick\\Documents\\NetBeansProjects\\BreakoutPOO\\src\\imagens\\bola.png");
            raquete.carregaImagem("C:\\Users\\Patrick\\Documents\\NetBeansProjects\\BreakoutPOO\\src\\imagens\\Raquete.png");
            // A imagem sempre deve ser inserida primeiro no JLabel e depois é que deve se acessado o seu método "getPreferredSize() e setBounds()"
            
            Dimension dimensaoBola = bola.obterComponenteBola().getPreferredSize();   // funciona
            bola .obterComponenteBola () 
                        .setBounds( 
                                            bola.getX(), 
                                                   bola.getY(), 
                                                           dimensaoBola.width+3,
                                                                   dimensaoBola.height+3
                                            );  //funciona
        //    bola.obterComponenteBola().setSize(dimeb.width, dimeb.height);  //nao funciona
        //    bola.obterComponenteBola().setLocation(100, 100);  //nao funciona
            bola.setImageWidth( dimensaoBola.width); 
            bola.setImageHeight( dimensaoBola.height );
            
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
            //raquete.obterComponenteRaquete().setSize(new Dimension(247, 40));
            Dimension dimensaoRaquete = raquete.obterComponenteRaquete().getPreferredSize(); //getSize(); 
            raquete.setImageWidth( dimensaoRaquete.width);
            raquete.setImageHeight( dimensaoRaquete.height);
            raquete .obterComponenteRaquete() 
                    .setBounds(
                                    raquete.getX(), 
                                            raquete.getY(),
                                                    dimensaoRaquete.width, 
                                                                dimensaoRaquete.height);
           
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           Game.painel =  new JPanel();
           
       
            Game.painel.setLayout(null); //Reinicia o layout e tira o padrão dos itens ficarem no topo
            Game.painel.add ( bola.obterComponenteBola() );
            Game.painel.add ( raquete.obterComponenteRaquete() );
            
            
            /// ADICIONANDO OS TIJOLOS NO CENARIO
            for(Sprite ti : Game.listaTijolos){
                      Game.painel.add( ti.obterComponenteTijolo());
            }
            
            /// ADICIONANDO OS DEBUFFS NO CENARIO
            for(ElementoConsumivel onDebuff : Game.listaDebuffs){
                      Game.painel.add( onDebuff.obterComponenteDebuff());
            }
            
            /// ADICIONANDO OS BUFFS NO CENARIO
            for(ElementoConsumivel oneBuff : Game.listaBuffs){
                      Game.painel.add( oneBuff.obterComponenteBuff());
            }
            
            
            
            Game.labelScoreNumeros = new JLabel( );
            Game.labelScore = new JLabel();
            labelScore.setText("Score");
            labelScore.setBounds(20, -50, 150, 150); // X, Y, WIDTH, HEIGHT
            labelScore.setForeground(Color.WHITE); // COR DA LETRA
            labelScore.setFont( new Font("Verdana", Font.BOLD, 18) );
            
            
            Game.painel.add(labelScore); // ADICIONANDO O LABEL QUE CONTÉM A PALABRA 'Score'
            Game.painel.add(Game.labelScoreNumeros);  // ADICIONANDO O LABEL QUE VAI VARIAR COM O SCORE
     
     
            try{
                    BufferedImage imagem = ImageIO.read( new File("C:\\Users\\Patrick\\Documents\\NetBeansProjects\\BreakoutPOO\\src\\imagens\\breakout game background castel.png") );
                    JLabel fundo = new JLabel( new ImageIcon( imagem));
                    fundo.setBounds(0, 0, Setup.WIDTH, Setup.HEIGHT);
                    Game.painel.add(fundo);
                    
            }catch ( IOException error){
                    JOptionPane.showMessageDialog(null, "Houve um erro ao tentar incorporar a image de fundo!!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    error.printStackTrace();
                    Game.painel.setBackground(Color.BLACK); 
                // CASO NAO SEJA POSSIVEL IMPORTAR A IMAGEM... O FUNDO T´ERÁ COR PRETA
            }
       
       
            
            // CONFIGURANDO A TELA:
            Game.tela = new JFrame("Breakout game");
            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tela.setBounds(300, 10, Setup.WIDTH, Setup.HEIGHT);  // X (DISTANCIA, DA JANELA DO JOGO PARA A PAREDE ESQUERDA), Y, width, height 
            tela.setSize( new Dimension(Setup.WIDTH, Setup.HEIGHT) );
        
             
            // ATIVANDO O CONTROLE DA RAQUETE
            tela.addKeyListener( (KeyListener) raquete); // A classe Raquete implementa a interface KeyListener, por isso pode adicionada ao método "addKeyListener()"
            
            // ADICIONANDO ELEMENTOS NA TELA:
            tela.add(Game.painel);
            tela.setResizable(false); // Nao pemite que a tela seja redimensionada!
            tela.setVisible(true);
            gameLoop();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    static void gameLoop() {
            int segundos  =0;

            try{
                while (Game.jogando){ 
                    
                        Game.bola.desenhar();
                        Game.bola.atualizar();
                        Game.raquete.desenhar();
                        Game.desenharPontos();
                        
                       
                        Game.verificarColisao( (Bola)  Game.bola); // VERIFICA COLISÃO DA BOLA COM AS PAREDES
                        Game.verificarColisao( Game.bola, Game.listaDebuffs); // VERIFICA COLISAO ENTRE BOLA E DEBUFFs
                        Game.verificarColisao ( (Bola) Game.bola, Game.listaTijolos  ); // VERIFICA COLISÃO DA BOLA COM OS "TIJOLOS"
                        Game.verificarColisao( Game.listaBuffs);// VERIFICA COLISAO ENTRE BOLA E BUFFs
                        
                        for(ElementoConsumivel ec : Game.listaDebuffs){
                             if (segundos == 30) {// A CADA UM SEGUNDO A POSICAO DOS POWER UPS SAO ATUALIZADOS
                                       ec.atualizar();
                                       segundos = 0;
                                     //  System.out.println("posicao atualizada");
                             }
                             ec.desenhar();
                        }
                        
                        Game.seVenceu();
                        
                        Thread.sleep(10);
                       ++segundos;
                        // O LOOP É REINICIADO A CADA 10 MILISSEGUNDOS!
                }

            }catch(InterruptedException e){
                      System.out.println("Houve um erro na execução do loop principal do jogo!!!!");
            }
    }
    
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    static void verificarColisao(Bola bola){
           //  System.out.println("X2 da bola: "+ bola.getX2());
          
           // VERIFICANDO COLISAO DA BOLA COM TODAS AS PAREDES DO JOGO
            if( bola.getY() <= 0){
                 bola.setDirY(-1);
            }
            // ALTERANDO A DIRECAO DA BOLA HORIZONTALMENTE
            else if( (bola.getX() <= 0)  ||  ( (bola.getX2() ) >= (Setup.WIDTH-10) )  ){
                 bola.setDirX(-1);

            // ALTERANDO A DIRECAO DA BOLA VERTICALMENTE
            }else if( (bola.getY() <= 0)   ){
                 bola.setDirY(-1);
                    
            }else if (bola.getY2() >= Setup.HEIGHT-30){
                   Game.imprimirMensagemFinal("PERDEU");
            }
           
           // VERIFICANDO COLISAO DA BOLA COM A RAQUETE:
           if( 
               (bola.getY2() >= raquete.getY()) && 
                   (bola.getY() <= raquete.getY2())  && 
                         (bola.getX2()  > raquete.getX()) && 
                             (bola.getX() < raquete.getX2()  )             
                                  ){      
                                            bola.setDirY(-1);   // ALTERA A DIRECAO DA BOLA
                                            bola.setY(  Game.raquete.getY() - bola.getImageHeight()); 
                                            bola.setY2(  Game.raquete.getY());  
                                        // A BOLA É DESLOCADA DE FORMA A  FICAR TANGENTE 
                                        // À RAQUETE CASO A ULTRAPASSE
                                            
           }
           
    }
///////////////////////////////////////////////////////////////////////////////////////////
    
 
    
///////////////////////////////////////////////////////////////////////////////////////////
    // BOLA E TIJOLOS
    private static void verificarColisao(Bola bola, ArrayList<Sprite> tijolos){
        
        for( Sprite tijolo : tijolos){ // VERIFICANDO COLISÃO DA BOLA COM CADA TIJOLO
              
              // realizando o "downcasting"/especializando o tipo do objeto
                  Tijolo tlo = (Tijolo) tijolo; // TROCANDO O TIPO DO TIJOLO DE "SPRITE" PARA "TIJOLO" PARA ASSIM ACESSAR O MÉTODO "getDestrutiel()"
                 
                  if ( tlo.getDestruido()==false &&  Game.isCollided(  bola,  (Tijolo) tijolo )){ // SE COLIDIRAM, E O TIJOLO É DESTRUTÍVEL ENTÃO O MESMO DESAPARECE
                           tlo.obterComponenteTijolo().setVisible(false); // O TIJOLO FICA INVISIVEL APOS A COLISAO
                           tlo.setDestruido(true);// TORNANDO O TIJOLO INDESTRUTÍVEL DEPOIS QUE ELE É APAGADO DA TELA PARA QUE ELE NÃO CONTABILIZE PONTOS
                           // DEPOIS QUE DESTRUIDO O TIJOLO NAO PODE MAIS COLIDIR COM A BOLA
                  };
        }
    }
    
    
///////////////////////////////////////////////////////////////////////////////////////////
    // BOLA E DEBUFFS
    private static void verificarColisao(Sprite bol ,  ArrayList<ElementoConsumivel> debs){
               
        for ( ElementoConsumivel debuff  : debs){
                if (  (debuff.getEliminado()==false)  &&  (Game.isCollided( bol, (Debuff) debuff))  ){
                  
                        Bola bola = (Bola) bol; //downcasting  => CONVERTENDO O OBJETO DA SUPER-CLASSE "Sprite" PARA SUB-CLASSE "Bola"
                        debuff.setEliminado(true); 
                        debuff.obterComponenteDebuff().setVisible(false);
                        bola.setVelocidade(1.8); // A VELOCIDADE AUMENTA EM 2.5x  CASO A BOLA COLIDA COM O DEBUFF
                }
        }
    }
    
    
    
///////////////////////////////////////////////////////////////////////////////////////////
    // BOLA E BUFFS
    private static void verificarColisao( ArrayList<ElementoConsumivel> buffs){
               
        for ( ElementoConsumivel buff  : buffs){
                if (  (buff.getEliminado()==false)  &&  (Game.isCollided( Game.bola, (Buff) buff))  ){
                        buff.setEliminado(true); 
                        buff.obterComponenteBuff().setVisible(false);
                        Game.score +=200;  // O BUFF INCREMENTA 200 PONTOS NOS SCORES!
                }
        }
    }
///////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    private static boolean isCollided(Bola bola, Tijolo ti){ // EXEMPLO DE SOBRECARGA DO MÉTODO "isCollided()"
                Area bolaHitbox = new Area( bola.obterComponenteBola().getBounds()  );
                Area tijoloHitbox = new Area( ti.obterComponenteTijolo().getBounds()  );
                
                 // CASO A HITBOX DA BOLA TOQUE NA HITBOX DE "TIJOLO" É RETORNADO O VALOR "TRUE"
                if ( bolaHitbox.intersects( tijoloHitbox.getBounds2D() )){
                       Game.score+=1; // O SCORE SÓ INCREMENTA EM UM PONTO CASO A BOLA COLIDA COM OS "TIJOLOS"
                       return true; 
                }else
                       return false;
    }
    
 ///////////////////////////////////////////////////////////////////////////////////////////
    private static boolean isCollided(Sprite bola, Debuff debuff){  // EXEMPLO DE  MAIS UMA SOBRECARGA DO MÉTODO "isCollided()"
                Area bolaHitbox = new Area( bola.obterComponenteBola().getBounds()  );
                Area debuffHitbox = new Area( debuff.obterComponenteDebuff().getBounds()  );
                
                 // CASO A HITBOX DA BOLA TOQUE NA HITBOX DE "TIJOLO" É RETORNADO O VALOR "TRUE"
                if ( bolaHitbox.intersects( debuffHitbox.getBounds2D() ))
                        return true; 
                else
                       return false;
    }
    
///////////////////////////////////////////////////////////////////////////////////////////
     private static boolean isCollided(Sprite bola, Buff buff){  // EXEMPLO DE MAIS UMA SOBRECARGA DO MÉTODO "isCollided()"
                Area bolaHitbox = new Area( bola.obterComponenteBola().getBounds()  );
                Area buffHitbox = new Area( buff.obterComponenteBuff().getBounds()  );
                
                 // CASO A HITBOX DA BOLA TOQUE NA HITBOX DE "TIJOLO" É RETORNADO O VALOR "TRUE"
                if ( bolaHitbox.intersects( buffHitbox.getBounds2D() ))
                        return true; 
                else
                       return false;
    }
    
///////////////////////////////////////////////////////////////////////////////////////////
    public static int[] gerarMatrizCoordenadas(){
        
            // Criando matriz de 8 linhas e 2 colunas (8x2)
            int[][] matrizValoresPossiveis = new int[][]{ 
                { 50 , 400 },
                {130,  400 },
                {210,  400 },
                {290, 400 },
                {370, 500 },
                {450, 500 },
                {530, 500 },
                {610, 500 }
           };
        
            int X =   matrizValoresPossiveis [ Game.gerar.nextInt(8)] [0];
            int Y =  matrizValoresPossiveis [ Game.gerar.nextInt(8)] [1];
            return  new int[]{X, Y}; 
    }
///////////////////////////////////////////////////////////////////////////////////////////
    
    
    private static void seVenceu(){
            int buffsEliminados = 0, deBuffsEliminados=0, tijolosEliminados=0;
            
            for ( ElementoConsumivel debuff :  Game.listaDebuffs  ){
                     if ( debuff.getEliminado() )
                          ++ deBuffsEliminados;
            }
            
             for ( ElementoConsumivel buff :  Game.listaBuffs  ){
                     if ( buff.getEliminado() )
                           ++buffsEliminados;
            }
             
             
             for ( Sprite til :  Game.listaTijolos  ){
                     Tijolo tijolo = (Tijolo) til; // FAZENDO UM DOWNCASTING (CONVERTENDO OBJETO DE "SPRITE" PARA "TIJOLO")
                     
                     if ( tijolo.getDestruido() )
                            ++tijolosEliminados;
             }
            
             
            if (  (buffsEliminados==Game.listaBuffs.size() )  &&
                           (deBuffsEliminados==Game.listaDebuffs.size())  &&
                                    (tijolosEliminados==Game.listaTijolos.size() )    ){
                                                    Game.imprimirMensagemFinal("VENCEU");
             } 
            
    }
    
    
    
///////////////////////////////////////////////////////////////////////////////////////////
    private static void desenharPontos(){
            JLabel numeros = Game.labelScoreNumeros;
            String numeroScore = "000";

            if ( Game.score > 0 && Game.score <10)
                        numeroScore = "00"+Game.score;
            else if ( Game.score >= 10 && Game.score <100 )
                        numeroScore = "0"+Game.score;
            else if ( Game.score >= 100 && Game.score <1000 )
                        numeroScore = String.valueOf( Game.score );
                                                // convertendo score pra String

            numeros.setText(numeroScore);
            numeros.setBounds(17, -5, 120, 120);
            numeros.setForeground(Color.WHITE);
            numeros.setFont(new Font("Verdana", Font.BOLD, 44));
      }
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    private static  void imprimirMensagemFinal(String resultado){
             int decisao = 0;
        
             if (resultado =="PERDEU")
                         decisao = JOptionPane.showConfirmDialog(null, " VOCÊ PERDEU!!!! \n DESEJA REINICIAR O JOGO? " , "AVISO", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
             
             else if ( resultado == "VENCEU")
                         decisao = JOptionPane.showInternalConfirmDialog(null, "PARABÉNS!!  \n  DESEJA REINICIAR O JOGO?",  "UUUAUUU! VOCÊ VENCEU !!!!!", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
       
             
             switch(decisao){  // variable X might not have been initialized
                            case JOptionPane.YES_OPTION:
                                 Game.tela.dispose();
                                 Game.startSetup(); // REINICIA O JOGO A PARTIR DO SETUP
                                 break;
                                 
                            case JOptionPane.NO_OPTION:
                                 Game.jogando = false; // PARA O LOOP DO JOGO
                                 Game.tela.dispose(); // FECHA A JANELA
                                 System.exit(0); // ENCERRA A EXECUÇÃO DO JOGO
                                 break;
            }
      }
    
}




//non-static variable "this" cannot be referenced from a static context