package lab06.ejercicio1;

public class OrderListLinked<T extends Comparable<T>> extends ListLinked<T> {

    public int search(T item) {
        Node<T> aux = this.first;
        int count = 0;
        while (aux != null && aux.getData().compareTo(item) < 0) {
            aux = aux.getNext();
            count++;
        }
        if (aux != null) {
            if (aux.getData().compareTo(item) == 0) {
                return count;
            }
        }
        System.out.println("El elemento no se encuentra en la Lista Enlazada");
        return -1;
    }

    public void insertNode(T x) {
        Node<T> aux = new Node<>(x);

        if (first == null) {
            first = aux;
            size++;
            return;
        }

        if (aux.getData().compareTo(first.getData()) < 0) {
            aux.setNext(first);
            first = aux;
            size++;
            return;
        }

        Node<T> nodoAnterior = first;
        Node<T> nodoActual = first.getNext();

        while (nodoActual != null && nodoActual.getData().compareTo(aux.getData()) < 0) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getNext();
        }

        nodoAnterior.setNext(aux);
        aux.setNext(nodoActual);
        size++;
    }

    public void removeNode(T x) {
        Node<T> aux = new Node<>(x);
        if (first == aux) {
            first = first.getNext();
            size--;
            return;
        }

        Node<T> nodoAnterior = first;
        Node<T> nodoActual = first.getNext();

        while (nodoActual != null && nodoActual.getData().compareTo(aux.getData()) < 0) {
            nodoAnterior = nodoActual;
            nodoActual = nodoActual.getNext();
        }

        if (nodoActual != null && nodoActual.getData().equals(aux.getData())) {
            nodoAnterior.setNext(nodoActual.getNext());
            size--;
        }

    }

}
