/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab07_ejercicios;

import actividad1.ExceptionIsEmpty;
import ejercicio1.StackLink;


/**
 *
 * @author H P
 */
public class Lab07_Ejercicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExceptionIsEmpty {
        // TODO code application logic here
        
        
        //-----PILAS DE NODOS------//
        StackLink PilaUno = new StackLink();
        
        System.out.println(PilaUno);
         
        PilaUno.push("A");
        PilaUno.push("B");
        PilaUno.push("C");
        PilaUno.push("D");
        PilaUno.push("E");
        PilaUno.pop();
        
        System.out.println(PilaUno);
        System.out.println(PilaUno.top());
        
        //------------------------//
        
      
    }
    
}
