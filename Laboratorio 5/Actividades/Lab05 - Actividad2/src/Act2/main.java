/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act2;

import static Act2.TestSort.burbuja;
import static Act2.TestSort.insercion;
import static Act2.TestSort.quicksort;
import static Act2.TestSort.seleccion;
import static Act2.TestSort.shell;
import static Act2.Sort.bubbleSort;

/**
 *
 * @author H P
 */
public class main {

    public static void main(String[] args) {
        int[] lista = {35, 56, 31, 8, 57, 64, 74, 82, 62, 13, 50, 63, 21};

        /*
        System.out.println("Lista ordenada BURBUJA: ");
        TestSort.showArray(burbuja(lista));
        
        System.out.println("Lista ordenada INSERCION: ");
        TestSort.showArray(insercion(lista));
        
        System.out.println("Lista ordenada QUICKSORT: ");
        TestSort.showArray(quicksort(lista,0, lista.length - 1));
        
        System.out.println("Lista ordenada SELECCION: ");
        TestSort.showArray(seleccion(lista));
        
        System.out.println("Lista ordenada SHELL: ");
        TestSort.showArray(shell(lista));
        
        System.out.println("Lista ordenada bubbleSort: ");
        Sort.bubbleSort(lista);
        
        System.out.println("Lista ordenada insertionSort: ");
        Sort.insertionSort(lista);
        
        System.out.println("Lista ordenada selectionSort: ");
        Sort.selectionSort(lista);
         
        System.out.println("Lista ordenada shellSort: ");
        Sort.shellSort(lista);
*/
        System.out.println("Lista ordenada quickSort: ");
        Sort.quickSort(lista, 1, lista.length);
    }

}
