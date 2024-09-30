package entities;

import javax.persistence.Entity;
import java.util.Date;
@Entity
public class Member {
    private String name;
    private String address;
    private String numberphone;
    private String email;
    private Date associateDate;

    public Member(String name, String address, String numberphone, String email, Date associateDate) {
        this.name = name;
        this.address = address;
        this.numberphone = numberphone;
        this.email = email;
        this.associateDate = associateDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberphone() {
        return numberphone;
    }

    public void setNumberphone(String numberphone) {
        this.numberphone = numberphone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAssociateDate() {
        return associateDate;
    }

    public void setAssociateDate(Date associateDate) {
        this.associateDate = associateDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberphone='" + numberphone + '\'' +
                ", email='" + email + '\'' +
                ", associateDate=" + associateDate +
                '}';
    }
}
