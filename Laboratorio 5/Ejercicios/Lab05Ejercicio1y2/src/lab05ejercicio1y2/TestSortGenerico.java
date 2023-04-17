
package lab05ejercicio1y2;

public class TestSortGenerico {

    public static <T> void showArray(T[] arr) {
        for (T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
