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
    }

}
