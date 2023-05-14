package lab07actividades;

import actividad1.ExceptionIsEmpty;
import actividad1.StackArray;
import actividad2.QueueLink;
import actividad3.PriorityQueueLinkSort;

public class Test {

    public static void main(String[] args) throws ExceptionIsEmpty {
        try {
            StackArray pilas = new StackArray(4);
            pilas.push(4);
            pilas.push(1);
            pilas.push(7);
            pilas.push(9);
            System.out.println(pilas.pop());
            System.out.println("Tope de la pila: " + pilas.top());
            pilas.push(9);
            System.out.println("La pila esta llena?: " + pilas.isFull());
            System.out.println(pilas);
        } catch (ExceptionIsEmpty e) {
            System.out.println(e.getMessage());
        }
        //----------------------ACTIVIDAD 2-------------------------//
        /*
        QueueLink <Character> K = new QueueLink();
        K.enqueue('A');
        K.enqueue('B');
        K.enqueue('G');
        K.enqueue('Z');
        
        System.out.println(K.dequeue().toString()+"\n");
        System.out.println(K.front()+"\n");
        System.out.println(K.back()+"\n");
        System.out.println(K+"\n");
         */
        //----------------------ACTIVIDAD 3-------------------------//
        /*
        PriorityQueueLinkSort<Integer, Integer> priorityQueue = new PriorityQueueLinkSort<>();

        priorityQueue.enqueue(5, 3); 
        priorityQueue.enqueue(2, 1); 
        priorityQueue.enqueue(8, 2); 

        System.out.println("Contenido de la cola: " + priorityQueue.toString());
        System.out.println("Cola Vacia? " + priorityQueue.isEmpty());

        try {
            System.out.println("Elemento frontal: " + priorityQueue.front());
            System.out.println("Elemento trasero: " + priorityQueue.back());
            System.out.println("Elemento eliminado: " + priorityQueue.dequeue());
            System.out.println("Contenido de la cola después de la eliminación: " + priorityQueue.toString());
        } catch (ExceptionIsEmpty e) {
            System.err.println(e.getMessage());
        }
         */
    }
}
