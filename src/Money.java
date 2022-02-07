package src;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

class Money extends ElementoConsumivel{
    
    private JLabel componente;
    
    public Money(int X, int Y, JLabel compMoney){
            super(X, Y);
            this.componente = compMoney;
    }

    @Override
    public void carregaImagem(String imgPath){
            // var ii = new ImageIcon();
            // imagemArq = ii.getImage();
            super.setImage(new ImageIcon(imgPath));
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
     public JLabel obterComponentePowerUp(){ return null;}
    @Override
     public void setarComponentePowerUp(JLabel c){}
}
