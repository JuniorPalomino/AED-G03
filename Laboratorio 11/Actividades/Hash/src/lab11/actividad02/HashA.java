/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab11.actividad02;

import java.util.ArrayList;
import java.util.LinkedList;

public class HashA<E extends Comparable<E>> {

    protected ArrayList<LinkedList<Register<E>>> table;
    protected int m;

    public HashA(int n) {
        this.m = n;
        this.table = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            this.table.add(new LinkedList<>());
        }
    }

    private int functionHash(int key) {
        return key % m;
    }

    public void insert(int key, E value) {
        int hash = functionHash(key);
        LinkedList<Register<E>> list = table.get(hash);
        list.add(new Register<>(key, value));
    }

    public E search(int key) {
        int hash = functionHash(key);
        LinkedList<Register<E>> list = table.get(hash);
        for (Register<E> register : list) {
            if (register.getKey() == key) {
                return register.value;
            }
        }
        return null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("HashA\n");
        for (int i = 0; i < m; i++) {
            sb.append(i).append("-->\t");
            LinkedList<Register<E>> list = table.get(i);
            if (list.isEmpty()) {
                sb.append("empty");
            } else {
                for (Register<E> register : list) {
                    sb.append(register.toString()).append(" -> ");
                }
                sb.setLength(sb.length() - 4); // Eliminar la flecha "->" adicional al final
            }
            sb.append("\n");
        }
        return sb.toString();
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
