package lab04actividad1;

public class FactorialNumero {

    public static void main(String[] args) {
        // TODO code application logic here
        FactorialNumero objfact = new FactorialNumero();

        System.out.println("El factorial de 4 mediante metodo recursivo es: " + objfact.factorialRecursivo(4));

        System.out.println("El factorial de 4 mediante metodo recursivo es: " + objfact.factorialCiclo(4));
    }

    //Creando el metodo factorial de manera recursiva
    public int factorialRecursivo(int n) {
        //Validando
        if (n < 0) {
            return 0;
        } else {
            //Caso cero
            if (n == 0) {
                return 1;
            } else {
                //Dominio (problema -1)
                return n * factorialRecursivo(n - 1);
            }
        }
    }

    //Creando metodo factorial mediante ciclos o iterativo
    public int factorialCiclo(int n) {
        int factor = 1;
        if (n < 0) {
            return 0;
        } else {
            while (0 != n) {
                factor = n * factor;
                n--;
            }
            return factor;
        }

    }
}
