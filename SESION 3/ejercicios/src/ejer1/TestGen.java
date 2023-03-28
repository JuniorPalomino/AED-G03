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
        String[] v = {"Perez", "Sanchez", "Rodriguez"};
        Integer[] w = {12, 34, 56};

        System.out.println(exist(v, "Sanchez"));
        System.out.println(exist(w, 34));
        //System.out.println(exist(w, "Salas")); //Error
    }

}
