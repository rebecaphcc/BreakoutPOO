package src;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Tijolo extends Sprite  {

    private String cor;
    private boolean destruido;
    private JLabel componente;
    
    public Tijolo(int X, int Y, int imageWidth, int imageHeight, String cor) {
            super(X, Y, imageWidth, imageHeight);
         //   super.setPosicao(x, y);
            iniciaTijolo(cor);
    }

    private void iniciaTijolo(String c) {
            this.destruido = false;
            this.cor = c;
            //this.carregaImagem("ddds");
            getImageDimensions();
    }

    @Override
    public void carregaImagem(String imgPath){
            // var ii = new ImageIcon();
            // imagemArq = ii.getImage();
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
    public JLabel obterComponenteBola() {  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setarComponenteBola(JLabel c) { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public JLabel obterComponenteRaquete() { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setarComponenteRaquete(JLabel c) { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
}