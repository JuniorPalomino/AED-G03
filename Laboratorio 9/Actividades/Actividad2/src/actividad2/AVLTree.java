package actividad2;
import actividad2.BSTree;

public class AVLTree<E extends Comparable<E>> extends BSTree<E>{
    // Clase interna que representa un nodo del árbol AVL
    protected class NodeAVL{
        protected E data;          // informacion del nodo
        protected NodeAVL left;    // nodo izquierdo
        protected NodeAVL right;   // nodo derecho
        protected int height;      // altura
        protected int bf;          // factor de balance
        
        public NodeAVL(E data){
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
            this.bf = 0;
        }

        @Override
        public String toString() {
            return "NodeAVL{" + "data=" + data + ", bf=" + bf + '}';
        }
    }

    protected NodeAVL root;                 // referencia al nodo raíz del árbol
    protected String lastRotation;          // ultima rotación realizada
    protected int lastBalanceFactor;        // ultimo factor de balance calculado

    // Constructor AVLTree
    public AVLTree() {
        this.root = null;
        this.lastRotation = "";
        this.lastBalanceFactor = 0;
    }

    // Verifica arbol vacío
    public boolean isEmpty() {
        return root == null;
    }

    // Inserta elemento al arbol
    public void insert(E data) throws ItemDuplicated {
        this.root = insertRec(root, data);
    }

    // Metodo auxiliar para realizar la insercion recursiva de un elemento en el arbol
    private NodeAVL insertRec(NodeAVL node, E data) throws ItemDuplicated {
        if (node == null) {
            return new NodeAVL(data);
        }
        if (data.compareTo(node.data) < 0) {
            node.left = insertRec(node.left, data);   
        } else if (data.compareTo(node.data) > 0) {
            node.right = insertRec(node.right, data); 
        } else {
            throw new ItemDuplicated("El elemento ya existe en el arbol AVL"); 
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        node.bf = getBalance(node);

        if (node.bf > 1 && data.compareTo(node.left.data) < 0) {
            lastRotation = "RSR";
            lastBalanceFactor = node.bf;
            return rotateSR(node);
        }

        if (node.bf < -1 && data.compareTo(node.right.data) > 0) {
            lastRotation = "RSL";
            lastBalanceFactor = node.bf;
            return rotateSL(node);
        }

        if (node.bf > 1 && data.compareTo(node.left.data) > 0) {
            lastRotation = "RDR";
            lastBalanceFactor = node.bf;
            node.left = rotateSL(node.left);
            return rotateSR(node);
        }

        if (node.bf < -1 && data.compareTo(node.right.data) < 0) {
            lastRotation = "RDL";
            lastBalanceFactor = node.bf;
            node.right = rotateSR(node.right);
            return rotateSL(node);
        }

        return node;
    }
    
    private NodeAVL balanceToRight(NodeAVL node) {
    NodeAVL son = (NodeAVL) node.left;

    switch (son.bf) {
        case -1:
            node.bf = 0;
            son.bf = 0;
            node = rotateSR(node);
            break;
        case 1:
            NodeAVL grandson = (NodeAVL) son.right;
            switch (grandson.bf) {
                case -1:
                    node.bf = -1;
                    son.bf = 0;
                    break;
                case 0:
                    node.bf = 0;
                    son.bf = 0;
                    break;
                case 1:
                    node.bf = 0;
                    son.bf = -1;
                    break;
            }
            grandson.bf = 0;
            node.left = rotateSL(son);
            node = rotateSR(node);
    }

    return node;
}
    // Realiza una rotación hacia la derecha en el árbol AVL
    private NodeAVL rotateSR(NodeAVL y) {
        NodeAVL x = y.left;
        NodeAVL T2 = x.right;

        x.right = y;
        y.left = T2;


        y.height = Math.max(height(y.left), height(y.right)) + 1;
        y.bf = getBalance(y);

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        x.bf = getBalance(x);

        return x; 
    }

    private NodeAVL rotateSL(NodeAVL x) {
        NodeAVL y = x.right;
        NodeAVL T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        x.bf = getBalance(x);

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        y.bf = getBalance(y);

        return y; 
    }

    // Obtiene la altura de un nodo
    private int height(NodeAVL node) {
        if (node == null) {
            return 0;
        }

        return node.height;
    }

    // Obtiene el factor de balance de un nodo
    private int getBalance(NodeAVL node) {
        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    // Obtiene la última rotación realizada en el árbol
    public String getLastRotation() {
        return lastRotation;
    }

    // Obtiene el último factor de balance calculado en el árbol
    public int getLastBalanceFactor() {
        return lastBalanceFactor;
    }

    // Obtiene el nodo raíz del árbol
    public NodeAVL getRoot() {
        return root;
    }
}



