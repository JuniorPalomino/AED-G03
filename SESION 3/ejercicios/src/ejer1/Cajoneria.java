/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejer1;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author H P
 */
public class Cajoneria<Y extends Bolsa> {

    private ArrayList<Caja> lista;
    private int tope;

    public Cajoneria(int Tope) {
        lista = new ArrayList<Caja>();
        this.tope = Tope;
    }

    public void add(Caja objeto) {
        if (lista.size() <= tope) {
            lista.add(objeto);
        } else {
            throw new RuntimeException("no caben mas");
        }
    }
    
    public String search(Caja x){
        for(int i = 0; i < lista.size(); i++){
            if(x==lista.get(i)){  
                return i + lista.get(i).getColor();
            }
        }
        return null;
    }
    
    public Caja delete(Caja x){
        for(int i = 0; i < lista.size(); i++){
            if(x==lista.get(i)){ 
                lista.remove(lista.get(i));
                return x;
            }
        }
        return null;
        
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-15s %-15s %-15s\n", "Posicion ", "|| Color Caja ","|| Objeto "));
        sb.append("---------------------------------------------------------------------\n");
        int contador = 1;
        for (Caja elemento : lista) {
            sb.append(String.format("%-15s %-15s %-15s\n", contador++, elemento.getColor(), elemento.getClass()));
        }
        return sb.toString();
    }

}
