/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab04.ejer02;

/**
 *
 * @author H P
 */
public class Lab04Ejer02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Integer[ ] ArregloEnteros={1,2,3,4};
        MostrarArray(ArregloEnteros, ArregloEnteros.length);
        
    }
    
    static <T extends Number> void MostrarArray(T n[], int indice){
        
        if(indice==0){
            
           System.out.println("No hay más datos que mostrar");
           
        }
        
        else{
            System.out.println(n[indice-1]);
            MostrarArray(n,indice-1);
        }
        
    }
}
