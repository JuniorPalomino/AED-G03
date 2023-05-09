package actividad3;

import actividad1.ExceptionIsEmpty;

public class Test {
    public static void main(String[] args) {
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
    }
}
