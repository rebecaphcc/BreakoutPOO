package src;
import src.Setup;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static src.Game.raquete;


public class Raquete extends Sprite implements KeyListener{
    int velocidade = 15;
    private JLabel componente;
    private int deslocamento =  40;
            
    public Raquete(int X, int Y, int imageWidth, int imageHeight, JLabel lab) {
            super(X, Y, imageWidth, imageHeight);
            this.componente = lab;
         //   this.componente.addKeyListener(this);  // Leaking this in constructor
    }
    
    @Override
    public void carregaImagem(String imgPath){
            // var ii = new ImageIcon();
            // imagemArq = ii.getImage();
           super.setImage( new ImageIcon(imgPath) );
           this.componente.setIcon(  new ImageIcon(imgPath) );// OU : super.getImage()
    }

   
        @Override
        public JLabel obterComponenteRaquete() {
                return this.componente;
        }
        @Override
        public void setarComponenteRaquete(JLabel c) {
                this.componente = c;
        }
   
  
        
        @Override
         public void atualizar(){
                //...
         }
        @Override
        public void desenhar(){
                 int[] XY = super.getPosicao();
                 this.componente.setLocation(XY[0],  XY[1]);
                 // Esse não funciona:
                 // this.componente.setBounds ( XY[0],  XY[1], super.getImageWidth(), super.getImageHeight());
        }
    
        
        
        @Override
        public void keyTyped(KeyEvent event) {   }
                    
        @Override
        public void keyPressed(KeyEvent event) { 
                int key = event.getKeyCode();
                    
                if (  (key == KeyEvent.VK_D)  ||  (key == KeyEvent.VK_RIGHT)   ){
                           int X1 = raquete.getX() + this.deslocamento;
                           int X2 = raquete.getX2() +  this.deslocamento;  // raquete.getX() + raquete.getImageWidth() + 30;
                           
                           if ( X2 <= Setup.WIDTH-13) {
                                  raquete.setX (X1);  
                                  raquete.setX2 (X2);
                           }


                 }  else if ( (key == KeyEvent.VK_A)  ||  (key == KeyEvent.VK_LEFT)  ){
                           int X1 = raquete.getX() -  this.deslocamento;
                           int X2 = X1 + super.getImageWidth();

                           if ( X1 >= 2) {
                                  raquete.setX(X1);  
                                  raquete.setX2(X2);
                           }
                 }
        }
        
        @Override
        public void keyReleased( KeyEvent arg0) {  }
    
    
    
    
        
        
    
    // MÉTODOS DA CLASSE "SPRITE"
    @Override
    public JLabel obterComponenteBola() { return null; }
    @Override
    public void setarComponenteBola(JLabel c) { }
    @Override
    public JLabel obterComponenteTijolo() { return null; }
    @Override
    public void setarComponenteTijolo(JLabel c) { }
    @Override
     public JLabel obterComponenteDebuff() { return null;   }
     @Override
     public void setarComponenteDebuff(JLabel c) {   }
    @Override
    public JLabel obterComponenteBuff() { return null; }
    @Override
    public void setarComponenteBuff(JLabel c) { }
}



  /*
        // OUTRA MANEIRA DE LER AS IMAGENS:

            BufferedImage bi;
            try{
                      bi = ImageIO.read( new File(imgPath) );
                      this.componente.setIcon(  new ImageIcon(bi) );
            }catch(IOException e){
                     System.out.println(e);
            }
*/