package act2;

public class TorreHanoi {

    public static void main(String[] args) {
       
        TorreHanoi objHanoi = new TorreHanoi();
        objHanoi.torresHanoi(4, "A", "C", "B");
    }

    public static void torresHanoi(int numDiscos, String Inicial, String Final, String Auxiliar) {
        if (numDiscos == 1) { // caso base
            System.out.println("Mover disco de la torre " + Inicial + " a la torre " + Final);
        } else {
            torresHanoi(numDiscos - 1, Inicial, Auxiliar, Final); // mover los n-1 discos superiores a la torre auxiliar
            System.out.println("Mover disco " + numDiscos + " de la torre " + Inicial + " a la torre " + Final); // mover el disco más grande a la torre final
            torresHanoi(numDiscos - 1, Auxiliar, Final, Inicial); // mover los n-1 discos superiores de la torre auxiliar a la torre final
        }
    }
}
