package src;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//import java.awt.event.KeyEvent;

public class Raquete extends Sprite implements KeyListener{
    int velocidade = 30;
    private JLabel componente;
    
    public Raquete(int X, int Y, int imageWidth, int imageHeight, JLabel lab) {
            super(X, Y, imageWidth, imageHeight);
            this.componente = lab;
    //        this.componente.addKeyListener(this);
    }
    
    @Override
    public void carregaImagem(String imgPath){
            // var ii = new ImageIcon();
            // imagemArq = ii.getImage();
            
            /*
            BufferedImage bi;
            try{
                      bi = ImageIO.read( new File(imgPath) );
                      this.componente.setIcon(  new ImageIcon(bi) );
            }catch(IOException e){
                     System.out.println(e);
            }*/
            
            super.setImage( new ImageIcon(imgPath) );
           this.componente.setIcon(  new ImageIcon(imgPath) );//super.getImage()
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
    public void keyTyped(KeyEvent event) {
         int key = event.getKeyCode();

         if (  (key == KeyEvent.VK_D)  ||  (key == KeyEvent.VK_RIGHT)   ){
                int X1 = super.getX() + this.velocidade;
                int X2 = super.getX() + super.getImageWidth() + this.velocidade;
               
                if ( X2 <= Setup.WIDTH) {
                       System.out.println("pra esquerda");
                       super.setX(X1);  
                       super.setX2(X2);
                }
                
                
         }  else if ( (key == KeyEvent.VK_A)  ||  (key == KeyEvent.VK_LEFT)  ){
                int X1 = super.getX() - this.velocidade;
                int X2 = X1 + super.getImageWidth();
               
                if ( X1 >= 0) {
                       System.out.println("pra direita");
                       super.setX(X1);  
                       super.setX2(X2);
                }
         }
    }

    
    @Override
     public void atualizar(){
            //...
     }
   
    @Override
    public void desenhar(){
        //  System.out.println("Tamanho da imagem (super): "+super.getImageWidth());
            System.out.println("Tamanho da imagem (this): "+this.getImageWidth());
        
           int[] XY = super.getPosicao();
       //    this.componente.setBounds ( XY[0],  XY[1], super.getImageWidth(), super.getImageHeight());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
    public void keyPressed(KeyEvent arg0) {  }
    @Override
    public void keyReleased(KeyEvent arg0) {  }


    // MÉTODOS DA CLASSE "SPRITE"
    @Override
    public JLabel obterComponenteBola() { return null; }
    @Override
    public void setarComponenteBola(JLabel c) { }
    @Override
    public JLabel obterComponenteTijolo() { return null; }
    @Override
    public void setarComponenteTijolo(JLabel c) { }
}
