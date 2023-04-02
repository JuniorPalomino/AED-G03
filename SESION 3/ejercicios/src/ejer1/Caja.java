package ejer1;

import java.util.Objects;

public class Caja<T> {
    
    private T CualquierObjeto;
    private String Color;
    public Caja(String color, T obj){
        this.CualquierObjeto=obj;
        this.Color=color;
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

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Caja<?> other = (Caja<?>) obj;
        if (!Objects.equals(this.Color, other.Color)) {
            return false;
        }
        return Objects.equals(this.CualquierObjeto, other.CualquierObjeto);
    }
    
    
}
