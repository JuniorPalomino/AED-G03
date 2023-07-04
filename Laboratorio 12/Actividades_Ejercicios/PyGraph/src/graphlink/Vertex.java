/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphlink;

import ListLinked.ListLinked;




/**
 *
 * @author ADMIN
 */
public class Vertex <E>{
    private E data;
    protected ListLinked<Edge<E>> listAdj;
     private int label;  //0: unexplored    //1: visited

    public Vertex(E data) {
        this.data = data;
        listAdj = new ListLinked<Edge<E>>();
    }

    public E getData() {
        return data;
    }

    public int getLabel() {
        return this.label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

  
    @Override
    public boolean equals(Object o) {
        if(o instanceof Vertex<?>){
            
            Vertex<E> v =(Vertex<E>)o;
            return this.data.equals(v.data);
        }
        return false;
    }

    @Override
    public String toString() {
        return this.data+"-->"+this.listAdj.toString()+"\n";
    }
    
    
}
