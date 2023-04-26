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
    public int search(T x) {
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
    public void insertFirst(T x) {
        int rango = dato.length;
        if (isEmptyList()) {
            dato[0] =  x;
        } else {
            for (int i = 0; i < dato.length-1; i++) {
                if (dato[i] == null) {
                    System.out.println("Hay un espacio");
                    if (dato[i] == dato[0]) {
                        dato[0] = x;
                    } else {
                        dato[i] = dato[0];
                        //dato[0] = null;
                        dato[0] =  x;
                    }
                }
            }
            
            System.out.println("Lista llena"); 
            
        }
        
    }

    @Override
    public void insertLast(T x) {
        int rango = dato.length-1;
        int mayor = dato.length-1;
        
        if (isEmptyList()) {
            dato[0] = x;
        } else {
            /*
            if(dato[dato.length-1]!=null)
                dato[dato.length-1]=x;
            else{
                for(int i = 0;i<dato.length;i++)
                {
                    if(dato[i]==null)
                        dato[i]=x;
                    break;
            }
            */
            
            for (int i = rango; 0 == i; i--) {
                if (dato[i] == null) {
                    System.out.println("Hay un espacio");
                    if (dato[i] == dato[rango]) {
                        dato[rango] = x;
                    } else {
                        dato[i] = dato[rango];
                        //dato[mayor] = null;
                        dato[rango] = x;
                    }
                }
                
             System.out.println("Lista llena");   
              
            }
            
        }
    }

    @Override
    public void removeNode(T x) {
        
        if (isEmptyList()) {
            System.out.println("Lista Vacia, no se puede eliminar");
        } else {
            for (int i = 0; i < dato.length; i++) {
                if (dato[i] == x) {
                    dato[i]=null;
                    System.out.println("Se borro el dato");
                   
                }
            }
        }
        
    }

    @Override
    public String toString() {
        
         String Cadena="";
         for (int i = 0; i < dato.length; i++) {
            Cadena+=dato[i];
             System.out.println(Cadena);
            }
        return Cadena;
    }
    
    
    
}
