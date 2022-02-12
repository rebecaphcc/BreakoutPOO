package src;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class Buff extends ElementoConsumivel{
    
    private JLabel componente;
    
    public Buff(int X, int Y, JLabel compMoney){
            super(X, Y);
            this.componente = compMoney;
    }

    @Override
    public void carregaImagem(String imgPath){
            // var ii = new ImageIcon();
            // imagemArq = ii.getImage();
            super.setImage( new ImageIcon(imgPath) );
            this.componente .setIcon(  new ImageIcon(imgPath)  );
    }
    @Override
    public JLabel obterComponenteBuff() { 
            return this.componente; 
    } 
    @Override
    public void setarComponenteBuff(JLabel c) { 
            this.componente = c;
    }
    
    
    
    @Override
    public void atualizar(){}
    @Override
    public void desenhar(){}
    
    
    
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
    public JLabel obterComponenteDebuff() { return null;   }
    @Override
    public void setarComponenteDebuff(JLabel c) {   }
}
