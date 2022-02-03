import javax.swing.ImageIcon;

public class Bola extends Sprite {
    private int dirX;
    private int dirY;

    public Bola() {
        iniciaBola();
        }

    private void iniciaBola() {
        dirX =1;
        dirY= -1;

        carregaImagem();
        getImageDimensions();
        resetaB();
        }

    private void carregaImagem() {
        var ii = new ImageIcon();
        imagemArq = ii.getImage();
    }

    void moveB() {
        PosX += dirX;
        PosY += dirY;

        if (PosX == 0) {
            setDirX(-1);
        }

        if (PosX == Setup.WIDTH - imageWidth) {
            System.out.println(imageWidth);
            setDirX(-1);
        }

        if ( PosY == 0 ) {
            setDirY(1);
        }
    }

    private void resetaB() {
        PosX = Setup.INICIA_BOLA_X;
        PosY = Setup.INICIA_BOLA_Y;
    }

    void setDirX(int x) {
        dirX = x;
    }

    void setDirY(int y) {
        dirY =y;
    }
}
