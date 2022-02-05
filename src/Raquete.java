package src;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//import java.awt.event.KeyEvent;

public class Raquete extends Sprite{
    int velocidade = 1;
    private JLabel componente;
    
    public Raquete(int X, int Y, int imageWidth, int imageHeight, JLabel lab) {
            super(X, Y, imageWidth, imageHeight);
            //iniciaRaquete();
            lab.setLocation(X, Y);
            this.componente = lab;
    }

    public void iniciaRaquete(){
        this.carregaImagem("dds");
       // getImageDimensions();
       // resetaR();
    }

    @Override
    public void carregaImagem(String imgPath){
        // var ii = new ImageIcon();
        // imagemArq = ii.getImage();
        super.setImage(new ImageIcon(imgPath));
        this.componente.setIcon( new ImageIcon(imgPath));
    }
    
    @Override
    public JLabel obterComponenteRaquete() {
            return this.componente;
    }

    @Override
    public void setarComponenteRaquete(JLabel c) {
            this.componente = c;
    }

/*
    void moveR () {
        super.posX += this.velocidade;
        if ( posX >= Setup.WIDTH - imageWidth) {
            super.posX = Setup.WIDTH - imageWidth;
        }
    }
*/

/*
    void Tecla( KeyEvent e) {

        int key = e.getKeyCode();

        if (key==KeyEvent.VK_LEFT) {
            dX = -1;
        }

        if (key== KeyEvent.VK_RIGHT) {
            dX=1;
        }
    }

    void soltaTecla(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {

            dX = 0;

        }

        if (key == KeyEvent.VK_RIGHT) {

            dX = 0;
            
        }
    }

    private void resetaR() {

        PosX = Setup.INICIA_RAQUETE_X;
        PosY = Setup.INICIA_RAQUETE_Y;

    }
*/

    @Override
    public JLabel obterComponenteBola() { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setarComponenteBola(JLabel c) {  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public JLabel obterComponenteTijolo() { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setarComponenteTijolo(JLabel c) { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
