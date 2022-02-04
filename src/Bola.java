import javax.swing.ImageIcon;

public class Bola extends Sprite {
    private int dirX = 1; //A bola começa o jogo subindo para o lado superior direito
    private int dirY = 1;

    //Construtor da classe
    public Bola(int X, int Y, int imageWidth, int imageHeight) {
        super(X, Y, imageWidth, imageHeight);
        this.iniciaBola(X, Y);
    }

    private void iniciaBola(int x, int y) {
        this.dirX = 1;
        this.dirY = -1;

      //  this.carregaImagem();
       // getImageDimensions();
      //  resetaB();
    }

    public void carregaImagem() {
       // var ii = new ImageIcon();
       // imagemArq = ii.getImage();
       super.setImage(new ImageIcon("caminho da bola"));
    }


    public void setDirX(int x) {
        this.dirX = x;
    }
    public void setDirY(int y) {
        this.dirY = y;
    }

/*
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
        PosX = Setup.INICIA_BOLAX;
        PosY = Setup.INICIA_BALL_Y;
    }
*/
    
}
