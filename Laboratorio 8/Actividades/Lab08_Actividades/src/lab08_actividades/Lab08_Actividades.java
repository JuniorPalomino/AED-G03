/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab08_actividades;

/**
 *
 * @author H P
 */
public class Lab08_Actividades {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ItemDuplicated {
        // TODO code application logic here
        
        BSTree PrimerArbol= new BSTree();
        
        PrimerArbol.insert(7);
        PrimerArbol.insert(5);
        PrimerArbol.insert(4);
        PrimerArbol.insert(6);
        PrimerArbol.insert(10);
        PrimerArbol.insert(8);
        PrimerArbol.remove(7);
        
        System.out.println(PrimerArbol.toString());
        System.out.println(PrimerArbol.inOrden());
        
    }
    
}
