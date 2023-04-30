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
        head.next = new Node('F');
        head.next.next = new Node('C');
        head.next.next.next = new Node('f');
        head.next.next.next.next = new Node('A');

        if (isPalindrome(head)) {
            System.out.println("Linked List Es palindrome.");
        } else {
            System.out.println("Linked List is No es palindrome.");
        }

    }

    public static void construct(Node head, StringBuilder s1, StringBuilder s2) {
        if (head == null) {

            return;

        }
        s1.append(head.data);
        construct(head.next, s1, s2);
        s2.append(head.data);

    }

    public static boolean isPalindrome(Node head) {

        StringBuilder s1 = new StringBuilder(), s2 = new StringBuilder();
        construct(head, s1, s2);

        return s1.toString().equals(s2.toString());

    }

}
