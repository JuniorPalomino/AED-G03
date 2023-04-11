package act2;

public class TorreHanoi {

    public static void main(String[] args) {
       
        TorreHanoi objHanoi = new TorreHanoi();
        objHanoi.torresHanoi(3, "A", "C", "B");
        System.out.println("Total de Movimientos: " + TorreHanoi.calcularNumMovimientos(3));
    }

    public static void torresHanoi(int numDiscos, String Inicial, String Final, String Auxiliar) {
        if (numDiscos == 1) { // caso base
            System.out.println("Mover disco de la torre " + Inicial + " a la torre " + Final);
        } else {
            torresHanoi(numDiscos - 1, Inicial, Auxiliar, Final); // mover los n-1 discos superiores a la torre auxiliar
            System.out.println("Mover disco de torre " + Inicial + " a la torre " + Final); // mover el disco más grande a la torre final
            torresHanoi(numDiscos - 1, Auxiliar, Final, Inicial); // mover los n-1 discos superiores de la torre auxiliar a la torre final
        }
    }
    public static int calcularNumMovimientos(int numDiscos) {
        if (numDiscos == 1) { // caso base
            return 1;
        } else {
            int numMovimientosPrevios = calcularNumMovimientos(numDiscos - 1); // calcular el número de movimientos necesarios para mover los n-1 discos superiores
            return 2 * numMovimientosPrevios + 1; // calcular el número de movimientos necesarios para mover n discos
        }
    }
}
