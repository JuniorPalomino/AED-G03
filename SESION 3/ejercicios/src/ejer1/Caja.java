package ejer1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author H P
 */
public class Caja<T> {
    
    private T CualquierObjeto;
    private String Color;
    public Caja(){
        super();
    }

    public T getCualquierObjeto() {
        return CualquierObjeto;
    }

    public String getColor() {
        return Color;
    }

    public void setCualquierObjeto(T CualquierObjeto) {
        this.CualquierObjeto = CualquierObjeto;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }
    
    
}
