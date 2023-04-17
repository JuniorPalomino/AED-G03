package ejer3;

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
    }

    public static void quickSort(int a[], int l, int r){
        int i = l;
        int j = r;
        int pivot = a[(l+r)/2];
        do{
            while(a[i]<pivot) i++;
            while(pivot < a[j]) j--;
            if(i<=j){
                int aux = a[i];
                a[i] = a[j];
                a[j] = aux;
            }
            i++;
            j--;
        }while(i<=j);
        if(l<j){
            quickSort(a, l, j);
        }
        if(i<r){
            quickSort(a,i,r);
        }
    }
    public static void brickSort(int[] arr) {
        boolean sorted = false;
        int left = 0, right = arr.length - 1;
        while (!sorted) {
            sorted = true;
            // Colocamos el elemento máximo en la posición correcta en la parte derecha del arreglo
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i+1]) {
                    swap(arr, i, i+1);
                    sorted = false;
                }
            }
            right--;
            // Colocamos el elemento máximo en la posición correcta en la parte izquierda del arreglo
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i-1]) {
                    swap(arr, i, i-1);
                    sorted = false;
                }
            }
            left++;
        }
        System.out.println("Lista ordenada: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    // Método auxiliar para intercambiar dos elementos en un arreglo
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}