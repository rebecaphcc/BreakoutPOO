package src;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Tijolo extends Sprite  {

    private String cor;
    private boolean destruido;
    private JLabel componente;
    
    // CONTRUTOR 1
    public Tijolo(int X, int Y, int imageWidth, int imageHeight,  String cor) {
            super(X, Y, imageWidth, imageHeight);
         //   super.setPosicao(x, y);
            iniciaTijolo(cor);
    }
    
    // CONSTRUTOR 2
    public Tijolo(int X, int Y, JLabel comp, String cor) { 
            super(X, Y);
            this.componente = comp;
            iniciaTijolo(cor);
    }

    private void iniciaTijolo(String c) {
            this.destruido = false;
            this.cor = c;
          //  getImageDimensions();
    }

    @Override
    public void carregaImagem(String imgPath){
            super.setImage(new ImageIcon(imgPath) );
            this.componente.setIcon(new ImageIcon(imgPath));
    }

    @Override
    public JLabel obterComponenteTijolo(){
            return this.componente;
    }
    @Override
    public void setarComponenteTijolo(JLabel c){
            this.componente = c;
    }


    boolean getDestruido() { return this.destruido; }

    void setDestruido(boolean val) { this.destruido = val; }

    
    
    
    
    
    @Override
    public JLabel obterComponenteBola() { return null; }
    @Override
    public void setarComponenteBola(JLabel c) {   }
    @Override
    public JLabel obterComponenteRaquete() { return null; }
    @Override
    public void setarComponenteRaquete(JLabel c) {  }
}