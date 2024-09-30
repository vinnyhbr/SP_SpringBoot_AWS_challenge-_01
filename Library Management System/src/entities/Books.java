package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Books implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Author author;

    private String title;
    private Date publicationDate;
    private String gender;
    private int quantity;

    public Books(Integer id, String title, Date publicationDate, String gender, int quantity) {
        this.author =  author;
        this.id = id;
        this.title = title;
        this.publicationDate = publicationDate;
        this.gender = gender;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", publicationDate=" + publicationDate +
                ", gender='" + gender + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
