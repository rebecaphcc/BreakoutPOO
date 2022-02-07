package src;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Tijolo extends Sprite  {

    private String cor;
    private boolean destrutivel;
    private JLabel componente;
    private static Random decidirDestruicao = new Random();
    
    // CONTRUTOR 1
    public Tijolo (int X, int Y, int imageWidth, int imageHeight,  String cor) {
            super(X, Y, imageWidth, imageHeight); // PASSANDO AS VARIÁVEIS PARA O CONSTRUTOR DA SUPER CLASSE "Sprite"
         //   super.setPosicao(x, y);
            iniciaTijolo(cor);
    }
    
    // CONSTRUTOR 2
    public Tijolo (int X, int Y, JLabel comp, String cor) { 
            super(X, Y);// PASSANDO AS VARIÁVEIS PARA O CONSTRUTOR DA SUPER CLASSE "Sprite"
            this.componente = comp;
            iniciaTijolo(cor);
    }

    private void iniciaTijolo(String c) {
            setCor(c);
            boolean decisaoAleatoria  = Tijolo.decidirDestruicao.nextBoolean();
            setDestrutivel( decisaoAleatoria );
    }

    @Override
    public void carregaImagem(String imgPath){
            super.setImage(new ImageIcon(imgPath) );
       //     this.componente.setIcon(new ImageIcon(imgPath));
            ImageIcon iconeDiminuido = new ImageIcon(
                    new ImageIcon(imgPath).getImage().getScaledInstance(70, 20, Image.SCALE_DEFAULT)
            );
            this.componente.setIcon( iconeDiminuido);
    }

    @Override
    public JLabel obterComponenteTijolo(){
            return this.componente;
    }
    @Override
    public void setarComponenteTijolo(JLabel c){
            this.componente = c;
    }


    boolean getDestrutivel() { return this.destrutivel; }

    void setDestrutivel(boolean val) { this.destrutivel = val; }

    
    public String getCor(){
           return this.cor;
    }
    public void setCor(String a){
           this.cor = a;
    }
    
    
    
    
    @Override
    public JLabel obterComponenteBola() { return null; }
    @Override
    public void setarComponenteBola(JLabel c) {   }
    @Override
    public JLabel obterComponenteRaquete() { return null; }
    @Override
    public void setarComponenteRaquete(JLabel c) {  }
    @Override
     public JLabel obterComponentePowerUp( ){ return null; }
    @Override
     public void setarComponentePowerUp(JLabel c){}
}