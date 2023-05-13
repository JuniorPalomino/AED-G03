package ejercicio3;

import actividad1.ExceptionIsEmpty;

public class QueueLink<E> implements Queue<E> {

    private Node<E> first;
    private Node<E> last;

    public Node<E> getFirst()
    {
        return first;
    }
    
    public Node<E> getLast()
    {
        return last;
    }
    
    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public QueueLink(Node<E> n) {
        this.first = n;
        this.last = n;
    }

    public QueueLink(Node<E> first, Node<E> last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public void enqueue(E x) {
        Node<E> aux = new Node<E>(x);
        if (isEmpty()) {
            this.first = aux;
        } else {
           
            this.last.setNext(aux);
            
        }
        this.last = aux;

    }

    @Override
    public E dequeue() throws ExceptionIsEmpty {

        E aux = first.getData();

        if (isEmpty()) {

            return null;
        }
        first = first.next;
        return aux;

    }

    @Override
    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            return null;
        }

        return first.getData();
    }

    @Override
    public E back() throws ExceptionIsEmpty {

        if (isEmpty()) {
            return null;
        }

        return last.getData();
    }

    @Override
    public boolean isEmpty() {

        return (first == null || last == null);

    }

    @Override
public String toString() {
    if (isEmpty()) {
        return "Lista Vacía";
    }

    StringBuilder sb = new StringBuilder();
    Node<E> current = first;
    while (current != null) {
        sb.append(current.getData()).append(", ");
        current = current.getNext();
    }
    sb.setLength(sb.length() - 2); // Eliminar la última coma y espacio

    return sb.toString();
}


}
