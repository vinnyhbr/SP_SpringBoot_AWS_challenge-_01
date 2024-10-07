package entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table (name = "authors")
public class Author extends Person {

    @Column
    private LocalDate dateOfBirth;
    @Column
    private String nacionality;
    @Column
    private String biography;
    @OneToMany(mappedBy = "author")
    private Set<Book> book = new HashSet<>();

    public Author(String name,Long id, LocalDate dateOfBirth, String nacionality, String biography) {
        super(name, id);
        this.dateOfBirth = dateOfBirth;
        this.nacionality = nacionality;
        this.biography = biography;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNacionality() {
        return nacionality;
    }

    public void setNacionality(String nacionality) {
        this.nacionality = nacionality;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + getName() + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", nacionality='" + nacionality + '\'' +
                ", biography='" + biography + '\'' +
                '}';
    }


}
