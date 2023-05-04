/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab06.actividades;

/**
 *
 * @author Alumno
 */
public class ListArray<T> implements TDAList<T> {

    T[] dato;

    public ListArray(T[] dato) {
        this.dato = dato;
    }

    public ListArray() {

    }

    @Override
    public boolean isEmptyList() {
        for (int i = 0; i < dato.length; i++) {         //O(n)
            if (dato[i] != null) {                      //O(1)
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
    public int search(T x) {
        for (int i = 0; i < dato.length; i++) {
            if (dato[i].equals(x)) {
                System.out.println("Se encontro:" + x);
                return i;
            }
        }
        System.out.println("No se encontro:" + x);
        return -1;
    }

    @Override
    public void insertFirst(T x) {
        int rango = dato.length - 1;            //O(1)
        if (isEmptyList()) {                    //O(n)
            dato[0] = x;                        //O(1)
        } else {
            for (int i = 0; i <= rango; i++) {  //O(n)
                System.out.println("indice " + i);
                if (dato[i] == null) {                      //valida si hay un espacio nulo
                    if (i == 0) {                           //verifica si el elemento en el que estamos es nulo
                        dato[0] = x;
                        break;
                    } else {                                //se realiza el cambio

                        dato[i] = dato[0];
                        dato[0] = x;
                        break;
                    }
                }
            }

            //System.out.println("Lista llena"); 
        }

    }

    @Override
    public void insertLast(T x) {
        int rango = dato.length - 1;
        int mayor = dato.length - 1;

        if (isEmptyList()) {
            dato[mayor] = x;
        } else {
            for (int i = rango; i >= 0; i--) {
                //System.out.println("indice " + i);
                if (dato[i] == null) {
                    //System.out.println("Hay un espacio en la posicion " + i);
                    if (i == mayor) {
                        dato[mayor] = x;
                        break;
                    } else {
                      //  System.out.println("cambio");
                        dato[i] = dato[rango];
                        //dato[mayor] = null;
                        dato[rango] = x;
                        break;
                    }
                }

                // System.out.println("Lista llena");   
            }

        }
    }

    @Override
    public void removeNode(T x) {

        if (isEmptyList()) {
            System.out.println("Lista Vacia, no se puede eliminar");
        } else {
            for (int i = 0; i < dato.length; i++) {
                if(dato[i]!=null){
                if (dato[i].equals(x)) {
                    dato[i] = null;
                    System.out.println("Se borro el dato");
                    break;
                }
                }

            }
        }
    }

    @Override
    public String toString() {

        String Cadena = "";
        for (int i = 0; i < dato.length; i++) {
            Cadena += dato[i] +" ";
        }
        return Cadena;
    }

}
