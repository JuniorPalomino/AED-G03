
package lab04ejercicio3;

import java.util.Arrays;

public class Principal {

       static int binarySearch(String[] arr, int lo, int hi, String x) {
        if (hi >= lo && lo < arr.length - 1) {
            int mid = lo + (hi - lo) / 2;
            int cmp = arr[mid].compareTo(x);
            if (cmp == 0) {
                return mid;
            }
            if (cmp > 0) {
                return binarySearch(arr, lo, mid - 1, x);
            }
            return binarySearch(arr, mid + 1, hi, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        String estudiantes[] = {"A", "B", "C", "D", "E", "F", "G"};
        Arrays.sort(estudiantes);
        String x = "B";
        
        System.out.println(binarySearch(estudiantes,0,estudiantes.length,x));

    }
    
}
