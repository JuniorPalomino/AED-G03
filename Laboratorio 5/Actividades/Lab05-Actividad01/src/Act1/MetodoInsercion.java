/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act1;

/**
 *
 * @author Asus
 */
public class MetodoInsercion {

    public static int[] insercion(int[] x) {
        for (int i = 0; i < x.length; i++) {
            int valorActual = x[i];
            int j = i - 1;

            while (j >= 0 && x[j] > valorActual) {
                x[j + 1] = x[j];
                j--;
            }
            x[j + 1] = valorActual;
        }

        return x;

    }

    public static void main(String[] args) {
        int[] lista = {35, 56, 31, 8, 57, 64, 74, 82, 62, 13, 50, 63, 21};
        int[] rpt = insercion(lista);
        System.out.println("Lista ordenada: ");
        for (int i = 0; i < rpt.length; i++) {
            System.out.print(rpt[i] + " ");
        }
        System.out.println("");
    }
}
