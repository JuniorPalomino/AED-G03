package ejercicio1;

import actividad2.*;

public class Node<T>  {
    private T data;
    Node <T> next;
    
    public Node(T data){
        this.data = data;
        this.next = null;
    }
    
    public Node(T data, Node <T> next){
        this.data = data;
        this.next = next;
    }
    /*public Node(){
        this.data = null;
        this.next = null;
    }*/
    
    public T getData(){
        return this.data;
    }
    
    public Node getNext(){
        return this.next;
    }

    public void setData(T data){
        this.data = data;
    }
    
    public void setNext(Node next){
        this.next = next;
    }
    
    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", next=" + next + '}';
    }
    
    
}
