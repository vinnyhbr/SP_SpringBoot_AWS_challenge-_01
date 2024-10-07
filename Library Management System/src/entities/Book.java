package entities;

import java.time.LocalDate;
import javax.persistence.*;
import entities.enums.BooksGenre;
@Entity
@Table(name = "books")
public class Book  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private int ISBN;
    @Column (nullable = false)
    private String title;
    @Column (nullable = false)
    private LocalDate publicationDate;
    @Column (nullable = false)
    private BooksGenre genre;
    @Column (nullable = false)
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(Long id,int ISBN, Author author, String title, LocalDate publicationDate, BooksGenre genre, int quantity) {
        this.id = id;
        this.ISBN = ISBN;
       this.author = author;
        this.title = title;
        this.publicationDate = publicationDate;
        this.genre = genre;
        this.quantity = quantity;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getISBN() {
        return ISBN;
    }
    

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public BooksGenre getGenre() {
        return genre;
    }

    public void setGenre(BooksGenre genre) {
        this.genre = genre;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", genre='" + genre + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
