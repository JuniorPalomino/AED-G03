/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act1;

/**
 *
 * @author Asus
 */
public class MetodoQuicksort {

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
        int i = (izquierda-1);
        for(int j = izquierda; j < derecha; j++) {
            if(lista[j] < pivot) {
                i++;
                int temp = lista[i];
                lista[i] = lista[j];
                lista[j] = temp;
            }
        }
        int temp = lista[i+1];
        lista[i+1] = lista[derecha];
        lista[derecha] = temp;
        return i+1;
    }

    public static void main(String[] args) {
        int[] lista = {35, 56, 31, 8, 57, 64, 74, 82, 62, 13, 50, 63, 21};
        int[] rpt = quicksort(lista, 0, lista.length - 1);
        System.out.println("Lista ordenada: ");
        for (int i = 0; i < rpt.length; i++) {
            System.out.print(rpt[i] + " ");
        }
        System.out.println("");
    }
}
