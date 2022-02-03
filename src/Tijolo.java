import javax.swing.ImageIcon;

public class Tijolo extends Sprite {
    
    private boolean destruido;

public Tijolo(int x, int y) {

        iniciaTijolo(x, y);
}

private void iniciaTijolo(int x, int y) {

    this.PosX = x;
    this.PosY = y;

    destruido = false;

    carregaImagem();
    getImageDimensions();
}

private void carregaImagem() {
    var ii = new ImageIcon();
    imagemArq = ii.getImage();
}

boolean foiDestruido() {

    return destruido;
}

void setDestruido(boolean val) {

    destruido = val;
}
}