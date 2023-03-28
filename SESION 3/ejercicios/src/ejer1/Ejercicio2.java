
package ejer1;

public class Ejercicio2 {
    static <T extends Comparable<T>> void mostrarBolsa(Bolsa<Golosina> x) {

        for (int i = 0; i < x.getLista().size(); i++) {
                System.out.println(x.getLista().get(i));
            }
        }
    public static void main(String[] args) {
        
        Bolsa<Golosina> bolsaGolo = new Bolsa<Golosina>(4);
        Golosina g = new Golosina("milka", 12.3);
        Golosina g1 = new Golosina("milka", 32.6);
        Golosina g2 = new Golosina("ferrero", 5.9);

        bolsaGolo.add(g);
        bolsaGolo.add(g1);
        bolsaGolo.add(g2);
        mostrarBolsa(bolsaGolo);
    }
    
}
