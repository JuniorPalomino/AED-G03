package lab11ejercicio2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookSystem {
    
    public static class BookStore {
        private Map<String, Book> booksByTitle;
        private Map<String, List<Book>> booksBySpecialty;
        private Map<String, List<Book>> booksByAuthor;
        
        public BookStore() {
            booksByTitle = new HashMap<>();
            booksBySpecialty = new HashMap<>();
            booksByAuthor = new HashMap<>();
        }
        
        public void addBook(Book book) {
            booksByTitle.put(book.getTitle(), book);
            
            List<Book> booksOfSpecialty = booksBySpecialty.getOrDefault(book.getSpecialty(), new ArrayList<>());
            booksOfSpecialty.add(book);
            booksBySpecialty.put(book.getSpecialty(), booksOfSpecialty);
            
            List<Book> booksOfAuthor = booksByAuthor.getOrDefault(book.getAuthor(), new ArrayList<>());
            booksOfAuthor.add(book);
            booksByAuthor.put(book.getAuthor(), booksOfAuthor);
        }
        
        public void modifyBook(Book newBook) {
            String title = newBook.getTitle();
            
            if (booksByTitle.containsKey(title)) {
                Book existingBook = booksByTitle.get(title);
                existingBook.setAuthor(newBook.getAuthor());
                existingBook.setSales(newBook.getSales());
                existingBook.setCriticRating(newBook.getCriticRating());
                existingBook.setSpecialty(newBook.getSpecialty());
                existingBook.setComments(newBook.getComments());
            } else {
                addBook(newBook);
            }
        }
        
        public Book getBestRatedBookByAuthor(String author) {
            List<Book> booksOfAuthor = booksByAuthor.get(author);
            
            if (booksOfAuthor != null && !booksOfAuthor.isEmpty()) {
                return Collections.max(booksOfAuthor, Comparator.comparingInt(Book::getCriticRating));
            }
            
            return null;
        }
        
        public List<Book> getBooksBySpecialty(String specialty) {
            List<Book> booksOfSpecialty = booksBySpecialty.get(specialty);
            
            if (booksOfSpecialty != null) {
                Collections.sort(booksOfSpecialty, Comparator.comparingInt(Book::getSales).reversed());
                return booksOfSpecialty;
            }
            
            return new ArrayList<>();
        }
    }
    
    public static void main(String[] args) {
    BookStore bookStore = new BookStore();
    
    // Agregar libros de ejemplo
    Book libro1 = new Book("Libro 1", "Autor A", 100, 4, "Especialidad 1", "Comentarios 1");
    Book libro2 = new Book("Libro 2", "Autor B", 200, 3, "Especialidad 2", "Comentarios 2");
    Book libro3 = new Book("Libro 3", "Autor A", 300, 5, "Especialidad 1", "Comentarios 3");
    
    bookStore.addBook(libro1);
    bookStore.addBook(libro2);
    bookStore.addBook(libro3);
    
    // Modificar libro existente
    Book libroModificado = new Book("Libro 2", "Autor B", 250, 4, "Especialidad 2", "Comentarios modificados");
    bookStore.modifyBook(libroModificado);
    
    // Obtener el libro con mejor crítica de un autor
    String autor = "Autor A";
    Book libroMejorCritica = bookStore.getBestRatedBookByAuthor(autor);
    
    if (libroMejorCritica != null) {
        System.out.println("Libro con mejor crítica de " + autor + ":");
        System.out.println(libroMejorCritica);
    } else {
        System.out.println("No se encontraron libros para el autor: " + autor);
    }
    
    System.out.println();
    
    // Obtener la lista de libros de una especialidad ordenados por ventas
    String especialidad = "Especialidad 1";
    List<Book> librosPorEspecialidad = bookStore.getBooksBySpecialty(especialidad);
    
    if (!librosPorEspecialidad.isEmpty()) {
        System.out.println("Libros de la especialidad " + especialidad + " (ordenados por ventas):");
        for (Book libro : librosPorEspecialidad) {
            System.out.println(libro);
            System.out.println("--------------------");
        }
    } else {
        System.out.println("No se encontraron libros para la especialidad: " + especialidad);
    }
}
}

