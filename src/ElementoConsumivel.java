package src;
import javax.swing.JLabel;

abstract class ElementoConsumivel extends Sprite{
    
    protected int raio;
    protected boolean eliminado;
    protected JLabel componente ;
   // protected boolean capturado = false;

    public ElementoConsumivel(int X, int Y){
          super(X, Y);
          this.setEliminado(false);
    }

    
    public int getRaio(){
          return this.raio;
    }

    public void setRaio(int tamanhoRaio){
          this.raio = tamanhoRaio;
    }

    
    public boolean getEliminado(){
          return this.eliminado;
    }
    public void setEliminado(boolean foiEliminado){
          this.eliminado = foiEliminado;
    }

    
    
    

    @Override
    abstract public JLabel obterComponenteBola();
    @Override
    abstract public void setarComponenteBola(JLabel c);
    @Override
    abstract public JLabel obterComponenteTijolo();
    @Override
    abstract public void setarComponenteTijolo(JLabel c);
    @Override
    abstract public JLabel obterComponenteRaquete();
    @Override
    abstract public void setarComponenteRaquete(JLabel c);
    
    
    
    /*
    boolean getCapturado(){
        return this.capturado;
    }
    void setCapturado(boolean val){
        this.capturado = val;
    }
    */
}
