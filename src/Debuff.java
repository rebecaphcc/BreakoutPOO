package src;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class Debuff extends ElementoConsumivel{
    
    private JLabel componente;
    
    public Debuff(int X, int Y, JLabel comp){
           super(X, Y);
           this.componente = comp;
           super.setEliminado(false);
    }

    @Override
    public void carregaImagem(String imgPath){
            super.setImage(new ImageIcon(imgPath));
            this.componente.setIcon(  new ImageIcon(imgPath) );
    }
    
    @Override
    public void atualizar(){
           int[] novoXY = Game.gerarMatrizCoordenadas();
         //  this.componente.setLocation(novoXY[0], novoXY[1]);
           super.setPosicao(novoXY[0], novoXY[1]);
    }
    
    @Override
    public void desenhar(){
            int[] XY = super.getPosicao();
            this.componente.setLocation( XY[0], XY[1]);
    }
    
    
    
     @Override
     public JLabel obterComponenteDebuff() { 
            return this.componente;   
     }
     @Override
     public void setarComponenteDebuff(JLabel c) { 
            this.componente = c;
     }
    
     
    
    
    
    @Override
    public JLabel obterComponenteBola(){ return null;}
    @Override
    public void setarComponenteBola(JLabel c){}
    @Override
     public JLabel obterComponenteTijolo(){ return null;}
    @Override
    public void setarComponenteTijolo(JLabel c){}
    @Override
    public JLabel obterComponenteRaquete(){ return null;}
    @Override
    public void setarComponenteRaquete(JLabel c){ }
    @Override
    public JLabel obterComponenteBuff() { return null; }
    @Override
    public void setarComponenteBuff(JLabel c) { }
}