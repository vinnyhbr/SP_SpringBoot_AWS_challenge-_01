package entities;
import entities.enums.LoanStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table (name = "loans")
public class Loan {

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book books;
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @Column
    private LocalDate loanDate;
    private LocalDate returnDate;
    @Enumerated(EnumType.STRING)
    private LoanStatus loanStatus;
    @Column
    private BigDecimal fine;

    public Loan(Book books, Member member, LocalDate loanDate, LocalDate returnDate, entities.enums.LoanStatus loanStatus, BigDecimal fine) {

        this.books = books;
        this.member = member;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.loanStatus = loanStatus;
        this.fine = fine;
    }

    public Book getBook() {

        return books;
    }

    public void setBook(Book books) {
        this.books = books;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public entities.enums.LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(entities.enums.LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }

    public BigDecimal getFine() {
        return fine;
    }

    public void setFine(BigDecimal fine) {
        this.fine = fine;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "books=" + books +
                ", member=" + member +
                ", loanDate=" + loanDate +
                ", returnDate=" + returnDate +
                ", loanStatus=" + loanStatus +
                ", fine=" + fine +
                '}';
    }
}
