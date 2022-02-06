package src;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.BufferStrategy;


class Game implements Setup {
    
    public static int score;
    public static String level;
    public static Sprite bola; // OU Bola bola
    public static Sprite raquete; // OU Raquete raquete
    public static ArrayList<PowerUp> listaPowerUps;
    public static ArrayList<Sprite> listaTijolos;   // OU: ArrayList<Tijolo>
    public static JPanel painel;
    public static JLabel labelScore;
    public static JLabel labelScoreNumeros; // JLabel por onde serão exibidos os números
   
// public static BufferStrategy strategy;

    //FUNCAO PRINCIPAL DO JOGO
    public static void main(String[] args) throws InterruptedException{
          Game.startSetup();
    }
    
    static void startSetup() {
            score = 000;
          //  level = Setup.level;
            bola = new Bola( Setup.INICIA_BOLA_X , Setup.INICIA_BOLA_Y, 50, 50, new JLabel());
            raquete = new Raquete( Setup.INICIA_RAQUETE_X, Setup.INICIA_RAQUETE_Y, 100, 100, new JLabel() );
            Game.listaTijolos = new ArrayList<>(); 
            
            // 7 linhas com 8 colunas cada (80x28)
            for( int linha=0, alturaTijolo=28;  linha < 7; linha++){
                    for( int coluna=0, larguraTijolo = 80;  coluna < 8; coluna++){
                            
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
                        
                            Tijolo tijolo = new Tijolo( 10+(coluna * larguraTijolo),  100 + (linha*alturaTijolo) ,  new JLabel(), cor);
                            tijolo.carregaImagem(newPath);
                            Dimension dimensaoTijolo = tijolo.obterComponenteTijolo().getMinimumSize();
                            tijolo
                                    .obterComponenteTijolo()
                                        .setBounds(
                                                tijolo.getX(), 
                                                    tijolo.getY(), 
                                                        dimensaoTijolo.width, 
                                                             dimensaoTijolo.height
                                    );
                            
                            Game.listaTijolos.add( tijolo );
                    }
            }
            
            
            
            
           
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
           
      
            Game.painel = new JPanel();
            Game.painel.setLayout(null); //Reinicia o layout e tira o padrão dos itens ficarem no topo
            Game.painel.add ( bola.obterComponenteBola() );
            Game.painel.add ( raquete.obterComponenteRaquete() );
            
            for(Sprite ti : Game.listaTijolos){
                      Game.painel.add( ti.obterComponenteTijolo());
            }
            
            Game.labelScoreNumeros = new JLabel();
            Game.labelScore = new JLabel();
            labelScore.setText("Score");
            labelScore.setBounds(20, -50, 150, 150);
            labelScore.setForeground(Color.WHITE);
            labelScore.setFont(new Font("Verdana", Font.BOLD, 18));
            
            Game.painel.add(labelScore); // ADICIONANDO O LABEL DA PALAVRA 'Score'
            Game.painel.add(Game.labelScoreNumeros);  // ADICIONANDO O LABEL DO NÚMERO DE PONTOS
            
        // Game.painel.setPreferredSize(new Dimension(600, 600));
       //  Game.painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            Game.painel.setBackground(Color.BLACK);
            
            // CONFIGURANDO A TELA:
            JFrame tela = new JFrame("Breakout game");
            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tela.setBounds(500, 10, Setup.WIDTH, Setup.HEIGHT);  // X, Y (localizacao) width, height (tamanho do painel)
            tela.setSize(new Dimension(Setup.WIDTH, Setup.HEIGHT));
           // tela.setBackground(Color.black ); //Nao funciona
            tela.getContentPane().setBackground(Color.GRAY);
            
            tela.addKeyListener( (KeyListener) raquete); // A classe Raquete implementa a interface KeyListener
            
            // ADICIONANDO ELEMENTOS NA TELA:
            //tela.getContentPane().add( bola.obterComponenteBola());
            //tela.getContentPane().add( raquete.obterComponenteRaquete());
            tela.add(Game.painel);
            tela.setResizable(false);
           // tela.repaint();
           // tela.revalidate();
            tela.setVisible(true);
            gameLoop();
    }

    static void gameLoop() {
            int segundo  =0;

            try{
                while (true){ 
                   //     System.out.println(segundo);
                     //   segundo++;
                        Game.bola.desenhar();
                        Game.bola.atualizar();
                        Game.raquete.desenhar();
                        Game.verificarColisao( (Bola)  Game.bola);
                        Game.desenharPontos();
                        Thread.sleep(10);
                }

            }catch(InterruptedException e){
                      System.out.println("Houve um erro na execução da Thread!!!!");
            }
    }
    
    
    static void verificarColisao(Bola bola){
         //  System.out.println("X2 da bola: "+ bola.getX2());
          
           // VERIFICANDO COLISAO DA BOLA COM AS PAREDES
           if( (bola.getX() <= 0)  ||  ( (bola.getX2() ) >= (Setup.WIDTH-10) )  )
                bola.setDirX(-1);
           
           else if( (bola.getY() <= 0)  ||  (( bola.getY2() ) >= (Setup.HEIGHT-28) )  )
                bola.setDirY(-1);
           
           
           // VERIFICANDO COLISAO DA BOLA COM A RAQUETE:
           if( (bola.getY2() >= raquete.getY())  &&   (bola.getX2()  > raquete.getX())  &&  (bola.getX() < raquete.getX2()  )   )
                bola.setDirY(-1);
    }
    
    
    private static void desenharPontos(){
        
            JLabel numeros = Game.labelScoreNumeros;
            String numeroScore = "000";

            if ( Game.score > 0 && Game.score <10)
                        numeroScore = "00"+Game.score;
            else if ( Game.score >= 10 && Game.score <100 )
                        numeroScore = "0"+Game.score;
            else if ( Game.score >= 100 && Game.score <1000 )
                        numeroScore = String.valueOf( Game.score );

            numeros.setText(numeroScore);
            numeros.setBounds(17, -5, 120, 120);
            numeros.setForeground(Color.WHITE);
             //   score.setBackground(Color.BLUE);
            numeros.setFont(new Font("Verdana", Font.BOLD, 44));
      }
    
}
