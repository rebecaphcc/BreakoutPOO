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
    private int posX2;
    private int posY2;
    private int imageWidth;
    private int imageHeight;
    private ImageIcon imagemArq;
    //private String caminoImagem;

    public Sprite(int X, int Y, int imageWidth, int imageHeight){
            this.posX = X;
            this.posY = Y;
            this.imageWidth = imageWidth;
            this.imageHeight = imageHeight;
           // this.caminoImagem = imagePath;
    };

    
    protected void setX (int x) {  this.posX = x;  }
    protected int getX () {   return this.posX;  }
    protected void setY (int y) { this.posY = y;  }
    int getY() { return this.posY;  }
    
    protected void setX2 (int x) {  this.posX2 = x;  }
    protected int getX2 () {   return this.posX2;  }
    protected void setY2 (int y) { this.posY2 = y;  }
    int getY2() { return this.posY2;  }
    
    
    
    public void setPosicao (int x, int y){
            this.posX = x;
            this.posY = y;
    }
    public int[] getPosicao (){
            return new int[]{ this.posX, this.posY};
    }
   public void setPosicao2 (int x, int y){
            this.posX2 = x;
            this.posY2 = y;
    }
    
    
    // Método que sofrerá polimofismo dinâmico em tempo de execução
    public void carregaImagem(String imgPath){
            this.setImage( new ImageIcon(imgPath) );
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
    public void setImageWidth(int larg) {
            this.imageWidth = larg;
            this.posX2 = getX() + larg;
    }
    public void setImageHeight(int alt) {
            this.imageHeight = alt;
            this.posY2 = getY2() + alt;
    }
    
    
    
    public ImageIcon getImage() {
            return this.imagemArq;
    }
    public void setImage(ImageIcon img) {
            this.imagemArq = img;
    }

    /*
    
     JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//application will be closed when you close frame
    frame.setSize(800,600);
    frame.setLocation(200,200);

    JFileChooser fc = new JFileChooser();
    if(fc.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION){
        BufferedImage img = ImageIO.read(fc.getSelectedFile());//it must be an image file, otherwise you'll get an exception
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(img));
        frame.getContentPane().add(label);
    }

    frame.setVisible(true);//showing up the frame
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