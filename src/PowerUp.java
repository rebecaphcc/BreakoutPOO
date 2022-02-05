package src;
import javax.swing.ImageIcon;

class PowerUp extends ElementoConsumivel{

    public PowerUp(int X, int Y, int imageWidth, int imageHeight){
           super(X, Y, imageWidth, imageHeight);
    }

    @Override
    public void carregaImagem(String imgPath){
            // var ii = new ImageIcon();
            // imagemArq = ii.getImage();
            super.setImage(new ImageIcon(imgPath));
    }
    
    public void mudarPosicao(){
        
    }
}