package BTree;

/**
 *
 * @author vical
 */
public class ArbolB {

    NodoArbolB root;
    int t;
    private int[] caminoRecorrido;
    private int index;

    //Constructor
    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbolB(t);
        caminoRecorrido = new int[100]; // Tamaño del arreglo puede ser ajustado según necesidad
        index = 0;
    }

    //Busca el valor ingresado y muestra el contenido del nodo que contiene el valor
    public void buscarNodoPorClave(int num) {
        NodoArbolB temp = search(root, num);

        if (temp == null) {
            System.out.println("No se ha encontrado un nodo con el valor ingresado");
        } else {
            print(temp);
        }
    }
//------------------Ejercicio 03---------------------------------------//
    //Search

    private NodoArbolB search(NodoArbolB actual, int key) {
        int i = 0;

        // Incrementa el índice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && key > actual.key[i]) {
            i++;
        }

        // Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            caminoRecorrido[index++] = actual.key[i]; // Agregar el nodo al camino recorrido
            return actual;
        }

        // Si llegamos hasta aquí, entonces hay que buscar los hijos
        if (actual.leaf) {
            return null;
        } else {
            // Si tiene hijos, hace una llamada recursiva
            caminoRecorrido[index++] = actual.key[i]; // Agregar el nodo al camino recorrido
            return search(actual.child[i], key);
        }
    }

//---------------------------------------------------------//
    public int[] getCaminoRecorrido() {
        int[] resultado = new int[index];
        System.arraycopy(caminoRecorrido, 0, resultado, 0, index);
        index = 0; // Restablecer el índice después de obtener el camino recorrido
        return resultado;
    }

