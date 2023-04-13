/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act1;

/**
 *
 * @author Asus
 */
public class MetodoBurbuja {

    public static int[] burbuja(int[] x) {
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    int temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }
            }
        }

        return x;

    }
    
    public static void main(String[] args) {
        int[] lista = {35, 56, 31, 8, 57, 64, 74, 82, 62, 13, 50, 63, 21};
        int[] rpt = burbuja(lista);
        System.out.println("Lista ordenada: ");
        for(int i = 0; i < rpt.length; i++) {
            System.out.print(rpt[i] + " ");
        }
        System.out.println("");
    }
}
