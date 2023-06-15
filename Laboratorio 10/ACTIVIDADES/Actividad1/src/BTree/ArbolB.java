package BTree;

/**
 *
 * @author vical
 */
public class ArbolB {

    NodoArbolB root;
    int t;

    //Constructor
    public ArbolB(int t) {
        this.t = t;
        root = new NodoArbolB(t);
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

    //Search
    private NodoArbolB search(NodoArbolB actual, int key) {
        int i = 0;//se empieza a buscar siempre en la primera posicion

        //Incrementa el indice mientras el valor de la clave del nodo sea menor
        while (i < actual.n && key > actual.key[i]) {
            i++;
        }

        //Si la clave es igual, entonces retornamos el nodo
        if (i < actual.n && key == actual.key[i]) {
            return actual;
        }

        //Si llegamos hasta aqui, entonces hay que buscar los hijos
        //Se revisa primero si tiene hijos
        if (actual.leaf) {
            return null;
        } else {
            //Si tiene hijos, hace una llamada recursiva
            return search(actual.child[i], key);
        }
    }

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
    
    public void eliminarClave(int key) {
    if (root == null) {
        System.out.println("El árbol está vacío.");
        return;
    }

    eliminarEnNodo(root, key);

    // Verificar si la raíz quedó vacía después de la eliminación
    if (root.n == 0) {
        if (root.leaf) {
            // Si la raíz es una hoja, simplemente la vaciamos
            root = null;
        } else {
            // Si la raíz no es una hoja, asignamos el primer hijo como nueva raíz
            root = root.child[0];
        }
    }
}

private void eliminarEnNodo(NodoArbolB nodo, int key) {
    int indice = nodo.find(key); // Buscar índice de la clave en el nodo

    if (indice != -1) {
        if (nodo.leaf) {
            // Caso 1: La clave está en un nodo hoja
            eliminarEnHoja(nodo, indice);
        } else {
            // Caso 2: La clave está en un nodo interno
            eliminarEnNodoInterno(nodo, indice);
        }
    } else {
        if (nodo.leaf) {
            // La clave no está presente en el árbol
            System.out.println("La clave " + key + " no existe en el árbol.");
            return;
        }

        // La clave podría estar en un subárbol hijo
        boolean claveEnUltimoHijo = (indice == nodo.n);

        if (nodo.child[indice].n < t) {
            // Caso 3a: El subárbol hijo no tiene suficientes claves para prestar
            ajustarHijoDeficiente(nodo, indice);
        }

        if (claveEnUltimoHijo && indice > nodo.n) {
            // La clave podría estar en el último hijo después de ajustar
            eliminarEnNodo(nodo.child[indice - 1], key);
        } else {
            eliminarEnNodo(nodo.child[indice], key);
        }
    }
}

private void eliminarEnHoja(NodoArbolB nodo, int indice) {
    for (int i = indice + 1; i < nodo.n; i++) {
        nodo.key[i - 1] = nodo.key[i];
    }
    nodo.n--;
}

private void eliminarEnNodoInterno(NodoArbolB nodo, int indice) {
    int clave = nodo.key[indice];

    if (nodo.child[indice].n >= t) {
        // Caso 2a: El hijo izquierdo del nodo tiene suficientes claves
        int predecesor = obtenerClavePredecesor(nodo, indice);
        nodo.key[indice] = predecesor;
        eliminarEnNodo(nodo.child[indice], predecesor);
    } else if (nodo.child[indice + 1].n >= t) {
        // Caso 2b: El hijo derecho del nodo tiene suficientes claves
        int sucesor = obtenerClaveSucesor(nodo, indice);
        nodo.key[indice] = sucesor;
        eliminarEnNodo(nodo.child[indice + 1], sucesor);
    } else {
        // Caso 2c: Ambos hijos tienen el número mínimo de claves
        fusionarNodos(nodo, indice);
        eliminarEnNodo(nodo.child[indice], clave);
    }
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

private void fusionarNodos(NodoArbolB nodo, int indice) {
    NodoArbolB hijoIzquierdo = nodo.child[indice];
    NodoArbolB hijoDerecho = nodo.child[indice + 1];

    // Mover la clave del nodo al hijo izquierdo
    hijoIzquierdo.key[hijoIzquierdo.n] = nodo.key[indice];

    // Copiar las claves y los hijos del hijo derecho al hijo izquierdo
    for (int i = 0; i < hijoDerecho.n; i++) {
        hijoIzquierdo.key[hijoIzquierdo.n + 1 + i] = hijoDerecho.key[i];
    }
    if (!hijoIzquierdo.leaf) {
        for (int i = 0; i <= hijoDerecho.n; i++) {
            hijoIzquierdo.child[hijoIzquierdo.n + 1 + i] = hijoDerecho.child[i];
        }
    }

    // Ajustar las claves y los hijos restantes en el nodo
    for (int i = indice + 1; i < nodo.n; i++) {
        nodo.key[i - 1] = nodo.key[i];
    }
    for (int i = indice + 2; i <= nodo.n; i++) {
        nodo.child[i - 1] = nodo.child[i];
    }

    hijoIzquierdo.n += hijoDerecho.n + 1;
    nodo.n--;

    // Liberar el hijo derecho
    hijoDerecho = null;
}

private void ajustarHijoDeficiente(NodoArbolB nodo, int indice) {
    NodoArbolB hijoActual = nodo.child[indice];
    NodoArbolB vecinoIzquierdo = (indice != 0) ? nodo.child[indice - 1] : null;
    NodoArbolB vecinoDerecho = (indice != nodo.n) ? nodo.child[indice + 1] : null;

    if (vecinoIzquierdo != null && vecinoIzquierdo.n >= t) {
        // Prestar del vecino izquierdo
        prestarDelVecino(nodo, indice - 1, hijoActual, vecinoIzquierdo);
    } else if (vecinoDerecho != null && vecinoDerecho.n >= t) {
        // Prestar del vecino derecho
        prestarDelVecino(nodo, indice, hijoActual, vecinoDerecho);
    } else if (vecinoIzquierdo != null) {
        // Fusionar con el vecino izquierdo
        fusionarNodos(nodo, indice - 1);
    } else {
        // Fusionar con el vecino derecho
        fusionarNodos(nodo, indice);
    }
}

    private void prestarDelVecino(NodoArbolB nodo, int indice, NodoArbolB hijoActual, NodoArbolB vecinoDerecho) {
    // Mover la clave correspondiente del nodo al hijo actual
    hijoActual.key[hijoActual.n] = nodo.key[indice];

    // Mover la clave correspondiente del vecino derecho al nodo
    nodo.key[indice] = vecinoDerecho.key[0];

    // Mover los hijos del vecino derecho al hijo actual, si no es un nodo hoja
    if (!hijoActual.leaf) {
        hijoActual.child[hijoActual.n + 1] = vecinoDerecho.child[0];
    }

    // Ajustar las claves del vecino derecho
    for (int i = 1; i < vecinoDerecho.n; i++) {
        vecinoDerecho.key[i - 1] = vecinoDerecho.key[i];
    }

    // Ajustar los hijos del vecino derecho, si no es un nodo hoja
    if (!vecinoDerecho.leaf) {
        for (int i = 1; i <= vecinoDerecho.n; i++) {
            vecinoDerecho.child[i - 1] = vecinoDerecho.child[i];
        }
    }

    // Actualizar la cantidad de claves en el hijo actual y el vecino derecho
    hijoActual.n++;
    vecinoDerecho.n--;
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
}
