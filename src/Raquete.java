import javax.swing.ImageIcon;
import java.awt.event.KeyEvent;

public class Raquete extends Sprite{
    private int dX;

    public Raquete() {
        iniciaRaquete();
    }

    public void iniciaRaquete(){
        carregaImagem();
        getImageDimensions();
        resetaR();
    }

    private void carregaImagem() {

        var ii = new ImageIcon();
        imagemArq = ii.getImage();

    }
    
    void moveR () {

        PosX += dX;

        if ( PosX <= 0) {

            PosX =0;
        }

        if ( PosX >= Setup.WIDTH -imageWidth) {
            PosX = Setup.WIDTH - imageWidth;
        }

    }

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
}
