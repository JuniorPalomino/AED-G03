/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphlink;

import java.util.Objects;

/**
 *
 * @author ADMIN
 */
public class Edge<E> {
    
    private Vertex<E> refDest;
    private int weight;
    private int label; //0:unexplored   //1:discovery   //2:back

    public Edge(Vertex<E> refDest) {
        this(refDest,-1);
    }

    public Edge(Vertex<E> refDest, int weight) {
        this.refDest = refDest;
        this.weight = weight;
    }

    public Vertex<E> getRefDest() {
        return refDest;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    
    public int getLabel() {
        return this.label;
    }

    public void setLabel(int label) {
        this.label = label;
    }

    @Override
    public boolean equals(Object o) {
       if(o instanceof Edge<?>){
            
            Edge<E> e =(Edge<E>)o;
            return this.refDest.equals(e.refDest);
        }
        return false;
    }

    @Override
    public String toString() {
        if(this.weight>-1)return refDest.getData()+"["+this.weight+"]";
        else return refDest.getData()+",";
    }
    
    
    }
    
     
    
    

