package lab08_ejercicios;

public class Lab08_Ejercicios {

    public static void main(String[] args) throws ItemDuplicated {
        try {
            BSTree<Integer> bst = new BSTree<>();
            bst.insert(50);
            bst.insert(30);
            bst.insert(70);
            bst.insert(20);
            bst.insert(40);
            bst.insert(60);
            bst.insert(80);
            bst.insert(10);
            bst.insert(45);
            bst.insert(65);
            bst.insert(75);
            bst.insert(85);

            System.out.println(bst.getMaxNode());
            System.out.println(bst.obtenerAreaArbol());
        } catch (ItemDuplicated e) {
            System.out.println(e.getMessage());
        }
    }

}
