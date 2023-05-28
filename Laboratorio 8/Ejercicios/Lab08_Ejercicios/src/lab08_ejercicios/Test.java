/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab08_ejercicios;

/**
 *
 * @author Asus
 */
public class Test {
        public static void main(String[] args) throws ItemDuplicated {
        // Crear un árbol binario de búsqueda
        BSTree<Integer> bst = new BSTree<>();

        // Insertar elementos en el árbol
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Mostrar el árbol en orden ascendente
        System.out.println("Árbol en orden ascendente:");
        System.out.println(bst.inOrden());

        // Contar el número de nodos
        int count = bst.countNodes();
        System.out.println("Número de nodos: " + count);
    }
}

  
