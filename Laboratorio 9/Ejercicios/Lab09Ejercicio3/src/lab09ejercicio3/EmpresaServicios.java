package lab09ejercicio3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EmpresaServicios {

    public static void main(String[] args) {
        AVLTree<String> arbolComercial = new AVLTree<>();
        AVLTree<String> arbolProduccion = new AVLTree<>();
        AVLTree<String> arbolComunicaciones = new AVLTree<>();

        try ( BufferedReader br = new BufferedReader(new FileReader("EMPRESA.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(", ");
                String numeroIdt = datos[0].trim();
                String departamentoOrigen = datos[1].trim();
                String departamentoDestino = datos[2].trim();

                try {
                    // Insertar en el árbol correspondiente antes del intercambio
                    switch (departamentoOrigen) {
                        case "1":
                            arbolComercial.insert(numeroIdt);
                            break;
                        case "2":
                            arbolProduccion.insert(numeroIdt);
                            break;
                        case "3":
                            arbolComunicaciones.insert(numeroIdt);
                            break;
                    }
                } catch (ItemDuplicated e) {
                    System.out.println("Error en la manipulación del árbol: Elemento duplicado en el árbol.");
                }

                try {
                    // Eliminar del árbol correspondiente antes del intercambio
                    switch (departamentoOrigen) {
                        case "1":
                            arbolComercial.remove(numeroIdt);
                            break;
                        case "2":
                            arbolProduccion.remove(numeroIdt);
                            break;
                        case "3":
                            arbolComunicaciones.remove(numeroIdt);
                            break;
                    }
                } catch (ItemNotFound e) {
                    System.out.println("Error en la manipulación del árbol: Elemento no encontrado en el árbol.");
                }

                try {
                    // Insertar en el árbol correspondiente después del intercambio
                    switch (departamentoDestino) {
                        case "1":
                            arbolComercial.insert(numeroIdt);
                            break;
                        case "2":
                            arbolProduccion.insert(numeroIdt);
                            break;
                        case "3":
                            arbolComunicaciones.insert(numeroIdt);
                            break;
                    }
                } catch (ItemDuplicated e) {
                    System.out.println("Error en la manipulación del árbol: Elemento duplicado en el árbol.");
                }
            }

            System.out.println("Árbol AVL para el departamento Comercial después del intercambio:");
            arbolComercial.printTree();
            System.out.println();

            System.out.println("Árbol AVL para el departamento Producción después del intercambio:");
            arbolProduccion.printTree();
            System.out.println();

            System.out.println("Árbol AVL para el departamento Comunicaciones después del intercambio:");
            arbolComunicaciones.printTree();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
