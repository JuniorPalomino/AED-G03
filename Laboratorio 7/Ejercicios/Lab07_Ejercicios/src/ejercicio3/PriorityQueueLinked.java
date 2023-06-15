package ejercicio3;

import actividad2.*;
import actividad3.*;
import actividad1.ExceptionIsEmpty;

public class PriorityQueueLinked<E, P> implements PriorityQueue<E, P> {

    private QueueLink<E>[] arreglo;

    public PriorityQueueLinked(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("La cantidad de prioridades debe ser mayor a cero");
        }
        arreglo = new QueueLink[size];
        for (int i = 0; i < size; i++) {
            arreglo[i] = new QueueLink<>();
        }
    }

    public QueueLink<E>[] getArreglo() {
        return arreglo;
    }

    public void setArreglo(QueueLink<E>[] arreglo) {
        this.arreglo = arreglo;
    }

    @Override
    public void enqueue(E x, P pr) {
        Integer pri = Integer.valueOf(String.valueOf(pr));
        int prioridad = pri.hashCode() % arreglo.length;
        arreglo[prioridad].enqueue(x);
    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {
        for (QueueLink<E> cola : arreglo) {
            if (!cola.isEmpty()) {
                try {
                    return cola.dequeue();
                } catch (Exception ex) {
                    ex.getMessage();
                }
            }
        }
        throw new ExceptionIsEmpty();
    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        for (QueueLink<E> cola : arreglo) {
            if (!cola.isEmpty()) {
                return cola.getFirst().getData();
            }
        }
        throw new ExceptionIsEmpty();
    }

    @Override
    public E back() throws ExceptionIsEmpty {
        for (int i = arreglo.length - 1; i >= 0; i--) {
            if (!arreglo[i].isEmpty()) {
                return arreglo[i].getLast().getData();
            }
        }
        throw new ExceptionIsEmpty();
    }

    @Override
    public boolean isEmpty() {
        for (QueueLink<E> cola : arreglo) {
            if (!cola.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arreglo.length; i++) {
            sb.append("Atencion ").append(i).append(": ").append(arreglo[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
