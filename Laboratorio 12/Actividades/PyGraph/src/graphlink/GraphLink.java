/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphlink;

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
    @Override
    public String toString() {
        return this.listVertex.toString();
    }

}
