import javax.swing.ImageIcon;

public class Tijolo extends Sprite {
    
    private boolean destruido;

    public Tijolo(int x, int y, String cor) {
        iniciaTijolo(x, y);

        //CORES
        if (cor=="amarelo") {
            carregaImagem("src/Sprites/TIJOLOS/amarelo.png");
        }

        if (cor=="azul") {
            carregaImagem("src/Sprites/TIJOLOS/azul.png");
        }

        if (cor=="laranja") {
            carregaImagem("src/Sprites/TIJOLOS/laranja.png");
        }

        if (cor=="rosa") {
            carregaImagem("src/Sprites/TIJOLOS/rosa.png");
        }

        if (cor=="roxo") {
            carregaImagem("src/Sprites/TIJOLOS/roxo.png");
        }

        if (cor=="verde") {
            carregaImagem("src/Sprites/TIJOLOS/verde.png");
        }

        if (cor=="vermelho") {
            carregaImagem("src/Sprites/TIJOLOS/vermelho.png");
        }

    }

    private void iniciaTijolo(int x, int y) {

        this.PosX = x;
        this.PosY = y;

        destruido = false;
        getImageDimensions();
    }

    private void carregaImagem(String cor) {
        var ii = new ImageIcon(cor);
        imagemArq = ii.getImage();
    }

    boolean foiDestruido() {

        return destruido;
    }

    void setDestruido(boolean val) {

        destruido = val;
    }
}