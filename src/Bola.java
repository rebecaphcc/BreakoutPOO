package src;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

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
            this.iniciaBola ();
    }

    private void iniciaBola() {
            this.dirX = 1; // A bola inicia o jogo indo para a direita
            this.dirY = 1; // A bola inicia o jogo subindo
            this.velocidade = 3;
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
            X += (this.velocidade * this.dirX);
            Y += (this.velocidade * this.dirY);

            int x2 = X + super.getImageWidth();
            int y2 =Y + super.getImageHeight();
            
            super.setPosicao (X, Y);
            super.setPosicao2 (x2, y2);
     }
   
    @Override
    public void desenhar(){
            int[] XY = super.getPosicao();

          //  this.componente.setLocation(X, Y);
          this.componente.setBounds ( XY[0],  XY[1], super.getImageWidth(), super.getImageHeight());
    }
   
    
    
    
    
    
    
    
    
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