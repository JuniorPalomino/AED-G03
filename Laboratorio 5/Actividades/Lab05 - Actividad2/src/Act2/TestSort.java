package Act2;

public class TestSort {

    public static void showArray(int[] lista) {
        for (int i = 0; i < lista.length; i++) {
            System.out.print(lista[i] + " ");
        }
        System.out.println();
    }

    public static int[] burbuja(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    int temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }

        return x;

    }

    public static int[] insercion(int[] x) {
        for (int i = 0; i < x.length; i++) {
            int valorActual = x[i];
            int j = i - 1;

            while (j >= 0 && x[j] > valorActual) {
                x[j + 1] = x[j];
                j--;
            }
            x[j + 1] = valorActual;
        }

        return x;

    }

    public static int[] quicksort(int[] x, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int pivote = particion(x, izquierda, derecha);
            quicksort(x, izquierda, pivote - 1);
            quicksort(x, pivote + 1, derecha);
        }
        return x;

    }

    public static int particion(int[] lista, int izquierda, int derecha) {
        int pivot = lista[derecha];
        int i = (izquierda - 1);
        for (int j = izquierda; j < derecha; j++) {
            if (lista[j] < pivot) {
                i++;
                int temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }
        int temp = lista[i + 1];
        lista[i + 1] = lista[derecha];
        lista[derecha] = temp;
        return i + 1;
    }
    
    public static int[] seleccion(int[] x) {
        for(int i = 0; i < x.length-1; i++) {
            int indiceMenor = i;
            for(int j = i+1; j < x.length; j++) {
                if(x[j] < x[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            int temp = x[i];
            x[i] = x[indiceMenor];
            x[indiceMenor] = temp;
        }
        return x;

    }
    
    public static int[] shell(int[] x) {
        int incremento = x.length / 2;
        while(incremento > 0) {
            for(int i = incremento; i < x.length; i++) {
                int j = i;
                int temp = x[i];
                while(j >= incremento && x[j-incremento] > temp) {
                    x[j] = x[j-incremento];
                    j -= incremento;
                }
                x[j] = temp;
            }
            incremento /= 2;
        }
        return x;

    }
}
