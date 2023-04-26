package lab06.actividades;

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
        while (n.getNext() != null) {
            if (n.getData() == x) {
                System.out.println("ENCONTRADO: ");
                return (int) x;
            }
            n = n.getNext();
        }
        System.out.println("NO ENCONTRADO");
        throw new ClassCastException("La variable no es de tipo int");
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
            if (n.getNext() == newNode) {
                n.setNext(newNode.getNext());
                size--;
                return;
            }
            n = n.getNext();
        }

    }

    @Override
    public String toString() {

        if (first == null) {
            System.out.println("No hay nodos");
            return null;
        } else {
            Node<T> n = first;
            while (n != null) {
                System.out.println("Nodo: " + n.getNext()
                        + "\nData: " + n.getData());
                n = n.getNext();
            }
            return null;
        }
    }

}
