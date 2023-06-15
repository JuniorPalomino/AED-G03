
package lab07_ejercicios;

import actividad1.ExceptionIsEmpty;
import ejercicio1.StackLink;
import ejercicio2.QueueArray;
import ejercicio3.PriorityQueueLinked;
import ejercicio4.Polaca;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Lab07_Ejercicios {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ExceptionIsEmpty, actividad2.ExceptionIsEmpty {
        // TODO code application logic here

        //------------------------//
        //-----COLAS DE PRIORIDAD DENTRO DE UN ARREGLO--EJERCICIO 3------//
        
        
        PriorityQueueLinked<String, Integer> priorityQueue = new PriorityQueueLinked<>(5);

       // Agregar elementos a la cola con diferentes prioridades
       
        priorityQueue.enqueue("Juan", 4);
        priorityQueue.enqueue("helados", 4);
        priorityQueue.enqueue("20", 4);
        priorityQueue.enqueue("4", 4);
        
        priorityQueue.enqueue("Pedro", 2);
        priorityQueue.enqueue("pollo", 2);
        priorityQueue.enqueue("58", 2);
        priorityQueue.enqueue("2", 2);
        
        priorityQueue.enqueue("Miguel", 3);
        priorityQueue.enqueue("Chocolates", 3);
        priorityQueue.enqueue("35", 3);
        priorityQueue.enqueue("3", 3);
        
        priorityQueue.enqueue("Maria", 1);
        priorityQueue.enqueue("pizza", 1);
        priorityQueue.enqueue("75", 1);
        priorityQueue.enqueue("1", 1)
                ;
        priorityQueue.enqueue("Rosa", 2);
        priorityQueue.enqueue("Torta", 2);
        priorityQueue.enqueue("65", 2);
        priorityQueue.enqueue("2", 2);
        
        priorityQueue.enqueue("Americo", 4);
        priorityQueue.enqueue("gaseosa", 4);
        priorityQueue.enqueue("15", 4);
        priorityQueue.enqueue("4", 4);
        
        priorityQueue.enqueue("Lucio", 4);
        priorityQueue.enqueue("pan", 4);
        priorityQueue.enqueue("7", 4);
        priorityQueue.enqueue("4", 4);
        
        priorityQueue.enqueue("Laura", 1);
        priorityQueue.enqueue("torta helada", 1);
        priorityQueue.enqueue("90", 1);
        priorityQueue.enqueue("1", 1);
        
        priorityQueue.enqueue("Joab", 3);
        priorityQueue.enqueue("pasteles", 3);
        priorityQueue.enqueue("44", 3);
        priorityQueue.enqueue("3", 3);
        
        priorityQueue.enqueue("Ralph", 4);
        priorityQueue.enqueue("Golosinas", 4);
        priorityQueue.enqueue("9", 4);
        priorityQueue.enqueue("4", 4);
        
        
        
        
        

        // Imprimir el contenido de la cola
        

     
        //ORden de Atencion
        
        
         System.out.println("ORDEN DE ATENCION"  );
         System.out.println(priorityQueue  );
        
        
      
}
}
