/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab04.act04;

/**
 *
 * @author H P
 */
public class Lab04Act04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        int[] values = new int[]{3, 7, 1, 3, 9};
        int rodLength = values.length;
        System.out.println("El valor maximo: " + getValue(values, rodLength));

    }

    static int getValue(int[] values, int length) {
        if (length <= 0) {
            return 0;
        }
        int tmpMax = -1;
        for (int i = 0; i < length; i++) {
            tmpMax = Math.max(tmpMax, values[i] + getValue(values, length - i - 1));
        }
        return tmpMax;
    }

}
