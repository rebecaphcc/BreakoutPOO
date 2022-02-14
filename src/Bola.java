package src;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Bola extends Sprite {
            private int dirX; 
            private int dirY; 
            private double velocidade;
            private JLabel componente;
    
    //Construtor da classe
    public Bola(int X, int Y, int imageWidth, int imageHeight, JLabel bolaLabel) {
        
            super(X, Y, imageWidth, imageHeight);
            this.componente = bolaLabel;
            this.iniciaBola ();
    }

    private void iniciaBola() {
            this.dirX = 1; // A bola inicia o jogo indo para a direita
            this.dirY = 1; // A bola inicia o jogo subindo
            setVelocidade(3);
    }
    
    public double getVelocidade(){
            return this.velocidade;
    }
    public void setVelocidade(double vel){
            this.velocidade += vel;
    }
    
    @Override
    public void carregaImagem(String imgPath) {
            super.setImage( new ImageIcon(imgPath) ); // ImageIcon.getImage()
            this.componente.setIcon(  new ImageIcon(imgPath) );//super.getImage()
           // super.getElemento().setLocation(X, Y);
    }
    
    @Override
    public JLabel obterComponenteBola(){
            return this.componente;
    }
    @Override
    public void setarComponenteBola(JLabel c){
            this.componente = c;
    }

    
    public void setDirX (int x) {
             this.dirX *= x;
    }
    public void setDirY (int y) {
             this.dirY *= y;
    }

    
    @Override
     public void atualizar(){
    //  Acessando o X e Y da bola que está na sua super classe "Sprite"
            int X = super.getX() ; 
            int Y = super.getY() ;

        /* A variável de direcao horizontal "dirX" 
            indica que se a bola estará indo para a esquerda 
           (valor -1) ou direita (valor 1)  */
            X += (getVelocidade() * this.dirX);
            Y += (getVelocidade() * this.dirY);

            int x2 = X + super.getImageWidth();
            int y2 =Y + super.getImageHeight();
            
            super.setPosicao (X, Y);
            super.setPosicao2 (x2, y2);
     }
   
     
    @Override
    public void desenhar(){
           int[] XY = super.getPosicao();
          this.componente.setLocation(XY[0], XY[1]);
          // MOVENDO A BOLA
    }
   
    
    
    
    
    
    
    
    
    @Override
    public JLabel obterComponenteTijolo() {  return  null;  }
    @Override
    public void setarComponenteTijolo(JLabel c) { }
    @Override
    public JLabel obterComponenteRaquete() {   return null; }
    @Override
    public void setarComponenteRaquete(JLabel c) {  }
    @Override
    public JLabel obterComponenteDebuff() { return null;   }
    @Override
    public void setarComponenteDebuff(JLabel c) {   }
    @Override
    public JLabel obterComponenteBuff() { return null; }
    @Override
    public void setarComponenteBuff(JLabel c) { }
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