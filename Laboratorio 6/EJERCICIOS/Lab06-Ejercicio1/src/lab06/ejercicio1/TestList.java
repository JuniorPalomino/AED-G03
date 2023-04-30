package lab06.ejercicio1;

import java.util.Arrays;

public class TestList {
    
    public static void main(String[] args) {
        /*
        Integer[] nums = {1, 10, 9, 8, 6};
        Character[] chars = {'C', 'Z', 'A', 'F', 'S'};
        Arrays.sort(nums);
        Arrays.sort(chars);
        OrderListLinked<Integer> enteros = new OrderListLinked<Integer>();
        OrderListLinked<Character> caracteres = new OrderListLinked<Character>();
        for (int i = 0; i < nums.length; i++) {
            enteros.insertNode(nums[i]);
        }
        enteros.removeNode(8);
        System.out.println(enteros);
        System.out.println("==================================================================================");
        for (int i = 0; i < chars.length; i++) {
            caracteres.insertNode(chars[i]);
        }
        caracteres.removeNode('F');
        System.out.println(caracteres);
         */
        //LISTAS DE PERSONAS
        Person p[] = new Person[4];
        p[0] = new Person("Luis", "Perez", 20);
        p[1] = new Person("Bill", "Gates", 60);
        p[2] = new Person("Lucas", "Garcia", 30);
        p[3] = new Person("Maria", "Gonzales", 25);
        Arrays.sort(p);
        OrderListLinked<Person> personas = new OrderListLinked<>();
        for (Person per : p) {
            personas.insertNode(per);
        }
        personas.removeNode(new Person("Bill", "Gates", 60));
        System.out.println("Encontrado en posicion: "+ personas.search(new Person("Lucas", "Garcia", 30)));
        System.out.println(personas);
        
    }
}
