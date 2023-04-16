package Act2;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author H P
 */
public class Sort {

    public static void bubbleSort(int a[]) {

        boolean fl = true;
        int pass = 0;
        int n = a.length;

        for (pass = 0; pass < n - 1 && fl; pass++) {

            fl = false;

            for (int j = 0; j < n - pass - 1; j++) {
                if (a[j] > a[j + 1]) {

                    fl = true;
                    int aux = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = aux;

                }

            }

        }

        TestSort.showArray(a);

    }

    public static void insertionSort(int a[]) {

        int i, j, aux;
        for (i = 1; i < a.length; i++) {

            j = i;
            aux = a[i];

            while (j > 0 && aux < a[j - 1]) {

                a[j] = a[j - 1];
                j--;

            }

            a[j] = aux;

        }

        TestSort.showArray(a);

    }

    public static void selectionSort(int a[]) {
        int min;
        for (int i = 0; i < a.length - 1; i++) {
            min = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[min] > a[j]) {
                    min = j;
                }
            }
            int aux = a[min];
            a[min] = a[i];
            a[i] = aux;
        }
        TestSort.showArray(a);
    }

    public static void shellSort(int a[]) {
        int interval = a.length / 2;
        int i, j, aux;

        while (interval > 0) {
            for (i = interval; i < a.length; i++) {
                j = i;
                aux = a[i];
                while ((j >= interval) && (a[j - interval] > aux)) {
                    a[j] = a[j - interval];
                    j = j - interval;
                }
                a[j] = aux;
            }
            interval = interval / 2;
        }
        TestSort.showArray(a);
    }

}
