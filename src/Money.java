import javax.swing.ImageIcon;

class Money extends ElementoConsumivel{
    
    public Money(int X, int Y, int imageWidth, int imageHeight){
        super(X, Y, imageWidth, imageHeight);
    }

    public void carregaImagem(){
        // var ii = new ImageIcon();
        // imagemArq = ii.getImage();
        super.setImage(new ImageIcon("caminho da raquete"));
    }

}