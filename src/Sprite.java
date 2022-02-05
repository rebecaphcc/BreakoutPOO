package src;

//import java.awt.Image;
import java.awt.PopupMenu;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public abstract class Sprite {
    
    private int posX;
    private int posY;
    private int imageWidth;
    private int imageHeight;
    private ImageIcon imagemArq;
    //private String caminoImagem;

    public Sprite(int X, int Y, int imageWidth, int imageHeight){
        this.posX = X;
        this.posY = Y;
        this.imageWidth = imageWidth;
       // this.caminoImagem = imagePath;
    };

    
    protected void setX(int x) {
        this.posX = x;
    }

    protected int getX() {
        return this.posX;
    }

    protected void setY(int y) {
        this.posY = y;
    }

    int getY() {
         return this.posY;
    }
    
    public void setPosicao(int x, int y){
            this.posX = x;
            this.posY = y;
    }

    public int[] getPosicao(int x, int y){
            return new int[]{x, y};
    }
   

    // Método que sofrerá polimofismo dinâmico em tempo de execução
    public void carregaImagem(String imgPath){
            this.setImage(new ImageIcon(imgPath));
    }
    
    abstract public JLabel obterComponenteBola();
    abstract public void setarComponenteBola(JLabel c);
    abstract public JLabel obterComponenteTijolo();
    abstract public void setarComponenteTijolo(JLabel c);
    abstract public JLabel obterComponenteRaquete();
    abstract public void setarComponenteRaquete(JLabel c);
    
    
    

    public void atualizar(){ }
    
    public void desenhar(){ }
    
   
    public int getImageWidth() {
            return imageWidth;
    }

    public int getImageHeight() {
           return imageHeight;
    }

    public ImageIcon getImage() {
            return this.imagemArq;
    }
    public void setImage(ImageIcon img) {
            this.imagemArq = img;
    }

    /*
    public String getCaminoImagem(){
        return this.caminoImagem;
    }
    */





    Rectangle getRect() {
        return new Rectangle(this.posX, this.posY, this.imageWidth, this.imageHeight);
                //imagemArq.getWidth(null), imagemArq.getHeight(null));
    }

    public void getImageDimensions() {
      //  imageWidth = imagemArq.getWidth(null);
       // imageHeight = imagemArq.getHeight(null);

    }

}