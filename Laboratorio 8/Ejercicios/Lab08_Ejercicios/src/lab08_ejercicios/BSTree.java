package lab08_ejercicios;

import java.util.Stack;
import java.util.StringJoiner;

public class BSTree<E extends Comparable<E>> {

    class Node<E> {

        protected E data;
        protected Node left, right;

        public Node(E data) {
            this(data, null, null);
        }

        public Node(E data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Node{" + "data=" + data + ", left=" + left + ", right=" + right + '}';
        }

    }
    private Node root;

    public BSTree() {
        this.root = null;
    }

    public boolean isEmpty() {
        return this.root == null;
    }

    public void insert(E x) throws ItemDuplicated {
        this.root = insertRec(x, this.root);
    }

    private Node<E> insertRec(E x, Node<E> actual) throws ItemDuplicated {
        Node<E> res = actual;

        if (actual == null) {

            res = new Node<E>(x);

        } else {
            int resC = actual.data.compareTo(x);
            if (resC == 0) {
                throw new ItemDuplicated(x + "esta duplicado");
            }
            if (resC < 0) {
                res.right = insertRec(x, actual.right);
            } else {
                res.left = insertRec(x, actual.left);
            }
        }
        return res;
    }

    public E search(E x) throws ItemDuplicated {

        Node<E> res = searchRec(x, this.root);

        if (res == null) {
            throw new ItemDuplicated("El dato" + x + "no esta");
        }
        return res.data;

    }

    private Node<E> searchRec(E x, Node<E> n) {

        if (n == null) {
            return null;
        } else {
            int resC = n.data.compareTo(x);
            if (resC < 0) {
                return searchRec(x, n.right);
            } else if (resC > 0) {
                return searchRec(x, n.left);
            } else {
                return n;
            }
        }
    }

    public void remove(E x) throws ItemDuplicated {

        root = removeRec(x, this.root);

    }

    public Node<E> removeRec(E x, Node<E> actual) throws ItemDuplicated {

        Node<E> res = actual;

        if (actual == null) {

            throw new ItemDuplicated("Elemento no encontrado");

        }

        int resC = actual.data.compareTo(x);

        if (resC < 0) {

            res.right = removeRec(x, actual.right);

        } else if (resC > 0) {

            res.left = removeRec(x, actual.left);

        } else {

            if (actual.left != null && actual.right != null) {

                res.data = (E) minRecover(actual.right).data;

                res.right = minRemove(actual.right);

            } else {

                res = (actual.left != null) ? res.left : res.right;

            }

        }

        return res;

    }

    private Node<E> minRemove(Node<E> actual) {

        if (actual.left != null) {          //Buscamos el minmo

            actual.left = minRemove(actual.left);

        } else {                            //Eliminamos el minimo

            actual = actual.right;

        }

        return actual;

    }

    public E minRemove() {

        E min = minRecover();

        this.root = minRemove(this.root);

        return min;

    }

    public E minRecover() {

        Node aux = minRecover(this.root);

        return (E) aux.data;

    }

    public Node<E> minRecover(Node<E> actual) {

        if (actual.left == null) {

            return actual;

        } else {

            return minRecover(actual.left);

        }

    }

    public String inOrden() {
        if (root != null) {
            return inOrden(root);
        } else {
            return "*";
        }
    }

    protected String inOrden(Node<E> actual) {
        String res = "";
        if (actual.left != null) {
            res += inOrden(actual.left);
        }
        res += actual.data.toString() + ", ";
        if (actual.right != null) {
            res += inOrden(actual.right);
        }
        return res;

    }

    // Metodo para contar nodos en un árbol binario
    public int countNodes(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    //Altura de un Nodo
    public int height(Node node) {
        if (node == null) {
            return 0;
        } else {
            int lHeight = height(node.left);
            int rHeight = height(node.right);
            return (lHeight > rHeight) ? (lHeight + 1) : (rHeight + 1);
        }
    }

    //Metodo PreOrden---Ejercicio 03
    
    public String preOrdenIterativo() {
        
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Stack<Node<E>> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node<E> nodoActual = stack.pop();
            sb.append(nodoActual.data).append(" ");

            if (nodoActual.right != null) {
                stack.push(nodoActual.right);
            }

            if (nodoActual.left != null) {
                stack.push(nodoActual.left);
            }
        }

        return sb.toString().trim();
    }

    public String toString() {

        if (root == null) {

            return "";

        }

        StringBuilder sb = new StringBuilder();

        toString(root, sb, "", "");

        return sb.toString();

    }

    private void toString(Node node, StringBuilder sb, String padding, String pointer) {

        if (node != null) {

            sb.append(padding);

            sb.append(pointer);

            sb.append(node.data.toString());

            sb.append("\n");

            StringBuilder paddingBuilder = new StringBuilder(padding);

            paddingBuilder.append("│  ");

            String paddingForBoth = paddingBuilder.toString();

            String pointerRight = "└──";

            String pointerLeft = (node.right != null) ? "├──" : "└──";

            toString(node.left, sb, paddingForBoth, pointerLeft);

            toString(node.right, sb, paddingForBoth, pointerRight);

        }

    }
    
    //Metodo getTreeArea---Ejercicio 04
    
    public int obtenerAreaArbol() {
        int cantidadHojas = contarHojas(root);
        int altura = height(root);
        return cantidadHojas * altura;
    }

    private int contarHojas(Node<E> nodo) {
        if (nodo == null) {
            return 0;
        }
        if (nodo.left == null && nodo.right == null) {
            return 1;
        }
        return contarHojas(nodo.left) + contarHojas(nodo.right);
    }

    //Metodo getMinNode---Ejercicio 06
    
    public Node<E> getMinNode() {
        if (root == null) {
            return null;
        }

        Node<E> aux = root;
        while (aux.left != null) {
            aux = aux.left;
        }

        return aux;
    }

    public Node<E> getMaxNode() {
        if (root == null) {
            return null;
        }

        Node<E> current = root;
        while (current.right != null) {
            current = current.right;
        }

        return current;
    }

    public void parenthesize() {
        if (root == null) {
            System.out.println("El árbol está vacío.");
            return;
        }

        parenthesize(root, 0);
    }

    private void parenthesize(Node<E> node, int level) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < level; i++) {
            sb.append("  ");
        }

        sb.append(node.data);

        if (node.left != null || node.right != null) {
            sb.append("(");

            System.out.println(sb.toString());

            if (node.left != null) {
                parenthesize(node.left, level + 1);
            } else {
                System.out.println();
            }

            if (node.right != null) {
                parenthesize(node.right, level + 1);
            } else {
                System.out.println();
            }

            for (int i = 0; i < level; i++) {
                System.out.print("  ");
            }

            System.out.print(")");
        } else {
            System.out.println(sb.toString());
        }
    }

}
