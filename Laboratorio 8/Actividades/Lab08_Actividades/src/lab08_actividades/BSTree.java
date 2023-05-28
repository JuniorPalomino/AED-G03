package lab08_actividades;

import java.util.Stack;

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

    private Node<E> removeRec(E x, Node<E> actual) throws ItemDuplicated {

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
    public int countNodes() {
    if (isEmpty()) {
        return 0;
    }
    
    int count = 0;
    Stack<Node<E>> stack = new Stack<>();
    Node<E> current = root;
    
    while (current != null || !stack.isEmpty()) {
        if (current != null) {
            stack.push(current);
            current = current.left;
        } else {
            current = stack.pop();
            count++;
            current = current.right;
        }
    }
    
    return count;
}


    private Node<E> minRecover(Node<E> actual) {

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

            toString(node.right, sb, paddingForBoth, pointerRight);

            toString(node.left, sb, paddingForBoth, pointerLeft);

        }

    }

}
