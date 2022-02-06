package src;
import javax.swing.JLabel;

class ElementoConsumivel extends Sprite{
    
    private int raio;
    private boolean eliminado = false;
    String estado = "visivel";
    boolean capturado = false;


    public ElementoConsumivel(int X, int Y, int imageWidth, int imageHeight){
          super(X, Y, imageWidth, imageHeight);
    }

    public int getRaio(){
        return this.raio;
    }

    public void setRaio(int tamanhoRaio){
        this.raio = tamanhoRaio;
    }

    public void setEliminar(){
        this.eliminado = true;
    }

    public boolean getEliminar(){
        return this.eliminado;
    }

    boolean getCapturado(){
        return this.capturado;
    }

    void setCapturado(boolean val){
        this.capturado = val;
    }
    
    

    @Override
    public JLabel obterComponenteBola() { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setarComponenteBola(JLabel c) {throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public JLabel obterComponenteTijolo() { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setarComponenteTijolo(JLabel c) {throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public JLabel obterComponenteRaquete() { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void setarComponenteRaquete(JLabel c) { throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
