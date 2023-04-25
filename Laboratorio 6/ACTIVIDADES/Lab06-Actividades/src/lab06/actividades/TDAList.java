/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package lab06.actividades;

/**
 *
 * @author Alumno
 */
public interface TDAList<T> {
    
    
    boolean isEmptyList();
    int length();
    void destroyList();
    int search(T x);
    void insertFirst(T x);
    void insertLast(T x);
    void removeNode(T x);
    
    
}
