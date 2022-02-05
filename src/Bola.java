package src;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import static src.Setup.WIDTH;

public class Bola extends Sprite {
    private int dirX; 
    private int dirY; 
    private int velocidade;
    private JLabel componente;
    
    //Construtor da classe
    public Bola(int X, int Y, int imageWidth, int imageHeight, JLabel bolaLabel) {
            super(X, Y, imageWidth, imageHeight);
            //bolaLabel.setLocation(X, Y) //Nao funciona, mas sim o setBounds()
            //bolaLabel.setLayout(null);
            
            this.componente = bolaLabel;
           // A imagem sempre deve ser inserida primeiro no JLabel:
       //     carregaImagem("C:\\Users\\Patrick\\Documents\\NetBeansProjects\\BreakoutPOO\\src\\imagens\\bola.png");
        //    Dimension dimeb = bolaLabel.getPreferredSize();
         //   bolaLabel.setBounds(170, 600, dimeb.width, dimeb.height);
            this.iniciaBola(X, Y);
    }

    private void iniciaBola(int x, int y) {
            this.dirX = 1; // A bola inicia o jogo indo para a direita
            this.dirY = -1; // A bola inicia o jogo subindo
            this.velocidade = 1;
          //  this.carregaImagem();
           // getImageDimensions();
          //  resetaB();
    }
    
    
    @Override
    public void carregaImagem(String imgPath) {
            int X = super.getX();
            int Y = super.getY();
            // var ii = new ImageIcon();
            // imagemArq = ii.getImage();
            super.setImage(new ImageIcon(imgPath));
         
            this.componente.setIcon( new ImageIcon(imgPath));
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

    
    public void setDirX(int x) {
        this.dirX = x;
    }
    public void setDirY(int y) {
        this.dirY = y;
    }

    
    @Override
     public void atualizar(){
            int X = super.getX() * this.dirX;
            int Y = super.getY() *  this.dirY;

            X += this.velocidade;
            Y += this.velocidade;

            super.setPosicao(X, Y);
     }
   
    @Override
    public void desenhar(){
            int X = super.getX() * this.dirX;
            int Y = super.getY() *  this.dirY;

            this.componente.setLocation(X, Y);
    }
   
/*
    void moveB() {
        PosX += dirX;
        PosY += dirY;

        if (PosX == 0) {
            setDirX(-1);
        }

        if (PosX == Setup.WIDTH - imageWidth) {
            System.out.println(imageWidth);
            setDirX(-1);
        }

        if ( PosY == 0 ) {
            setDirY(1);
        }
    }

    private void resetaB() {
        PosX = Setup.INICIA_BOLAX;
        PosY = Setup.INICIA_BALL_Y;
    }
*/

    
    @Override
    public JLabel obterComponenteTijolo() {  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setarComponenteTijolo(JLabel c) { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public JLabel obterComponenteRaquete() {   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setarComponenteRaquete(JLabel c) {  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
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