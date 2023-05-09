
package lab07actividades;

import actividad1.ExceptionIsEmpty;
import actividad1.StackArray;

public class Test {
    public static void main(String[] args) throws ExceptionIsEmpty {
        StackArray pilas= new StackArray(4);
        System.out.println(pilas.pop());
        pilas.push(4);
        pilas.push(1);
        pilas.push(7);
        pilas.push(9);
        System.out.println("Tope de la pila: "+pilas.top());
        System.out.println("La pila esta llena?: "+pilas.isFull());
        System.out.println(pilas);
    }
}

