/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab08_actividades;

/**
 *
 * @author H P
 */
public class BSTree<E extends Comparable<E>> {
    
    class Node{
    
        protected E data;
        protected Node lefth,right;

        public Node(E data) {
            this(data,null,null);
        }

        public Node(E data, Node lefth, Node right) {
            this.data = data;
            this.lefth = lefth;
            this.right = right;
        }        
        
        
    }
    private Node root;
        
        public BSTree(){this.root=null;}
        public boolean isEmpty(){return this.root==null;}
    
    public void insert(E x) throws ItemDuplicated{
    
    }
    
    public E search(E x) throws ItemDuplicated{
        
        return x;
    
    }
    public void remove(E x) throws ItemDuplicated{
    
    }
    public void inOrden() {
    
    }
    
    public void inOrden(Node actual) {
    
    }
    
}
