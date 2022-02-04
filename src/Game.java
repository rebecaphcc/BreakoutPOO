import java.util.ArrayList;

class Game implements Setup{
    
    // ATRIBUTOS ESTÁTICOS QUE IRÃO PERTENCER SOMENTE A CLASSE (JOGO) E NÃO À SUA INSTÂNCIA ATRAVÉS DE UM OBJETO
    public static int score;
    public static String level;
    public static Sprite bola; // OU Bola bola
    public static Sprite raquete; // OU Raquete raquete
    public static ArrayList<PowerUp> listaPowerUps;
    public static ArrayList<Sprite> listaTijolos; 
            // OU: ArrayList<Tijolo>

    public static void main(String[] args){
        
        Game.startSetup();
    }
    
    static void startSetup(){
        score = 0;
        level = Setup.level;
        bola = new Bola( Setup.INICIA_BOLA_X , Setup.INICIA_BOLA_Y, 50, 50);
        raquete = new Raquete( Setup.INICIA_RAQUETE_X, Setup.INICIA_RAQUETE_Y, 50, 50 );
    }
}
