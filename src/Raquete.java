import javax.swing.ImageIcon;
//import java.awt.event.KeyEvent;

public class Raquete extends Sprite{
    int velocidade = 1;

    public Raquete(int X, int Y, int imageWidth, int imageHeight) {
        super(X, Y, imageWidth, imageHeight);
        //iniciaRaquete();
    }

    public void iniciaRaquete(){
        this.carregaImagem();
       // getImageDimensions();
       // resetaR();
    }

    //@Override
    public void carregaImagem(){
        // var ii = new ImageIcon();
        // imagemArq = ii.getImage();
        super.setImage(new ImageIcon("caminho da raquete"));
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
}
