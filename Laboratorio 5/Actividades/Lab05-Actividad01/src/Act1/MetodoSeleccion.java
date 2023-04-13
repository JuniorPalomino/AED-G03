/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Act1;

/**
 *
 * @author Asus
 */
public class MetodoSeleccion {

    public static int[] seleccion(int[] x) {
        for(int i = 0; i < x.length-1; i++) {
            int indiceMenor = i;
            for(int j = i+1; j < x.length; j++) {
                if(x[j] < x[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            int temp = x[i];
            x[i] = x[indiceMenor];
            x[indiceMenor] = temp;
        }
        return x;

    }

    public static void main(String[] args) {
        int[] lista = {35, 56, 31, 8, 57, 64, 74, 82, 62, 13, 50, 63, 21};
        int[] rpt = seleccion(lista);
        System.out.println("Lista ordenada: ");
        for (int i = 0; i < rpt.length; i++) {
            System.out.print(rpt[i] + " ");
        }
        System.out.println("");
    }
}
