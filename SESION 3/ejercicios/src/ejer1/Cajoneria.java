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

    private ArrayList<Caja> lista = new ArrayList<Caja>();
    private int tope;

    public Cajoneria(int Tope) {

        this.tope = Tope;
    }

    public void add(Caja objeto) {
        if (lista.size() <= tope) {
            lista.add(objeto);
        } else {
            throw new RuntimeException("no caben mas");
        }
    }
    
    //

}
