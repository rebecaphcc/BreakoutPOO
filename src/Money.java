package src;
import javax.swing.ImageIcon;

class Money extends ElementoConsumivel{
    
    public Money(int X, int Y, int imageWidth, int imageHeight){
        super(X, Y, imageWidth, imageHeight);
    }

    @Override
    public void carregaImagem(String imgPath){
        // var ii = new ImageIcon();
        // imagemArq = ii.getImage();
        super.setImage(new ImageIcon(imgPath));
    }

}
