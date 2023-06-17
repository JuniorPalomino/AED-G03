package BTree;

public class TestArbolB {

    public static void main(String[] args) {
        // Grado mínimo del Árbol B es t=3
        // Cada nodo soporta 2t hijos y 2t-1 claves
        int t = 3;

        // Se crea el árbol B según t
        ArbolB arbolB = new ArbolB(t);

        // Valores a ingresar primera ronda
        int[] valoresUno = {20, 10, 50, 30, 40};
        System.out.println("-- INICIO --");
        System.out.println("INSERTANDO VALORES AL ÁRBOL B");
        for (int i = 0; i < valoresUno.length; i++) {
            System.out.println("Insertando... valor " + valoresUno[i]);
            arbolB.insertar(valoresUno[i]);
            int[] caminoInsertion = arbolB.getCaminoRecorrido();
            System.out.println("Camino recorrido después de la inserción: " + arrayToString(caminoInsertion));
        }

        // Mostrando árbol B por pantalla en preorder
        System.out.println("ESTADO ÁRBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Valores a ingresar segunda ronda
        System.out.println("Insertando... valor 60");
        arbolB.insertar(60);
        int[] caminoInsertion2 = arbolB.getCaminoRecorrido();
        System.out.println("Camino recorrido después de la inserción: " + arrayToString(caminoInsertion2));

        // Mostrando árbol B por pantalla en preorder
        System.out.println("ESTADO ÁRBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Valores a ingresar tercera ronda
        System.out.println("Insertando... valor 80");
        arbolB.insertar(80);
        int[] caminoInsertion3 = arbolB.getCaminoRecorrido();
        System.out.println("Camino recorrido después de la inserción: " + arrayToString(caminoInsertion3));
        System.out.println("Insertando... valor 70");
        arbolB.insertar(70);
        int[] caminoInsertion4 = arbolB.getCaminoRecorrido();
        System.out.println("Camino recorrido después de la inserción: " + arrayToString(caminoInsertion4));
        System.out.println("Insertando... valor 90");
        arbolB.insertar(90);
        int[] caminoInsertion5 = arbolB.getCaminoRecorrido();
        System.out.println("Camino recorrido después de la inserción: " + arrayToString(caminoInsertion5));

        // Mostrando árbol B por pantalla en preorder
        System.out.println("ESTADO ÁRBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Valores a eliminar cuarta ronda
        System.out.println("Eliminando... valor 80");
        arbolB.eliminarClave(80);
        int[] caminoDeletion = arbolB.getCaminoRecorrido();
        System.out.println("Camino recorrido después de la eliminación: " + arrayToString(caminoDeletion));

        // Mostrando árbol B por pantalla en preorder
        System.out.println("ESTADO ÁRBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Valores a eliminar cuarta ronda
        System.out.println("Eliminando... valor 90");
        arbolB.eliminarClave(90);
        int[] caminoDeletion2 = arbolB.getCaminoRecorrido();
        System.out.println("Camino recorrido después de la eliminación: " + arrayToString(caminoDeletion2));

        // Mostrando árbol B por pantalla en preorder
        System.out.println("ESTADO ÁRBOL B");
        arbolB.showBTree();
        System.out.println("");

        // Buscar
        System.out.println("\nBuscando el nodo con el valor 20 en el árbol B:");
        arbolB.buscarNodoPorClave(20);
        int[] caminoSearch = arbolB.getCaminoRecorrido();
        System.out.println("Camino recorrido después de la búsqueda: " + arrayToString(caminoSearch));

        
        int maximo = arbolB.encontrarMaximo();
        System.out.println("Valor máximo del Árbol B: " + maximo);
        
        System.out.println("");
        System.out.println("-- FIN --");
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}
