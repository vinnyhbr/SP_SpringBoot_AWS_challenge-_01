package entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table (name = "members")
public class Member extends Person {


    @Column private String address;
    @Column private String numberPhone;
    @Column(nullable = false, unique = true)private String email;
    @Column private LocalDate associateDate;
    @Column private BigDecimal fine = BigDecimal.ZERO;
    @OneToMany(mappedBy = "member")
    @Column private Set<Loan> loan = new HashSet<>();

    public Member(Long id, String name, String address, String numberPhone, String email, LocalDate associateDate) {
            super(name, id);
            this.address = address;
            this.numberPhone = numberPhone;
            this.email = email;
            this.associateDate = associateDate;
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
                    ", Associate date=" + fmt.format(associateDate) +
                    '}';
        }

    public Set<Loan> getLoan() {
        return loan;
    }

    public void setLoan(Set<Loan> loan) {
        this.loan = loan;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }
}
