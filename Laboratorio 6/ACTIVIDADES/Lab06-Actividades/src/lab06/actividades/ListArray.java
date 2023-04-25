/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab06.actividades;

/**
 *
 * @author Alumno
 */
public class ListArray<T> implements TDAList {

    T[] dato;

    public ListArray(T[] dato) {
        this.dato = dato;
    }

    @Override
    public boolean isEmptyList() {

        for (int i = 0; i < dato.length; i++) {

            if (dato[i] != null) {

                return false;
            }

        }

        return true;

    }

    @Override
    public int length() {

        return dato.length;

    }

    @Override
    public void destroyList() {

        for (int i = 0; i < dato.length; i++) {

            dato[i] = null;
        }

    }

    @Override
    public int search(Object x) {

        for (int i = 0; i < dato.length; i++) {

            if (dato[i] == x) {

                System.out.println("Se encontro:" + x);
                return (int) x;
            }
        }
        System.out.println("No se encontro:" + x);
        return (int) x;

    }

    @Override
    public void insertFirst(Object x) {

        int rango = dato.length;

        if (isEmptyList()) {

            dato[0] = (T) x;

        } else {

            for (int i = 0; i < dato.length; i++) {

                if (dato[i] == null) {

                    System.out.println("Hay un espacio");

                    if (dato[i] == dato[0]) {

                        dato[0] = (T) x;

                    } else {
                        dato[i] = dato[0];
                        dato[0] = null;
                        dato[0] = (T) x;
                    }
                }
            }

        }

        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insertLast(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeNode(Object x) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
