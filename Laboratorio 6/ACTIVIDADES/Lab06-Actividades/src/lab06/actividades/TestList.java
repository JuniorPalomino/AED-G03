/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab06.actividades;

/**
 *
 * @author Alumno
 */
public class TestList {

    public static void main(String[] args) {
        ListLinked myList = new ListLinked();

        myList.insertFirst(1);
        myList.insertFirst(2);
        myList.insertFirst(3);
        myList.insertFirst(4);
        myList.insertFirst(5);
        myList.insertFirst(6);
        myList.insertFirst(7);
        myList.removeNode(3);
        myList.toString();
        int numNodes = myList.length();
        System.out.println("Numero de nodos en la lista: " + numNodes);
        //myList.search("a");
        myList.search(4);

        myList.destroyList();
        int numNodes2 = myList.length();
        System.out.println("Numero de nodos en la lista: " + numNodes2);
    }
}
