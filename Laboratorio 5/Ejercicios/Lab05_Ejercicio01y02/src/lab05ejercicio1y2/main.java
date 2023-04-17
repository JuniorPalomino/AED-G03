
package lab05ejercicio1y2;

public class main {

    public static void main(String[] args) {
        Integer []enteros={9,5,4,7,2,0,1};
        Character []caracteres={'F','Z','D','S','B','X','H'};
        String []cadenas={"documento","comando","algoritmo","byte","ejecutar"};
        Golosina []golosinas={new Golosina("Snickers", 20.5),new Golosina("chocman", 35.25),new Golosina("milka", 15.6)};
        /*
        GenericSort.bubbleSort(enteros);
        GenericSort.selectionSort(caracteres);
        GenericSort.quickSort(cadenas, 0, cadenas.length-1);
        TestSortGenerico.showArray(cadenas);
        GenericSort.insertionSort(golosinas);
        */
        System.out.println("Lista ordenada mergeSort: ");
        GenericSort.mergeSort(enteros, 0, enteros.length-1);
        TestSortGenerico.showArray(enteros);
        GenericSort.mergeSort(caracteres, 0, caracteres.length-1);
        TestSortGenerico.showArray(caracteres);
        GenericSort.mergeSort(cadenas, 0, cadenas.length-1);
        TestSortGenerico.showArray(cadenas);
        GenericSort.mergeSort(golosinas, 0, golosinas.length-1);
        TestSortGenerico.showArray(golosinas);
        
    }
    
}
