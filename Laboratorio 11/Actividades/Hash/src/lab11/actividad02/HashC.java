/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab11.actividad02;

import java.util.ArrayList;

/**
 *
 * @author H P
 */
public class HashC<E extends Comparable<E>> {

    protected class Element {

        int mark;
        Register<E> reg;

        public Element(int mark, Register<E> reg) {

            this.mark = mark;
            this.reg = reg;
        }

    }

    protected ArrayList<Element> table;
    protected int m;

    public HashC(int n) {
        this.m = n;
        this.table = new ArrayList<Element>(m);
        for (int i = 0; i < m; i++) {
            this.table.add(new Element(0, null));
        }
    }

    private int functionHash(int key) {

        return key % m;
    }

    private int linearProbing(int dressHash, int key) {

        int probe = 1; // Variable para el incremento de la exploración lineal

        // Realizar exploración lineal hasta encontrar una posición vacía
        while (true) {
            int hash = (dressHash + probe) % m; // Calcular la nueva dirección

            // Si la posición está vacía o marcada como eliminada, se ha encontrado una posición vacía
            if (table.get(hash).mark == 0 || table.get(hash).mark == -1) {
                return hash;
            }

            // Si la posición está ocupada por un elemento con la misma clave, se actualiza su valor
            if (table.get(hash).mark == 1 && table.get(hash).reg.getKey() == key) {
                return hash;
            }

            probe++; // Incrementar la variable de exploración lineal
        }
    }

    public void insert(int key, E reg) {

        int hash = functionHash(key); // Obtener la dirección de dispersión inicial

        // Si la posición en la tabla está vacía o marcada como eliminada
        if (table.get(hash).mark == 0 || table.get(hash).mark == -1) {
            table.set(hash, new Element(1, new Register<>(key, reg))); // Insertar el nuevo elemento
            return;
        }

        // Realizar exploración lineal para encontrar una posición vacía
        int originalHash = hash;
        hash = linearProbing(hash, key);

        // Si se encontró una posición vacía durante la exploración lineal
        if (table.get(hash).mark == 0 || table.get(hash).mark == -1) {
            table.set(hash, new Element(1, new Register<>(key, reg))); // Insertar el nuevo elemento
            return;
        }

        // Si no se encontró una posición vacía durante la exploración lineal, redimensionar la tabla y reinsertar
        rehash();
        insert(key, reg); // Llamar recursivamente al método insert para insertar el elemento en la tabla redimensionada
    }

    private void rehash() {
        int newSize = m * 2; // Nuevo tamaño para la tabla hash

        // Crear una nueva tabla con el nuevo tamaño
        ArrayList<Element> newTable = new ArrayList<>(newSize);
        for (int i = 0; i < newSize; i++) {
            newTable.add(new Element(0, null)); // Inicializar todas las posiciones con marcador 0 y valor null
        }

        // Transferir elementos de la tabla original a la nueva tabla
        for (Element element : table) {
            if (element.mark == 1) {
                int newHash = element.reg.getKey() % newSize; // Calcular la nueva dirección de dispersión para el elemento
                int probe = 1; // Variable para el incremento de la exploración lineal

                // Realizar exploración lineal en la nueva tabla para encontrar una posición vacía
                while (newTable.get(newHash).mark == 1) {
                    newHash = (newHash + probe) % newSize; // Calcular la nueva dirección de dispersión
                    probe++; // Incrementar la variable de exploración lineal
                }

                newTable.set(newHash, element); // Insertar el elemento en la nueva tabla
            }
        }

        table = newTable; // Asignar la nueva tabla como la tabla actual
        m = newSize; // Actualizar el tamaño de la tabla
    }

    public E search(int key) {

        int hash = functionHash(key); // Obtener la dirección de dispersión inicial

        // Realizar exploración lineal hasta encontrar el elemento con la clave correspondiente o una posición vacía
        int probe = 1; // Variable para el incremento de la exploración lineal

        while (true) {
            int currentHash = (hash + probe) % m; // Calcular la nueva dirección

            // Si la posición está vacía, no se encontró el elemento
            if (table.get(currentHash).mark == 0) {
                return null;
            }

            // Si la posición está ocupada por un elemento con la misma clave, se devuelve su valor
            if (table.get(currentHash).mark == 1 && table.get(currentHash).reg.getKey() == key) {
                return table.get(currentHash).reg.value;
            }

            probe++; // Incrementar la variable de exploración lineal

            // Si se ha realizado una vuelta completa en la exploración lineal sin encontrar el elemento, se termina la búsqueda
            if (probe > m) {
                break;
            }
        }

        return null; // Si no se encontró el elemento después de una exploración completa, se devuelve null
    }

    public String toString() {

        String s = "D.real\tD.Hash\tRegister\n";
        int i = 0;
        for (Element item : table) {

            s += (i++) + "-->\t";

            if (item.mark == 1) {
                s += functionHash(item.reg.key) + "\t" + item.reg + "\n";
            } else {
                s += "empty\n";
            }
        }

        return s;
    }

    public int squareMethodHash(int key, int tableSize) {
        int squaredValue = key * key;
        String squaredString = String.valueOf(squaredValue);
        int startIndex = (squaredString.length() / 2) - (tableSize / 2);
        int endIndex = startIndex + tableSize;

        // Tomar una parte del resultado cuadrado como índice hash
        String hashString = squaredString.substring(startIndex, endIndex);
        int hash = Integer.parseInt(hashString);

        // Asegurarse de que el índice hash esté dentro del rango de la tabla
        return hash % tableSize;
    }

    public int foldingSumMethodHash(int key, int tableSize) {
        int sum = 0;
        String keyString = String.valueOf(key);

        // Dividir el valor de entrada en partes más pequeñas y sumarlas
        for (int i = 0; i < keyString.length(); i += 2) {
            int startIndex = i;
            int endIndex = Math.min(i + 2, keyString.length());
            String part = keyString.substring(startIndex, endIndex);
            sum += Integer.parseInt(part);
        }

        // Tomar una parte de la suma como índice hash
        String sumString = String.valueOf(sum);
        int startIndex = (sumString.length() / 2) - (tableSize / 2);
        int endIndex = startIndex + tableSize;
        String hashString = sumString.substring(startIndex, endIndex);
        int hash = Integer.parseInt(hashString);

        // Asegurarse de que el índice hash esté dentro del rango de la tabla
        return hash % tableSize;
    }

}
