package graphmatrix;

public class GraphMat<E> {
    private int numVertices;
    private Object[] vertices;
    private int[][] matrix;

    public GraphMat(int numVertices) {
        this.numVertices = numVertices;
        this.vertices = new Object[numVertices];
        this.matrix = new int[numVertices][numVertices];
    }

    public boolean insertVertex(E data) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] == null) {
                vertices[i] = data;
                return true;
            }
        }
        return false;
    }

    public boolean insertEdge(E dataOri, E dataDes) {
        int indexOri = -1;
        int indexDes = -1;

        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] != null) {
                if (vertices[i].equals(dataOri)) {
                    indexOri = i;
                } else if (vertices[i].equals(dataDes)) {
                    indexDes = i;
                }
            }
        }

        if (indexOri != -1 && indexDes != -1) {
            matrix[indexOri][indexDes] = 1;
            return true;
        }

        return false;
    }

    public boolean searchVertex(E data) {
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] != null && vertices[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchEdge(E dataOri, E dataDes) {
        int indexOri = -1;
        int indexDes = -1;

        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] != null) {
                if (vertices[i].equals(dataOri)) {
                    indexOri = i;
                } else if (vertices[i].equals(dataDes)) {
                    indexDes = i;
                }
            }
        }

        if (indexOri != -1 && indexDes != -1) {
            return matrix[indexOri][indexDes] == 1;
        }

        return false;
    }

    public void dfs(E data) {
        int startIndex = -1;

        for (int i = 0; i < numVertices; i++) {
            if (vertices[i] != null && vertices[i].equals(data)) {
                startIndex = i;
                break;
            }
        }

        if (startIndex == -1) {
            return;
        }

        boolean[] visited = new boolean[numVertices];
        dfs(startIndex, visited);
    }

    private void dfs(int vertexIndex, boolean[] visited) {
        visited[vertexIndex] = true;
        System.out.print(vertices[vertexIndex] + " ");

        for (int i = 0; i < numVertices; i++) {
            if (matrix[vertexIndex][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }
}

