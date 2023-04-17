package lab05ejercicio1y2;

public class GenericSort {

    public static <T extends Comparable<T>> void bubbleSort(T[] a) {

        boolean fl = true;
        int pass = 0;
        int n = a.length;

        for (pass = 0; pass < n - 1 && fl; pass++) {

            fl = false;

            for (int j = 0; j < n - pass - 1; j++) {
                if (a[j].compareTo(a[j + 1]) > 0) {

                    fl = true;
                    T aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;

                }

            }

        }

        TestSortGenerico.showArray(a);

    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {

        int i, j;
        T aux;
        for (i = 1; i < a.length; i++) {

            j = i;
            aux = a[i];

            while (j > 0 && aux.compareTo(a[j - 1]) < 0) {

                a[j] = a[j - 1];
                j--;

            }

            a[j] = aux;

        }

        TestSortGenerico.showArray(a);

    }

    public static <T extends Comparable<T>> void selectionSort(T[] a) {
        int min;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min].compareTo(a[j]) > 0) {
                    min = j;
                }
            }
            T aux = a[min];
            a[min] = a[i];
            a[i] = aux;
        }
        TestSortGenerico.showArray(a);
    }

    public static <T extends Comparable<T>> void shellSort(T[] a) {
        int interval = a.length / 2;
        int i, j;
        T aux;

        while (interval > 0) {
            for (i = interval; i < a.length; i++) {
                j = i;
                aux = a[i];
                while ((j >= interval) && (a[j - interval].compareTo(aux) > 0)) {
                    a[j] = a[j - interval];
                    j = j - interval;
                }
                a[j] = aux;
            }
            interval = interval / 2;
        }
        TestSortGenerico.showArray(a);
    }

    public static <T extends Comparable<T>> void quickSort(T[] a, int l, int r) {
        int i = l;
        int j = r;
        T pivot = a[(l + r) / 2];
        do {
            while (a[i].compareTo(pivot) < 0) {
                i++;
            }
            while (a[j].compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j) {
                T aux = a[i];
                a[i] = a[j];
                a[j] = aux;
                i++;
                j--;
            }
        } while (i <= j);
        if (l < j) {
            quickSort(a, l, j);
        }
        if (i < r) {
            quickSort(a, i, r);
        }
    }

}
