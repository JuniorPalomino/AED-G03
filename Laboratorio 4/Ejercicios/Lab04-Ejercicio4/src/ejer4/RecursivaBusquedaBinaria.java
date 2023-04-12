package ejer4;

public class RecursivaBusquedaBinaria {

    public static int busquedaBinariaRecursiva(int[] arreglo, int valorBuscado, int izquierda, int derecha) {
        if (derecha < izquierda) {
            return -1; // El valor no se encuentra en el arreglo
        }

        int medio = (izquierda + derecha) / 2;

        if (valorBuscado == arreglo[medio]) {
            return medio; // Encontramos el valor buscado
        } else if (valorBuscado < arreglo[medio]) {
            return busquedaBinariaRecursiva(arreglo, valorBuscado, izquierda, medio - 1); // Buscamos en la mitad izquierda
        } else {
            return busquedaBinariaRecursiva(arreglo, valorBuscado, medio + 1, derecha); // Buscamos en la mitad derecha
        }
    }

    public static void main(String[] args) {
        int[] arreglo = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int valorBuscado = 14;
        int indice = busquedaBinariaRecursiva(arreglo, valorBuscado, 0, arreglo.length - 1);

        if (indice == -1) {
            System.out.println("El valor " + valorBuscado + " no se encuentra en el arreglo");
        } else {
            System.out.println("El valor " + valorBuscado + " se encuentra en la posición " + indice + " del arreglo");
        }
    }

}
