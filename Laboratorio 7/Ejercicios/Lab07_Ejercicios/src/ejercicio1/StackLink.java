/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import actividad1.ExceptionIsEmpty;
import actividad1.Stack;

/**
 *
 * @author H P
 */
public class StackLink<E> implements Stack<E>{
    private Node<E> last ;

    public StackLink() {
        this.last = null;
    }

    @Override
    public void push(E x) {
        Node<E> aux = new Node<E>(x);
        Node<E> ultimo = this.last;
        if (isEmpty()) {
            this.last = aux;
        } else {
            this.last = aux;
            this.last.setNext(ultimo);
        }
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        Node<E> aux = this.last;
        if (isEmpty()) {
            throw new ExceptionIsEmpty();
        } else {
            this.last=this.last.next;
            return aux.getData();
        }
        
    }

    @Override
    public E top() throws ExceptionIsEmpty {
       if (isEmpty()) {
           throw new ExceptionIsEmpty();
        } else {
            return this.last.getData() ;
        }
    }

    @Override
    public boolean isEmpty() {
        

        return (this.last == null );

   
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Lista Vacía";
        }
        Node aux = this.last;
        boolean entra = !isEmpty();
        while (entra) {
            System.out.println(aux.getData());
            aux = aux.next;

            if (aux == null) {
                entra = false;
            }
        }

        return " ";
    
    }
    
    

    
}
