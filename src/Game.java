package src;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

class Game implements Setup{
    
    public static int score;
    public static String level;
    public static Sprite bola; // OU Bola bola
    public static Sprite raquete; // OU Raquete raquete
    public static ArrayList<PowerUp> listaPowerUps;
    public static ArrayList<Sprite> listaTijolos; 
            // OU: ArrayList<Tijolo>
    public static JPanel painel;

    //FUNCAO PRINCIPAL DO JOGO
    public static void main(String[] args) throws InterruptedException{
          Game.startSetup();
    }
    
    static void startSetup() {
            score = 0;
            level = Setup.level;
            bola = new Bola( Setup.INICIA_BOLA_X , Setup.INICIA_BOLA_Y, 50, 50, new JLabel());
            raquete = new Raquete( Setup.INICIA_RAQUETE_X, Setup.INICIA_RAQUETE_Y, 100, 100, new JLabel() );
            
           // rosa, vermelha, laranja, amarela, verde, azul, roxo
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
            raquete.setImageWidth( dimensaoRaquete.height);
            raquete .obterComponenteRaquete() 
                    .setBounds(
                                    raquete.getX(), 
                                            raquete.getY(),
                                                    dimensaoRaquete.width, 
                                                                dimensaoRaquete.height);
           
            System.out.println("width da raquete: "+raquete.getImageWidth());
            System.out.println("height da raquete: "+raquete.getImageHeight());
            
            Game.painel = new JPanel();
            Game.painel.setLayout(null); //Reinicia o layout e tira o padrão dos itens ficarem no topo
            Game.painel.add ( bola.obterComponenteBola() );
            Game.painel.add ( raquete.obterComponenteRaquete() );
        //     Game.painel.setPreferredSize(new Dimension(600, 600));
          //  Game.painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            Game.painel.setBackground(Color.BLACK);
            
            
            // CONFIGURANDO A TELA:
            JFrame tela = new JFrame("Breakout game");
            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tela.setBounds(500, 10, Setup.WIDTH, Setup.HEIGHT);  // X, Y (localizacao) width, height (tamanho do painel)
            tela.setSize(new Dimension(Setup.WIDTH, Setup.HEIGHT));
           // tela.setBackground(Color.black ); //Nao funciona
            tela.getContentPane().setBackground(Color.GRAY);
            
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
                        
                        Thread.sleep(10);
                }

            }catch(InterruptedException e){
                      System.out.println("Houve um erro na execução da Thread!!!!");
            }
    }
    
    
    static void verificarColisao(Bola bola){
           // System.out.println("X: "+ bola.getX());
           // System.out.println("Y: "+ bola.getY());
          
           if( (bola.getX() <= 0)  ||  ( (bola.getX2() ) >= (Setup.WIDTH-10) )  )
                bola.setDirX(-1);
           
           else if( (bola.getY() <= 0)  ||  (( bola.getY2() ) >= (Setup.HEIGHT-28) )  )
                bola.setDirY(-1);
    }
}
