package lab06.actividades;

public class Node<T> {
    private T data;
    private Node<T> next;
    
    public Node(T data){
        this.data = data;
        this.next = null;
    }
    
    public Node(T data, Node <T> next){
        this.data = data;
        this.next = next;
    }
    
    public T getData(){
        return this.data;
    }
    
    public Node<T> getNext(){
        return this.next;
    }

    public void setData(T data){
        this.data = data;
    }
    
    public void setNext(Node<T> next){
        this.next = next;
    }
    
    @Override
    public String toString() {
        return "Node{" + "data=" + data + ", next=" + next + '}';
    }
    
    
}
