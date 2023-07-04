/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ListLinked;

/**
 *
 * @author ADMIN
 */
public interface TDAList<E> {
    boolean isEmpty();
    // determina si la lista está vacía

    int length();
    // determina la cantidad (longitud) de elementos que hay en la lista
    
    void destroyList();
    // elimina los elementos de la lista dejándola vacía

    int search(E x); 
    //verifica si el elemento x está o no en la lista, si está retorna su posición.

    void insertFirst(E x); 
    //inserta el nuevo elemento x al inicio de la lista

    void insertLast(E x); 
    //inserta el nuevo elemento x al final de la lista

    void removeNode(E x); 
    // elimina el elemento x de la lista
}
