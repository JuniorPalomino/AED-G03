/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab07_ejercicios;

import actividad1.ExceptionIsEmpty;
import ejercicio1.StackLink;
import ejercicio2.QueueArray;
import ejercicio3.PriorityQueueLinked;

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
        QueueArray P = new QueueArray(6);

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
        //-----COLAS DE PRIORIDAD DENTRO DE UN ARREGLO--EJERCICIO 3------//
        
        
        PriorityQueueLinked<String, Integer> priorityQueue = new PriorityQueueLinked<>(5);

        // Agregar elementos a la cola con diferentes prioridades
        priorityQueue.enqueue("A", 1);
        priorityQueue.enqueue("B", 0);
        priorityQueue.enqueue("C", 2);
        priorityQueue.enqueue("D", 2);
        priorityQueue.enqueue("E", 3);

        // Imprimir el contenido de la cola
        System.out.println(priorityQueue);

        // Obtener y mostrar el primer elemento de la cola
        try {
            String firstElement = priorityQueue.front();
            System.out.println("Primer elemento de la cola: " + firstElement);
        } catch (ExceptionIsEmpty e) {
            System.out.println("La cola está vacia");
        }

        // Obtener y mostrar el último elemento de la cola
        try {
            String lastElement = priorityQueue.back();
            System.out.println("Ultimo elemento de la cola: " + lastElement);
        } catch (ExceptionIsEmpty e) {
            System.out.println("La cola está vacia.");
        }

        // Extraer un elemento de la cola y mostrarlo
        try {
            String removedElement = priorityQueue.dequeue();
            System.out.println("Dequeue de la cola: " + removedElement);
        } catch (ExceptionIsEmpty e) {
            System.out.println("La cola está vacia");
        }

        // Imprimir el contenido de la cola después de la extracción
        System.out.println(priorityQueue);

        //------------------------//
    }

}
