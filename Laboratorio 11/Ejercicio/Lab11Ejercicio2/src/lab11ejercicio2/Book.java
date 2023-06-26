
package lab11ejercicio2;

public class Book {
    private String title;
    private String author;
    private int sales;
    private int criticRating;
    private String specialty;
    private String comments;

    public Book(String title, String author, int sales, int criticRating, String specialty, String comments) {
        this.title = title;
        this.author = author;
        this.sales = sales;
        this.criticRating = criticRating;
        this.specialty = specialty;
        this.comments = comments;
    }

    // Getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getCriticRating() {
        return criticRating;
    }

    public void setCriticRating(int criticRating) {
        this.criticRating = criticRating;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    // toString method

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", sales=" + sales +
                ", criticRating=" + criticRating +
                ", specialty='" + specialty + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
