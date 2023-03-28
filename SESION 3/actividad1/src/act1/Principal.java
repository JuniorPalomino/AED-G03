package act1;

public class Principal {

    public static void main(String[] args) {
        Bolsa<Chocolatina> bolsaCho = new Bolsa<Chocolatina>(3);

        Chocolatina c = new Chocolatina("milka");
        Chocolatina c1 = new Chocolatina("milka");
        Chocolatina c2 = new Chocolatina("ferrero");

        bolsaCho.add(c);
        bolsaCho.add(c1);
        bolsaCho.add(c2);

        for (Chocolatina chocolatina : bolsaCho) {
            System.out.println(chocolatina.getMarca());
        }

        Bolsa<Golosina> bolsaGolo = new Bolsa<Golosina>(3);
        Golosina g = new Golosina("milka", 12.3);
        Golosina g1 = new Golosina("milka", 32.6);
        Golosina g2 = new Golosina("ferrero", 5.9);

        bolsaGolo.add(g);
        bolsaGolo.add(g1);
        bolsaGolo.add(g2);
                
        for (Golosina golosina : bolsaGolo) {
            System.out.println(golosina.getNombre() + " "+ golosina.getPeso());
        }
    }
}
