/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act1;

/**
 *
 * @author Asus
 */
public class MetodoShell {

    public static int[] shell(int[] x) {
        int incremento = x.length / 2;
        while(incremento > 0) {
            for(int i = incremento; i < x.length; i++) {
                int j = i;
                int temp = x[i];
                while(j >= incremento && x[j-incremento] > temp) {
                    x[j] = x[j-incremento];
                    j -= incremento;
                }
                x[j] = temp;
            }
            incremento /= 2;
        }
        return x;

    }

    public static void main(String[] args) {
        int[] lista = {35, 56, 31, 8, 57, 64, 74, 82, 62, 13, 50, 63, 21};
        int[] rpt = shell(lista);
        System.out.println("Lista ordenada: ");
        for (int i = 0; i < rpt.length; i++) {
            System.out.print(rpt[i] + " ");
        }
        System.out.println("");
    }
}