//---------------------------------------------------------//
    public void insertar(int key) {
        NodoArbolB r = root;

        //Si el nodo esta lleno lo debe separar antes de insertar
        if (r.n == ((2 * t) - 1)) {
            NodoArbolB s = new NodoArbolB(t);
            root = s;
            s.leaf = false;
            s.n = 0;
            s.child[0] = r;
            split(s, 0, r);
            nonFullInsert(s, key);
        } else {
            nonFullInsert(r, key);
        }
    }

    //-------------------------Ejercicio 1--------------------------
    public void eliminarClave(int clave) {
        eliminarEnNodo(root, clave);

        // Verificar si el nodo raíz quedó vacío después de la eliminación
        if (root.n == 0) {
            // Si el nodo raíz está vacío y no es una hoja, se reemplaza por su único hijo
            if (!root.leaf) {
                root = root.child[0];
            }
        }
    }

    private void eliminarEnNodo(NodoArbolB nodo, int clave) {
        int indice = nodo.find(clave);

        // La clave está presente en el nodo
        if (indice != -1) {
            if (nodo.leaf) {
                // Caso 1: La clave está en un nodo hoja
                eliminarDeHoja(nodo, indice);
            } else {
                // Caso 2: La clave está en un nodo interno
                eliminarDeInterno(nodo, indice);
            }
        } else {
            // La clave no está presente en el nodo
            if (nodo.leaf) {
                // Caso base: La clave no está presente y el nodo es una hoja
                System.out.println("La clave " + clave + " no existe en el árbol.");
                return;
            }

            // Recorrer al hijo apropiado donde podría estar la clave
            int i = 0;
            while (i < nodo.n && clave > nodo.key[i]) {
                i++;
            }

            // Verificar si el hijo tiene el número mínimo de claves
            if (nodo.child[i].n == t - 1) {
                ajustarHijoDeficiente(nodo, i);
            }

            // Llamar recursivamente a eliminarEnNodo en el hijo adecuado
            eliminarEnNodo(nodo.child[i], clave);
        }
    }

    private void eliminarDeHoja(NodoArbolB nodo, int indice) {
        // Mover las claves hacia la izquierda para eliminar la clave
        for (int i = indice + 1; i < nodo.n; i++) {
            nodo.key[i - 1] = nodo.key[i];
        }

        nodo.n--;
    }

    private void eliminarDeInterno(NodoArbolB nodo, int indice) {
        int clave = nodo.key[indice];

        // Obtener el predecesor de la clave
        int predecesor = obtenerClavePredecesor(nodo, indice);
        NodoArbolB hijoIzquierdo = nodo.child[indice];
        NodoArbolB hijoDerecho = nodo.child[indice + 1];

        // Verificar si el hijo izquierdo tiene al menos t claves
        if (hijoIzquierdo.n >= t) {
            // Encontrar el predecesor en el subárbol izquierdo
            eliminarEnNodo(hijoIzquierdo, predecesor);

            // Reemplazar la clave por el predecesor
            nodo.key[indice] = predecesor;
            return;
        }

        // Verificar si el hijo derecho tiene al menos t claves
        if (hijoDerecho.n >= t) {
            // Encontrar el sucesor en el subárbol derecho
            int sucesor = obtenerClaveSucesor(nodo, indice);
            eliminarEnNodo(hijoDerecho, sucesor);

            // Reemplazar la clave por el sucesor
            nodo.key[indice] = sucesor;
            return;
        }

        // Si ambos hijos tienen t-1 claves, fusionarlos
        fusionarNodos(nodo, indice);
        eliminarEnNodo(hijoIzquierdo, clave);
    }

    private int obtenerClavePredecesor(NodoArbolB nodo, int indice) {
        NodoArbolB actual = nodo.child[indice];
        while (!actual.leaf) {
            actual = actual.child[actual.n];
        }
        return actual.key[actual.n - 1];
    }

    private int obtenerClaveSucesor(NodoArbolB nodo, int indice) {
        NodoArbolB actual = nodo.child[indice + 1];
        while (!actual.leaf) {
            actual = actual.child[0];
        }
        return actual.key[0];
    }

    private void ajustarHijoDeficiente(NodoArbolB nodo, int indice) {
        NodoArbolB hijoActual = nodo.child[indice];
        NodoArbolB vecinoIzquierdo = (indice > 0) ? nodo.child[indice - 1] : null;
        NodoArbolB vecinoDerecho = (indice < nodo.n) ? nodo.child[indice + 1] : null;

        // Caso 3a: El hijo actual puede prestar una clave a su vecino izquierdo
        if (vecinoIzquierdo != null && vecinoIzquierdo.n >= t) {
            prestarDelVecino(nodo, indice - 1, hijoActual, vecinoIzquierdo);
        } // Caso 3b: El hijo actual puede prestar una clave a su vecino derecho
        else if (vecinoDerecho != null && vecinoDerecho.n >= t) {
            prestarDelVecino(nodo, indice, hijoActual, vecinoDerecho);
        } // Caso 3c: Fusionar el hijo actual con su vecino izquierdo o derecho
        else {
            if (vecinoIzquierdo != null) {
                fusionarNodos(nodo, indice - 1);
                hijoActual = vecinoIzquierdo;
            } else {
                fusionarNodos(nodo, indice);
            }
        }
    }

    private void prestarDelVecino(NodoArbolB nodo, int indice, NodoArbolB hijoActual, NodoArbolB vecinoDerecho) {
        // Mover una clave del vecino derecho al hijo actual
        hijoActual.key[hijoActual.n] = nodo.key[indice];

        // Mover una clave del vecino derecho al nodo
        nodo.key[indice] = vecinoDerecho.key[0];

        // Mover el hijo del vecino derecho al hijo actual si no es hoja
        if (!hijoActual.leaf) {
            hijoActual.child[hijoActual.n + 1] = vecinoDerecho.child[0];
        }

        // Ajustar las claves restantes en el vecino derecho
        for (int i = 1; i < vecinoDerecho.n; i++) {
            vecinoDerecho.key[i - 1] = vecinoDerecho.key[i];
        }

        // Ajustar los hijos restantes en el vecino derecho si no es hoja
        if (!vecinoDerecho.leaf) {
            for (int i = 1; i <= vecinoDerecho.n; i++) {
                vecinoDerecho.child[i - 1] = vecinoDerecho.child[i];
            }
        }

        // Actualizar el número de claves en el hijo actual y el vecino derecho
        hijoActual.n++;
        vecinoDerecho.n--;
    }

    private void fusionarNodos(NodoArbolB nodo, int indice) {
        NodoArbolB hijoIzquierdo = nodo.child[indice];
        NodoArbolB hijoDerecho = nodo.child[indice + 1];

        // Mover la clave del nodo al hijo izquierdo
        hijoIzquierdo.key[hijoIzquierdo.n] = nodo.key[indice];

        // Mover las claves del hijo derecho al hijo izquierdo
        for (int i = 0; i < hijoDerecho.n; i++) {
            hijoIzquierdo.key[hijoIzquierdo.n + 1 + i] = hijoDerecho.key[i];
        }

        // Mover los hijos del hijo derecho al hijo izquierdo si no son hojas
        if (!hijoDerecho.leaf) {
            for (int i = 0; i <= hijoDerecho.n; i++) {
                hijoIzquierdo.child[hijoIzquierdo.n + 1 + i] = hijoDerecho.child[i];
            }
        }

        // Mover las claves del nodo hacia la izquierda para llenar el espacio vacío
        for (int i = indice + 1; i < nodo.n; i++) {
            nodo.key[i - 1] = nodo.key[i];
        }

        // Mover los hijos del nodo hacia la izquierda para llenar el espacio vacío
        for (int i = indice + 2; i <= nodo.n; i++) {
            nodo.child[i - 1] = nodo.child[i];
        }

        // Actualizar el número de claves en el nodo y el hijo izquierdo
        hijoIzquierdo.n += hijoDerecho.n + 1;
        nodo.n--;
    }

    //---------------------------Final Ejercicio 1-----------------------//
    // Caso cuando la raiz se divide
    // x =          | | | | | |
    //             /
    //      |10|20|30|40|50|
    // i = 0
    // y = |10|20|30|40|50|
    private void split(NodoArbolB x, int i, NodoArbolB y) {
        //Nodo temporal que sera el hijo i + 1 de x
        NodoArbolB z = new NodoArbolB(t);
        z.leaf = y.leaf;
        z.n = (t - 1);

        //Copia las ultimas (t - 1) claves del nodo y al inicio del nodo z      // z = |40|50| | | |
        for (int j = 0; j < (t - 1); j++) {
            z.key[j] = y.key[(j + t)];
        }

        //Si no es hoja hay que reasignar los nodos hijos
        if (!y.leaf) {
            for (int k = 0; k < t; k++) {
                z.child[k] = y.child[(k + t)];
            }
        }

        //nuevo tamanio de y                                                    // x =            | | | | | |
        y.n = (t - 1);                                                          //               /   \
        //  |10|20| | | |
        //Mueve los hijos de x para darle espacio a z
        for (int j = x.n; j > i; j--) {
            x.child[(j + 1)] = x.child[j];
        }
        //Reasigna el hijo (i+1) de x                                           // x =            | | | | | |
        x.child[(i + 1)] = z;                                                   //               /   \
        //  |10|20| | | |     |40|50| | | |
        //Mueve las claves de x
        for (int j = x.n; j > i; j--) {
            x.key[(j + 1)] = x.key[j];
        }

        //Agrega la clave situada en la mediana                                 // x =            |30| | | | |
        x.key[i] = y.key[(t - 1)];                                              //               /    \
        x.n++;                                                                  //  |10|20| | | |      |40|50| | | |
    }

    private void nonFullInsert(NodoArbolB x, int key) {
        //Si es una hoja
        if (x.leaf) {
            int i = x.n; //cantidad de valores del nodo
            //busca la posicion i donde asignar el valor
            while (i >= 1 && key < x.key[i - 1]) {
                x.key[i] = x.key[i - 1];//Desplaza los valores mayores a key
                i--;
            }

            x.key[i] = key;//asigna el valor al nodo
            x.n++; //aumenta la cantidad de elementos del nodo
        } else {
            int j = 0;
            //Busca la posicion del hijo
            while (j < x.n && key > x.key[j]) {
                j++;
            }

            //Si el nodo hijo esta lleno lo separa
            if (x.child[j].n == (2 * t - 1)) {
                split(x, j, x.child[j]);

                if (key > x.key[j]) {
                    j++;
                }
            }

            nonFullInsert(x.child[j], key);
        }
    }

    public void showBTree() {
        print(root);
    }

    //Print en preorder
    private void print(NodoArbolB n) {
        n.imprimir();

        //Si no es hoja
        if (!n.leaf) {
            //recorre los nodos para saber si tiene hijos
            for (int j = 0; j <= n.n; j++) {
                if (n.child[j] != null) {
                    System.out.println();
                    print(n.child[j]);
                }
            }
        }
    }

    //Encontrar valor maximo
    public int encontrarMaximo() {
        NodoArbolB nodoActual = root;

        while (!nodoActual.leaf) {
            nodoActual = nodoActual.child[nodoActual.n];
        }

        return nodoActual.key[nodoActual.n - 1];
    }

}
