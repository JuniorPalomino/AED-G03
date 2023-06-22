/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab11.actividad02;

/**
 *
 * @author H P
 */
public class Lab11Actividad02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
       HashC PrimerHash= new HashC(11); 
       PrimerHash.insert(34, "Elemento 1");
       PrimerHash.insert(3, "Elementon 2");
       PrimerHash.insert(7, "Elemento 3");
       PrimerHash.insert(30, "Elemento 4");
       PrimerHash.insert(11, "Elemento 5");
       PrimerHash.insert(8, "Elemento 6");
       PrimerHash.insert(7, "Elemento 7");
       PrimerHash.insert(23, "Elemento 8");
       PrimerHash.insert(41, "Elemento 9");
       PrimerHash.insert(16, "Elemento 10");
       PrimerHash.insert(34, "Elemento 11");
       
       System.out.println(PrimerHash.toString());
        HashA<String> hashTable = new HashA<>(7);

        hashTable.insert(1, "Hola");
        hashTable.insert(2, "Mundo");
        hashTable.insert(3, "OpenAI");
        hashTable.insert(4, "ChatGPT");
        hashTable.insert(5, "Lenguaje");
        hashTable.insert(6, "Modelo");
        hashTable.insert(7, "Tabla Hash");
        hashTable.insert(34, "Registro34");
        hashTable.insert(3, "Registro3");
        hashTable.insert(7, "Registro7");
        hashTable.insert(30, "Registro30");
        hashTable.insert(11, "Registro11");
        hashTable.insert(8, "Registro8");
        hashTable.insert(7, "Registro7_2");
        hashTable.insert(23, "Registro23");
        hashTable.insert(41, "Registro41");
        hashTable.insert(16, "Registro16");
        hashTable.insert(34, "Registro34_2");

        System.out.println(hashTable.toString());

        System.out.println("Valor asociado a la clave 4: " + hashTable.search(4));
        System.out.println("Valor asociado a la clave 8: " + hashTable.search(8));
        System.out.println("Valor asociado a la clave 34: " + hashTable.search(34));
    }
    
}
