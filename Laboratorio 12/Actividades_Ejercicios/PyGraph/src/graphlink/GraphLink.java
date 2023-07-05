/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphlink;

import java.util.*;
import ListLinked.ListLinked;
import ListLinked.Node;

/**
 *
 * @author ADMIN
 */
public class GraphLink<E> {

    protected ListLinked<Vertex<E>> listVertex;

    public GraphLink() {
        listVertex = new ListLinked<Vertex<E>>();
    }

    public void insertVertex(E data) {

        Vertex<E> v = new Vertex<E>(data);
        if (this.listVertex.searchB(v)) {
            System.out.println("Vertice ya fue insertado previamente ...");
        } else {
            this.listVertex.insertFirst(v);
        }

    }

    public void insertEdge(E dataOri, E dataDes) {

        Vertex<E> verOri = this.listVertex.searchNode(new Vertex<E>(dataOri));
        Vertex<E> verDes = this.listVertex.searchNode(new Vertex<E>(dataDes));

        if (verOri == null || verDes == null) {
            System.out.println("Alguno de los vertices no existe ...");
        } else {
            Edge<E> e = new Edge<E>(verDes);
            Edge<E> e1 = new Edge<E>(verOri);
            if (verOri.listAdj.searchB(e)) {
                System.out.println("Arista ya fue isnertada previamente ...");
            } else {
                verOri.listAdj.insertFirst(e);
            }
            verDes.listAdj.insertFirst(e1);
        }
    }

    //--------------Punto 4.3----------------------//
    public boolean searchVertex(E data) {
        Vertex<E> v = this.listVertex.searchNode(new Vertex<E>(data));
        if (v == null) {
            return false;
        }
        return true;
    }

    public boolean searchEdge(Vertex<E> v, Vertex<E> z) {
        ListLinked<Edge<E>> adjList = v.listAdj;
        Node<Edge<E>> currentNode = adjList.getFirst();

        while (currentNode != null) {
            Edge<E> currentEdge = currentNode.getData();
            Vertex<E> destinationVertex = currentEdge.getRefDest();

            if (destinationVertex.equals(z)) {
                return true;
            }

            currentNode = currentNode.getNext();
        }

        return false;
    }

    //------------------Fin Punto 4.3------------------//
    //--------------Punto 4.4----------------------//
    public void removeVertex(Vertex<E> v) {
        // Buscar el vértice v en la lista de vértices
        Node<Vertex<E>> vertexNode = listVertex.getFirst();
        Vertex<E> vertexToRemove = null;

        while (vertexNode != null) {
            Vertex<E> currentVertex = vertexNode.getData();
            if (currentVertex.equals(v)) {
                vertexToRemove = currentVertex;
                break;
            }
            vertexNode = vertexNode.getNext();
        }

        if (vertexToRemove == null) {
            // El vértice no existe en el grafo
            System.out.println("El vértice no existe en el grafo.");
            return;
        }

        // Eliminar las aristas asociadas al vértice v
        Node<Vertex<E>> currentVertexNode = listVertex.getFirst();
        while (currentVertexNode != null) {
            Vertex<E> currentVertex = currentVertexNode.getData();
            ListLinked<Edge<E>> adjList = currentVertex.listAdj;
            adjList.removeNode(new Edge<E>(vertexToRemove));
            currentVertexNode = currentVertexNode.getNext();
        }

        // Eliminar el vértice v de la lista de vértices
        listVertex.removeNode(vertexToRemove);
    }

    public void removeEdge(Vertex<E> v, Vertex<E> z) {
        ListLinked<Edge<E>> adjList = v.listAdj;
        Edge<E> edgeToRemove = new Edge<E>(z);

        if (adjList.searchB(edgeToRemove)) {
            adjList.removeNode(edgeToRemove);
            System.out.println("Arista entre los vértices v y z ha sido eliminada.");
        } else {
            System.out.println("No existe una arista entre los vértices v y z.");
        }
    }

//--------------Fin Punto 4.4----------------------//
    //--------------Punto 4.5----------------------//
    public void dfs(E data) {
        Vertex<E> v = searchVertec(data);
        if (v == null) {
            return;
        }

        initLabel();
        dfs(v);
    }

    public Vertex<E> searchVertec(E data) {
        Vertex<E> v = this.listVertex.searchNode(new Vertex<E>(data));
        if (v == null) {
            System.out.println("Vertice no existe ...");
            return null;
        }
        return v;
    }

    private void initLabel() {
        Node<Vertex<E>> nodeVer = this.listVertex.getFirst();
        for (; nodeVer != null; nodeVer = nodeVer.getNext()) {
            Vertex<E> v = nodeVer.getData();
            v.setLabel(0);
            Node<Edge<E>> nodeEdge = v.listAdj.getFirst();
            for (; nodeEdge != null; nodeEdge = nodeEdge.getNext()) {
                Edge<E> e = nodeEdge.getData();
                e.setLabel(0);
            }
        }
    }

    private void dfs(Vertex<E> vert) {
        vert.setLabel(1);
        System.out.println(vert.getData() + ", ");
        Node<Edge<E>> nodeEdge = vert.listAdj.getFirst();
        for (; nodeEdge != null; nodeEdge = nodeEdge.getNext()) {
            Edge<E> e = nodeEdge.getData();
            if (e.getLabel() == 0) {
                Vertex<E> w = opposite(e);
                if (w.getLabel() == 0) {
                    e.setLabel(1);
                    dfs(w);
                } else {
                    e.setLabel(2);
                }
            }
        }
    }

    private Vertex<E> opposite(Edge<E> e) {
        return e.getRefDest();
    }

