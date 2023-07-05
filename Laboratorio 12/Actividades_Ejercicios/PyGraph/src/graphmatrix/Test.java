
package graphmatrix;


public class Test {
    public static void main(String[] args) {
        // Crear un grafo con 5 vértices
        GraphMat graph = new GraphMat(5);

        // Vertices
        graph.insertVertex(0);
        graph.insertVertex(1);
        graph.insertVertex(2);
        graph.insertVertex(3);
        graph.insertVertex(4);

        // Aristas
        graph.insertEdge(0, 1);
        graph.insertEdge(0, 2);
        graph.insertEdge(1, 3);
        graph.insertEdge(2, 4);
        graph.insertEdge(3, 4);

        System.out.println("¿Existe el vértice 3? " + graph.searchVertex(3)); // true
        System.out.println("¿Existe el vértice 5? " + graph.searchVertex(5)); // false
        System.out.println("¿Existe la arista entre 0 y 1? " + graph.searchEdge(0, 1)); // true
        System.out.println("¿Existe la arista entre 0 y 4? " + graph.searchEdge(0, 4)); // false

        System.out.print("Recorrido en profundidad: ");
        graph.dfs(0);
        System.out.println();
    }
}

