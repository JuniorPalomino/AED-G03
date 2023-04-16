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

    public static void burbuja(int[] x) {
        int count = 1;
        for (int i = 0; i < x.length - 1; i++) {
            for (int j = 0; j < x.length - i - 1; j++) {
                if (x[j] > x[j + 1]) {
                    int temp = x[j];
                    x[j] = x[j + 1];
                    x[j + 1] = temp;
                }

            }
            
            System.out.println("PASADA : " + count++);
            for (int l = 0; l < x.length; l++) {
                
                System.out.print(x[l] + " ");
            }
            System.out.println("");

        }

    }

    public static void main(String[] args) {
        int[] lista = {35, 56, 31, 8, 57, 64, 74, 82, 62, 13, 50, 63, 21};

        burbuja(lista);

    }
}
