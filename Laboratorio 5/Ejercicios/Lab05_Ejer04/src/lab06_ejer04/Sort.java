package lab06_ejer04;

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

  
    public static void ShakeShort(int array[]) {

        boolean swapped = true;
        int start = 0;
        int end = array.length - 1;

        while (swapped) {
            swapped = false;

            // Recorrer la lista de izquierda a derecha
            for (int i = start; i < end; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            // Si no se realizó ningún intercambio en la iteración anterior, la lista está ordenada
            if (!swapped) {
                break;
            }

            swapped = false;
            end--;

            // Recorrer la lista de derecha a izquierda
            for (int i = end - 1; i >= start; i--) {                    
                if (array[i] > array[i + 1]) {                          
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }

            start++;
        }

        // Imprimir la lista ordenada completa
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }

    }

}