    //--------------Fin Punto 4.5----------------------//
    //--------------Ejercicio 1----------------------//    
    public void bfs(E data) {
        Vertex<E> startVertex = searchVertec(data);
        if (startVertex == null) {
            return;
        }

        initLabel();
        bfs(startVertex);
    }

    private void bfs(Vertex<E> startVertex) {
        Queue<Vertex<E>> queue = new LinkedList<>();
        startVertex.setLabel(1);
        queue.offer(startVertex);

        while (!queue.isEmpty()) {
            Vertex<E> currentVertex = queue.poll();
            System.out.println(currentVertex.getData());

            ListLinked<Edge<E>> adjList = currentVertex.listAdj;
            Node<Edge<E>> edgeNode = adjList.getFirst();

            while (edgeNode != null) {
                Edge<E> currentEdge = edgeNode.getData();
                Vertex<E> destinationVertex = currentEdge.getRefDest();

                if (destinationVertex.getLabel() == 0) {
                    destinationVertex.setLabel(1);
                    queue.offer(destinationVertex);
                }

                edgeNode = edgeNode.getNext();
            }
        }
    }

    public ArrayList<Vertex<E>> bfsPath(E startData, E endData) {
        Vertex<E> startVertex = searchVertec(startData);
        Vertex<E> endVertex = searchVertec(endData);

        if (startVertex == null || endVertex == null) {
            System.out.println("Alguno de los vértices no existe ...");
            return null;
        }

        initLabel();
        ArrayList<Vertex<E>> path = bfsPath(startVertex, endVertex);

        if (path.isEmpty()) {
            System.out.println("No se encontró un camino entre los vértices especificados.");
        }

        return path;
    }

    private ArrayList<Vertex<E>> bfsPath(Vertex<E> startVertex, Vertex<E> endVertex) {
        Queue<ArrayList<Vertex<E>>> queue = new LinkedList<>();
        ArrayList<Vertex<E>> initialPath = new ArrayList<>();
        initialPath.add(startVertex);
        queue.offer(initialPath);

        while (!queue.isEmpty()) {
            ArrayList<Vertex<E>> currentPath = queue.poll();
            Vertex<E> lastVertex = currentPath.get(currentPath.size() - 1);

            if (lastVertex.equals(endVertex)) {
                return currentPath;
            }

            ListLinked<Edge<E>> adjList = lastVertex.listAdj;
            Node<Edge<E>> edgeNode = adjList.getFirst();

            while (edgeNode != null) {
                Edge<E> currentEdge = edgeNode.getData();
                Vertex<E> destinationVertex = currentEdge.getRefDest();

                if (!currentPath.contains(destinationVertex)) {
                    ArrayList<Vertex<E>> newPath = new ArrayList<>(currentPath);
                    newPath.add(destinationVertex);
                    queue.offer(newPath);
                }

                edgeNode = edgeNode.getNext();
            }
        }

        return new ArrayList<>(); // Si no se encontró un camino, se devuelve una lista vacía
    }

    //--------------Fin Ejercicio 1----------------------//
    //--------------Ejercicio 2----------------------//
    public void insertEdgeWeight(Vertex<E> v, Vertex<E> z, int weight) {
        ListLinked<Edge<E>> adjList = v.listAdj;
        Edge<E> newEdge = new Edge<E>(z, weight);

        if (!adjList.searchB(newEdge)) {
            adjList.insertFirst(newEdge);
            System.out.println("Arista insertada correctamente entre los vértices v y z.");
        } else {
            System.out.println("Ya existe una arista entre los vértices v y z.");
        }

    }

    public ArrayList<Vertex<E>> shortPath(Vertex<E> v, Vertex<E> z) {
        HashMap<Vertex<E>, Integer> distances = new HashMap<>(); // Almacena las distancias acumuladas
        HashMap<Vertex<E>, Vertex<E>> predecessors = new HashMap<>(); // Almacena los predecesores de cada vértice
        PriorityQueue<Vertex<E>> queue = new PriorityQueue<>(Comparator.comparingInt(distances::get)); // Cola de prioridad basada en las distancias acumuladas
        ArrayList<Vertex<E>> shortestPath = new ArrayList<>(); // Lista que almacenará la ruta más corta

        // Paso 1: Inicializar distancias y predecesores
        distances.put(v, 0);
        predecessors.put(v, null);

        // Paso 2: Agregar el vértice de origen a la cola de prioridad
        queue.offer(v);

        // Paso 3: Calcular la ruta más corta
        while (!queue.isEmpty()) {
            Vertex<E> currentVertex = queue.poll();

            // Paso 3.1: Actualizar las distancias acumuladas
            ListLinked<Edge<E>> adjList = currentVertex.listAdj;
            Node<Edge<E>> edgeNode = adjList.getFirst();
            while (edgeNode != null) {
                Edge<E> currentEdge = edgeNode.getData();
                Vertex<E> destinationVertex = currentEdge.getRefDest();
                int weight = currentEdge.getWeight();
                int newDistance = distances.get(currentVertex) + weight;

                if (!distances.containsKey(destinationVertex) || newDistance < distances.get(destinationVertex)) {
                    distances.put(destinationVertex, newDistance);
                    predecessors.put(destinationVertex, currentVertex);
                    queue.offer(destinationVertex);
                }

                edgeNode = edgeNode.getNext();
            }
        }

        // Paso 4: Reconstruir la ruta más corta
        Vertex<E> currentVertex = z;
        while (currentVertex != null) {
            shortestPath.add(0, currentVertex);
            currentVertex = predecessors.get(currentVertex);
        }

        return shortestPath;
    }

//--------------Fin Ejercicio 2----------------------//
    @Override
    public String toString() {
        return this.listVertex.toString();
    }

}
