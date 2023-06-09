/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab06.ejercicio2;

/**
 *
 * @author ADMIN
 */
public class Lab06Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Node head= new Node('A');
        head.next= new Node('B');
        head.next.next= new Node('C');
        head.next.next.next= new Node('B');
        head.next.next.next.next= new Node('A');
        
        NodeWrapper left= new NodeWrapper(head);
        
        if(isPalindrome(left,head))
        {
            System.out.println("Linked List Es palindrome");
        }
        else{
            
            System.out.println("Linked List no es palindrome");
        
        }

    }

    static class NodeWrapper {

        public Node node;

        NodeWrapper(Node node) {

            this.node = node;

        }

    }

    public static boolean isPalindrome(NodeWrapper left, Node right) {
        // TODO code application logic here

        if (right == null) {        //O(1)
            return true;            //O(1)    
        }

        if (!isPalindrome(left, right.next)) {      //O(n)
            return false;       //O(1)

        }

        Node prev_left = left.node;     //O(1)

        left.node = left.node.next;     //O(1)

        return (prev_left.data== right.data);   //O(1)
        
        

    }
    
    
    

}
