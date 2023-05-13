package actividad3;

import actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, P extends Comparable<P>> implements PriorityQueue<E, P> {

    //Clase EntryNode data y priority
    class EntryNode {

        E data;
        P priority;

        EntryNode(E data, P priority) {
            this.data = data;
            this.priority = priority;
        }
    }

    //Objectos primero y ultimo nodo
    private Node<EntryNode> first;
    private Node<EntryNode> last;

    //Constructor Clase Principal
    public PriorityQueueLinkSort() {
        this.first = null;
        this.last = null;
    }

    //Metodo "Poner en Cola"
    @Override
    public void enqueue(E x, P pr) {
        EntryNode eN = new EntryNode(x, pr);
        Node<EntryNode> nuevo = new Node<>(eN);
        
        if (isEmpty()) {
            first = nuevo;
            last = nuevo;
        }
        
        else {
            // Recorrer y encontra la posición 
            Node<EntryNode> actual = first;
            Node<EntryNode> anterior = null;
            
            while (actual != null && (eN.priority.compareTo(actual.getData().priority) <= 0)) {
                anterior = actual;
                actual = actual.getNext();
            }

            // Insertar el nuevo nodo
            if (anterior == null) {
                nuevo.setNext(first);
                first = nuevo;
            } else if (actual == null) {
                last.setNext(nuevo);
                last = nuevo;
            } else {
                anterior.setNext(nuevo);
                nuevo.setNext(actual);
            }
        }
    }

    //Metodo "Eliminar y Devolver" elemento 
    @Override
    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }

        E aux = this.first.getData().data;
        this.first = this.first.getNext();
        if (this.first == null) {
            this.last = null;
        }
        return aux;
    }

    //Obtner PRIMER elemento de la cola
    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return this.first.getData().data;
    }

    //Obtner ULTIMO elemento de la cola
    @Override
    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        }
        return this.last.getData().data;
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<EntryNode> curr = this.first;

        while (curr != null) {
            sb.append(curr.getData().data).append(", ");
            curr = curr.getNext();
        }
        return sb.toString();
    }
}
