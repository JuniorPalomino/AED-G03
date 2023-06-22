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
}

