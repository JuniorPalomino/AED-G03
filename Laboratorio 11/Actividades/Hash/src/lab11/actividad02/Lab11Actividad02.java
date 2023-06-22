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
       
    }
    
}
