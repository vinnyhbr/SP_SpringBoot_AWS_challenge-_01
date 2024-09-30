package entities;

import java.util.Date;

public class Author extends Person {

    private Date dateOfBirth;
    private String nacionality;
    private String biography;

    public Author(String name, Date dateOfBirth, String nacionality, String biography) {
        super(name);
        this.dateOfBirth = dateOfBirth;
        this.nacionality = nacionality;
        this.biography = biography;
    }



    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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
