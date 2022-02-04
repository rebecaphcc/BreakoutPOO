import javax.swing.ImageIcon;

public class Tijolo extends Sprite {
    
    private boolean destruido;

    public Tijolo(int X, int Y, int imageWidth, int imageHeight) {
        super(X, Y, imageWidth, imageHeight);
        iniciaTijolo(X, Y);
    }

    private void iniciaTijolo(int x, int y) {
 //       super.PosX = x;
//        super.PosY = y;
        this.destruido = false;

        this.carregaImagem();
        getImageDimensions();
    }


    public void carregaImagem(){
        // var ii = new ImageIcon();
        // imagemArq = ii.getImage();
        super.setImage(new ImageIcon("caminho da image do tijolo"));
    }




    boolean getDestruido() { return this.destruido; }

    void setDestruido(boolean val) { this.destruido = val; }
}