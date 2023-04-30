package lab06.ejercicio1;

public class ListLinked<T> implements TDAList<T> {

    protected Node<T> first;
    public int size;

    public ListLinked() {
        this.first = null;
    }

    @Override
    public boolean isEmptyList() {
        return first == null || first.getData() == null;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public void destroyList() {
        Node<T> n = first;
        while (n != null) {
            Node nextNode = n.getNext();
            n.setNext(null);
            n = nextNode;
        }
        System.out.println("LISTA ENLAZADA DESTRUIDA");
        first = null;
        size = 0;

    }

    @Override
    public int search(T x) {

        Node<T> n = first;
        int i=1;
        while (n.getNext() != null) {
            if (n.getData().equals(x)) {
                System.out.println("ENCONTRADO: " + i);
                return i;
            }
            i++;
            n = n.getNext();
        }
        System.out.println("NO ENCONTRADO");
        return -1;
    }

    @Override
    public void insertFirst(T x) {
        Node<T> newNode = new Node<>(x);
        if (first == null) {
            first = newNode;
        } else {
            Node n = first;
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(newNode);
        }
        size++;
    }

    @Override
    public void insertLast(T x) {
        Node<T> newNode = new Node<>(x);
        if (first == null) {
            first = newNode;
        } else {
            Node n = first;
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(newNode);
        }
        size++;
    }

    @Override
    public void removeNode(T x) {
        Node<T> newNode = new Node<>(x);
        if (first == newNode) {
            first = first.getNext();
            size--;
            return;
        }

        Node n = first;
        while (n.getNext() != null) {
            if (n.getNext().getData().equals(newNode.getData())) {
                n.setNext(n.getNext().getNext());
                size--;
                return;
            }
            n = n.getNext();
        }

    }

    @Override
    public String toString() {
        String x="";
        if (first == null) {
            System.out.println("No hay nodos");
            return null;
        } else {
            Node<T> n = first;
            
            while (n != null) {
                System.out.println("Nodo: " + n
                        + "\tData: " + n.getData());
                n = n.getNext();
            }
            return x;
        }
    }

}
