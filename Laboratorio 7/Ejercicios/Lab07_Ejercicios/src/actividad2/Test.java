/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package actividad2;

/**
 *
 * @author H P
 */
public class Test {
     
       public static void main(String[] args) throws ExceptionIsEmpty {
        // TODO code application logic here
        /*
        Node Nuevo=new Node('G');
        
        Node First= new Node('A');
        First.next= new Node('B');
        First.next.next= new Node('C');
        First.next.next.next= new Node('D');
        First.next.next.next.next= new Node('E');
        
        Node Last=new Node(First.next.next.next.next);
        
        */
        QueueLink K = new QueueLink();
        K.enqueue('A');
        K.enqueue('B');
        K.enqueue('G');
        K.enqueue('Z');
        
        System.out.println(K.dequeue().toString());
        System.out.println(K);

               
 
        }
      
  }
        

