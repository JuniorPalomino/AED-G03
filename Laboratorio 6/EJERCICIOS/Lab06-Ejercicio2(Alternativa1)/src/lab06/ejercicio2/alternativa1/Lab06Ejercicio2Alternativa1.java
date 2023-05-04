/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab06.ejercicio2.alternativa1;

/**
 *
 * @author ADMIN
 */
public class Lab06Ejercicio2Alternativa1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Node head = new Node('A');
        head.next = new Node('B');
        head.next.next = new Node('C');
        head.next.next.next = new Node('B');
        head.next.next.next.next = new Node('A');

        if (isPalindrome(head)) {
            System.out.println("Linked List Es palindrome.");
        } else {
            System.out.println("Linked List is No es palindrome.");
        }

    }

    public static void construct(Node head, StringBuilder s1, StringBuilder s2) {           //O(n)
        if (head == null) {                 //O(1)    

            return;

        }
        s1.append(head.data);               //O(1)
        construct(head.next, s1, s2);     //O(n)
        s2.append(head.data);               //O(1)

    }

    public static boolean isPalindrome(Node head) {                     //O(n)

        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();   //O(1)
        construct(head, s1, s2);                                            //O(n)

        return s1.toString().equals(s2.toString());             //O(n)

    }

}
