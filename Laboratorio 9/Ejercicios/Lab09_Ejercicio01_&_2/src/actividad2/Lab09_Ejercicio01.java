/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package actividad2;

/**
 *
 * @author ADMIN
 */
public class Lab09_Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ItemDuplicated, ItemNotFound {
        // TODO code application logic here

        
        //----EJERCICIO 01----//
        BSTree<Integer> bst = new BSTree<>();
        try {
            bst.insert(5);
            bst.insert(3);
            bst.insert(7);
            bst.insert(2);
            bst.insert(4);
            bst.insert(6);
            bst.insert(8);
        } catch (ItemDuplicated e) {
            e.printStackTrace();
        }

        // Obtener la altura del árbol BST
        int bstHeight = bst.height();
        System.out.println("Altura del árbol BST: " + bstHeight);
        System.out.println("Elemento encontrado " + bst.search(3));

        // Crear un árbol AVL
        AVLTree<Integer> avl = new AVLTree<>();
        try {
            avl.insert(5);
            avl.insert(3);
            avl.insert(7);
            avl.insert(2);
            avl.insert(4);
            avl.insert(6);
            avl.insert(8);
        } catch (ItemDuplicated e) {
            e.printStackTrace();
        }

        // Obtener la altura del árbol AVL
        int avlHeight = avl.height();
        System.out.println("Altura del árbol AVL: " + avlHeight);
        System.out.println("Elemento encontrado " + avl.search(2));

        // Caso de prueba 2: Comparando la altura de un árbol BST y un árbol AVL
        // Crear un árbol BST
        BSTree<Integer> bst2 = new BSTree<>();
        try {
            bst2.insert(1);
            bst2.insert(2);
            bst2.insert(3);
            bst2.insert(4);
            bst2.insert(5);
            bst2.insert(6);
            bst2.insert(7);
        } catch (ItemDuplicated e) {
            e.printStackTrace();
        }

        // Obtener la altura del árbol BST
        int bstHeight2 = bst2.height();
        System.out.println("Altura del árbol BST: " + bstHeight2);
        System.out.println("Elemento encontrado " + bst2.search(1));

        // Crear un árbol AVL
        AVLTree<Integer> avl2 = new AVLTree<>();
        try {
            avl2.insert(1);
            avl2.insert(2);
            avl2.insert(3);
            avl2.insert(4);
            avl2.insert(5);
            avl2.insert(6);
            avl2.insert(7);
        } catch (ItemDuplicated e) {
            e.printStackTrace();
        }

        // Obtener la altura del árbol AVL
        int avlHeight2 = avl2.height();
        System.out.println("Altura del árbol AVL: " + avlHeight2);
        System.out.println("Elemento encontrado " + avl2.search(4));
        
        
         
    }
}
