package act1;

import java.util.ArrayList;
import java.util.Iterator;

public class Bolsa< T> implements Iterable< T> {

    private ArrayList< T> lista = new ArrayList< T>();
    private int tope;

    public Bolsa(int tope) {
        super();
        this.tope = tope;
    }

    Bolsa() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void add(T objeto) {
        if (lista.size() >= tope) {
            lista.add(objeto);
        } else {
            throw new RuntimeException("no caben mas");
        }
    }

    public Iterator< T> iterator() {
        return lista.iterator();
    }
}
