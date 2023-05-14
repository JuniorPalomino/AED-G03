package actividad1;

public class StackArray<E> implements Stack<E> {

    private E[] array;
    private int tope;

    public StackArray(int n) {
        this.array = (E[]) new Object[n];
        tope = -1;
    }

    public void push(E x) {
        if(!isFull())
        {
            array[tope+1]=x;
            tope++;
        }
    }

    public E pop() throws ExceptionIsEmpty {
        if (tope == -1) {
            throw new ExceptionIsEmpty();
        }
        E aux = array[tope];
        array[tope] = null;
        tope--;
        return aux;
    }

    public E top() throws ExceptionIsEmpty {
        if (tope == -1) {
            throw new ExceptionIsEmpty();
        }
        return array[tope];
    }

    public boolean isEmpty() {
        return this.tope == -1;
    }

    public boolean isFull() {
        for (E aux : array) {
            if (aux == null) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        String pila="";
        for(E aux:array)
            pila+=aux+" ";
        return pila;
    }
}

