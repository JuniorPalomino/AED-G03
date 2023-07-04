/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListLinked;

/**
 *
 * @author ADMIN
 */
public class ListLinked<T> implements TDAList<T> {
    protected Node<T> first;
    protected int count;

    public ListLinked() {
        this.first = null;
        this.count = 0;
    }

    public boolean isEmpty() {
        return this.first == null;
    }

    public int length() {
        return count;
    }

    public Node<T> getFirst() {
        return this.first;
    }

    public void destroyList() {
        while (first != null) {
            this.first = first.getNext();
        }
        this.count = 0;
    }

    public int search(T x) {
        Node<T> aux = this.first;
        int pos = 0;
        while (aux != null && !aux.getData().equals(x)) {
            pos++;
            aux = aux.getNext();
        }
        if (aux != null)
            return pos;
        return -1;
    }

    public T searchNode(T x) {
        Node<T> aux = this.first;
        for(;aux != null; aux = aux.getNext())
            if (aux.getData().equals(x))
                return aux.getData();
        return null;
    }

    public boolean searchB(T x) {
        Node<T> aux = this.first;
        while (aux != null && !aux.getData().equals(x)) {
            aux = aux.getNext();
        }
        if (aux != null)
            return true;
        return false;
    }

    public void insertFirst(T x) {
        this.first = new Node<T>(x, this.first);
        this.count++;
    }

    public void insertLast(T x) {
        if (isEmpty())
            insertFirst(x);
        else {
            Node<T> aux = this.first;
            while (aux.getNext() != null)
                aux = aux.getNext();
            aux.setNext(new Node<T>(x));
            this.count++;
        }
    }

    public void removeNode(T x) {
        if (isEmpty()) {
            return;
        }
        if (first.getData().equals(x)) {
            first = first.getNext();
            count--;
            return;
        }
        Node<T> previous = first;
        Node<T> current = first.getNext();
        while (current != null && !current.getData().equals(x)) {
            previous = current;
            current = current.getNext();
        }
        if (current != null) {
            previous.setNext(current.getNext());
            count--;
        }
    }

    public String toString() {
        String str = "";
        for (Node<T> aux = this.first; aux != null; aux = aux.getNext())
            str += aux.toString() + ", ";
        return str;
    }
    
    
}
