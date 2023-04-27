/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab06.actividades;

/**
 *
 * @author Alumno
 */
public class TestList {

    public static void main(String[] args) {
        //PROBANDO LISTARRAY
        
        Integer[] arr1=new Integer[3];
        ListArray<Integer> L1=new ListArray<Integer>(arr1);
        System.out.println(L1.length()) ;
        L1.insertFirst(2);
        L1.insertLast(8);
        //L1.destroyList();
        //L1.search(5);
        L1.removeNode(8);
        System.out.println(L1.toString());
        System.out.println("==================================================================================");
        //LISTARRAY CON OBJETOS DE TIPO PERSONA
        Person p[] = new Person[4];
        ListArray <Person> arrayPerson = new ListArray<>(p);
        arrayPerson.insertFirst(new Person("Luis", "Perez", 20));
        arrayPerson.insertFirst(new Person("Bill", "Gates", 60));
        System.out.println(arrayPerson);
        arrayPerson.insertFirst(new Person("Lucas", "Garcia", 30));
        System.out.println(arrayPerson);
        arrayPerson.insertLast(new Person("Maria", "Gonzales", 25));
        System.out.println(arrayPerson);
        arrayPerson.search(new Person("Maria", "Gonzales", 25));
        arrayPerson.removeNode(new Person("Luis", "Perez", 20));
        System.out.println(arrayPerson);
        System.out.println("Numero de nodos: "+ arrayPerson.length());
        arrayPerson.destroyList();
        System.out.println(arrayPerson);
        System.out.println("==================================================================================");
        //LISTLINKED CON OBJETOS DE TIPO PERSONA
        ListLinked <Person> personas = new ListLinked<Person>();
        personas.insertFirst(new Person("Luis", "Perez", 20));
        personas.insertFirst(new Person("Maria", "Gonzales", 25));
        personas.insertFirst(new Person("Lucas", "Garcia", 30));
        personas.insertLast(new Person("Bill", "Gates", 60));
        personas.search(new Person("Maria", "Gonzales", 25));
        personas.removeNode(new Person("Lucas", "Garcia", 30));
        System.out.println(personas);
        System.out.println("Numero de nodos: "+ personas.length());
        personas.destroyList();
        System.out.println(personas);
        
    }
}
