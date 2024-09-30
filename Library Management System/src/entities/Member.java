package entities;

import javax.persistence.Entity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


@Entity
public class Member extends Person {

    private String address;
    private String numberPhone;
    private String email;
    private LocalDate associateDate;

    public Member(String name, String address, String numberPhone, String email) {
        super(name);
        this.address = address;
        this.numberPhone = numberPhone;
        this.email = email;
       // this.associateDate = associateDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getAssociateDate() {
        return associateDate;
    }

    public void setAssociateDate(LocalDate associateDate) {
        this.associateDate = associateDate;
    }

    @Override
    public String toString() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        return "Member{" +
                "Name='" + getName() + '\'' +
                "Address='" + address + '\'' +
                ", Number phone='" + numberPhone + '\'' +
                ", Email='" + email + '\'' +
              //  ", Associate date=" + fmt.format(associateDate) +
                '}';
    }
}
