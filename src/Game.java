package src;

import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import java.awt.Color;
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
            raquete = new Raquete( Setup.INICIA_RAQUETE_X, Setup.INICIA_RAQUETE_Y, 50, 50, new JLabel() );
            
           // rosa, vermelha, laranja, amarela, verde, azul, roxo
            bola.carregaImagem("C:\\Users\\Patrick\\Documents\\NetBeansProjects\\BreakoutPOO\\src\\imagens\\bola.png");
            raquete.carregaImagem("C:\\Users\\Patrick\\Documents\\NetBeansProjects\\BreakoutPOO\\src\\imagens\\Raquete.png");
            // A imagem sempre deve ser inserida primeiro no JLabel!
            
            Dimension dimensaoBola = bola.obterComponenteBola().getPreferredSize();   // funciona
            bola.obterComponenteBola().setBounds(180, 600, dimensaoBola.width, dimensaoBola.height);  //funciona
        //    bola.obterComponenteBola().setSize(dimeb.width, dimeb.height);  //nao funciona
        //    bola.obterComponenteBola().setLocation(100, 100);  //nao funciona
            
            Dimension dimensaoRaquete = raquete.obterComponenteRaquete().getPreferredSize();
            raquete.obterComponenteRaquete().setBounds(130, 660, dimensaoRaquete.width, dimensaoRaquete.height);
        
            Game.painel = new JPanel();
            Game.painel.setLayout(null); //Reinicia o layout e tira o padrão dos itens ficarem no topo
            Game.painel.add(bola.obterComponenteBola());
            Game.painel.add(raquete.obterComponenteRaquete());
           
        //     Game.painel.setPreferredSize(new Dimension(600, 600));
          //  Game.painel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            Game.painel.setBackground(Color.BLACK);
            
            
            // CONFIGURANDO A TELA:
            JFrame tela = new JFrame("Breakout game");
            tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            tela.setBounds(500, 10, Setup.WIDTH, Setup.HEIGHT);  // X, Y (localizacao) width, height (tamanho do painel)
            tela.setSize(new Dimension(Setup.WIDTH, Setup.HEIGHT));
           // tela.setBackground(Color.black ); //Nao funciona
            tela.getContentPane().setBackground(Color.RED);
            
            // ADICIONANDO ELEMENTOS NA TELA:
            //tela.getContentPane().add( bola.obterComponenteBola());
            //tela.getContentPane().add( raquete.obterComponenteRaquete());
            tela.add(Game.painel);
            
            tela.setVisible(true);
            gameLoop();
    }

    static void gameLoop() {
            int segundo  =0;

            try{
                while (true){ 
                   //     System.out.println(segundo);
                     //   segundo++;
                        Thread.sleep(1000);
                }

            }catch(InterruptedException e){
                      System.out.println("Houve um erro na execução da Thread!!!!");
            }
    }
}
