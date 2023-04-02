package ejer1;

public class TestGen {

    static <T extends Comparable<T>> boolean exist(T[] x, T y) {

        for (int i = 0; i < x.length; i++) {
            if (x[i].equals(y)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {

        //EJERCICIO1
        String[] v = {"Perez", "Sanchez", "Rodriguez"};
        Integer[] w = {12, 34, 56};

        System.out.println(exist(v, "Sanchez"));
        System.out.println(exist(w, 34));
        //System.out.println(exist(w, "Salas")); //Error

        //EJERCICIO 5
        Cajoneria<Golosina> golosinas = new Cajoneria<Golosina>(5);
        Caja caja1 = new Caja("VERDE", new Golosina("milka", 12.3));
        Caja caja2 = new Caja("ROJO", new Golosina("milka", 32.6));
        Caja caja3 = new Caja("AZUL", new Golosina("ferrero", 5.9));
        Caja caja4 = new Caja("AMARILLO", new Golosina("chocman", 20.4));
        Caja caja5 = new Caja("NARANJA", new Golosina("fields", 10.5));

        golosinas.add(caja1);
        golosinas.add(caja2);
        golosinas.add(caja3);
        golosinas.add(caja4);
        golosinas.add(caja5);
        System.out.println(golosinas.search(new Caja("ROJO", new Golosina("milka", 32.6))));    //Muestra la posicion y el color
        golosinas.delete(caja3);

        System.out.println(golosinas);  //Muestra el ArrayList luego de eliminar el objeto
        System.out.println("---------------------------------------------------------------------");

        //EJERCICIO 6
        Cajoneria<Chocolatina> chocolatinas = new Cajoneria<Chocolatina>(5);
        Chocolatina c1 = new Chocolatina("La Iberica");
        Chocolatina c2 = new Chocolatina("KitKat");
        Chocolatina c3 = new Chocolatina("M&Ms");
        Chocolatina c4 = new Chocolatina("Hershey's");
        Chocolatina c5 = new Chocolatina("Snickers");

        Caja caja6 = new Caja("NEGRO", new Chocolatina("La Iberica"));
        Caja caja7 = new Caja("MORADO", new Chocolatina("KitKat"));
        Caja caja8 = new Caja("ROJO", new Chocolatina("M&Ms"));
        Caja caja9 = new Caja("MARRON", new Chocolatina("Hershey's"));
        Caja caja10 = new Caja("BLANCO", new Chocolatina("Snickers"));
        chocolatinas.add(caja6);
        chocolatinas.add(caja7);
        chocolatinas.add(caja8);
        chocolatinas.add(caja9);
        chocolatinas.add(caja10);
        System.out.println(chocolatinas.search(new Caja("MARRON", new Chocolatina("Hershey's"))));
        chocolatinas.delete(new Caja("MORADO", new Chocolatina("KitKat")));

        System.out.println(chocolatinas);   //Muestra el ArrayList luego de eliminar el objeto

    }

}
