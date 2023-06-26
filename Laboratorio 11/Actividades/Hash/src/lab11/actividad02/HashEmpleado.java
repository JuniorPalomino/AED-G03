/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab11.actividad02;
//EJERCICIO 3//
/*
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


public class HashEmpleado {
  
    private static final double LOAD_FACTOR = 0.4;

    public static void main(String[] args) {
        String archivoEmpleados = "EMPLEADO.TXT";
        int numElementos = obtenerNumElementos(archivoEmpleados);
        int m = calcularTamañoTabla(numElementos);
        HashEmpleado hashEmpleado = new HashEmpleado(m);
        hashEmpleado.dispersarEmpleados(archivoEmpleados);
        hashEmpleado.mostrarTabla();
    }

    private int m;
    private ArrayList<LinkedList<Empleado>> tabla;

    public HashEmpleado(int m) {
        this.m = m;
        this.tabla = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            tabla.add(new LinkedList<>());
        }
    }

    private static int obtenerNumElementos(String archivoEmpleados) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEmpleados))) {
            String primeraLinea = br.readLine();
            return Integer.parseInt(primeraLinea);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static int calcularTamañoTabla(int numElementos) {
        int m = (int) (numElementos / LOAD_FACTOR);
        while (!esPrimo(m)) {
            m++;
        }
        return m;
    }

    private static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int funcionHash(int codigo) {
        return codigo % m;
    }

    private int buscarCuadratica(int hashInicial, int codigo) {
        int pos = hashInicial;
        int i = 1;
        while (tabla.get(pos).size() != 0 && tabla.get(pos).getFirst().getCodigo() != codigo) {
            pos = (hashInicial + (int) Math.pow(i, 2)) % m;
            i++;
        }
        return pos;
    }

    public void dispersarEmpleados(String archivoEmpleados) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEmpleados))) {
            br.readLine(); // Saltar la primera línea (cantidad de elementos)
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int codigo = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String direccion = partes[2];
                int hash = funcionHash(codigo);
                int pos = buscarCuadratica(hash, codigo);
                tabla.get(pos).add(new Empleado(codigo, nombre, direccion));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarTabla() {
        System.out.println("Tabla de dispersión de empleados");
        for (int i = 0; i < m; i++) {
            LinkedList<Empleado> lista = tabla.get(i);
            System.out.print(i + "\t--> ");
            if (lista.isEmpty()) {
                System.out.println("Vacía");
            } else {
                for (Empleado empleado : lista) {
                    System.out.print(empleado.getCodigo() + "(" + funcionHash(empleado.getCodigo()) + ") ");
                }
                System.out.println("\tLongitud de búsqueda: " + lista.size());
            }
        }
    }

    private static class Empleado {
        private int codigo;
        private String nombre;
        private String direccion;

        public Empleado(int codigo, String nombre, String direccion) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.direccion = direccion;
        }

        public int getCodigo() {
            return codigo;
        }
    }
}


//EJERCICIO 4//
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class HashEmpleado {
    public static void main(String[] args) {
        String archivoEmpleados = "EMPLEADO.TXT";
        int numElementos = obtenerNumElementos(archivoEmpleados);
        HashEmpleado hashEmpleado = new HashEmpleado(numElementos);
        hashEmpleado.dispersarEmpleados(archivoEmpleados);
        hashEmpleado.mostrarTabla();
    }

    private int numElementos;
    private LinkedList<Empleado>[] tabla;

    public HashEmpleado(int numElementos) {
        this.numElementos = numElementos;
        this.tabla = new LinkedList[numElementos];
        for (int i = 0; i < numElementos; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    private static int obtenerNumElementos(String archivoEmpleados) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEmpleados))) {
            return Integer.parseInt(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private int funcionHash(int codigo) {
        return codigo % numElementos;
    }

    public void dispersarEmpleados(String archivoEmpleados) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivoEmpleados))) {
            br.readLine(); // Saltar la primera línea (cantidad de elementos)
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int codigo = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String direccion = partes[2];
                int hash = funcionHash(codigo);
                tabla[hash].add(new Empleado(codigo, nombre, direccion));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mostrarTabla() {
        System.out.println("Tabla de dispersión de empleados");
        for (int i = 0; i < numElementos; i++) {
            LinkedList<Empleado> lista = tabla[i];
            System.out.print(i + "\t--> ");
            if (lista.isEmpty()) {
                System.out.println("Vacía");
            } else {
                for (Empleado empleado : lista) {
                    System.out.print(empleado.getCodigo() + " ");
                }
                System.out.println();
            }
        }
    }

    private static class Empleado {
        private int codigo;
        private String nombre;
        private String direccion;

        public Empleado(int codigo, String nombre, String direccion) {
            this.codigo = codigo;
            this.nombre = nombre;
            this.direccion = direccion;
        }

        public int getCodigo() {
            return codigo;
        }
    }
}





