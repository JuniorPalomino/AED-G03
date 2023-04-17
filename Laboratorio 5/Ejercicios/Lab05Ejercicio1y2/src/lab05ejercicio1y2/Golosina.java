package lab05ejercicio1y2;

import java.util.Objects;

public class Golosina implements Comparable<Golosina> {

    private String nombre;
    private double peso;

    public Golosina(String nombre, double peso) {
        this.nombre = nombre;
        this.peso = peso;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return this.peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
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
        final Golosina other = (Golosina) obj;
        if (Double.doubleToLongBits(this.peso) != Double.doubleToLongBits(other.peso)) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    @Override
    public int compareTo(Golosina otraGolosina) {
        return Double.compare(this.peso, otraGolosina.getPeso());
    }

    @Override
    public String toString() {
        return "Golosina{" + "nombre=" + nombre + ", peso=" + peso + '}';
    }

}
