 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab07_ejercicios;

import actividad1.ExceptionIsEmpty;
import ejercicio1.StackLink;
import ejercicio2.QueueArray;


/**
 *
 * @author H P
 */
public class Lab07_Ejercicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExceptionIsEmpty, actividad2.ExceptionIsEmpty {
        // TODO code application logic here
        
        
        //-----PILAS DE NODOS--EJERCICIO 1------//
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
        
        //-----COLAS DE ARREGLOS--EJERCICIO 2------//
        
        QueueArray P= new QueueArray(6);
        
        P.enqueue("A");
        P.enqueue("B");
        P.enqueue("C");
        P.enqueue("D");
        P.enqueue("E");
        P.enqueue("F");
        
        System.out.println(P.dequeue());
        System.out.println(P.front());
        System.out.println(P.back());
        System.out.println(P);
        
        
        
        //------------------------//
        
      
    }
    
}
