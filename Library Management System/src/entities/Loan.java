package entities;
import entities.enums.loanStatus;

import java.math.BigDecimal;
import java.util.Date;

public class Loan {
    private Books books;
    private Member member;
    private Date loanDate;
    private Date returnDate;
    private loanStatus loanStatus;
    private BigDecimal fine;

    public Loan(Books books, Member member, Date loanDate, Date returnDate, entities.enums.loanStatus loanStatus, BigDecimal fine) {
        this.books = books;
        this.member = member;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
        this.loanStatus = loanStatus;
        this.fine = fine;
    }

    public Books getBooks() {

        return books;
    }

    public void setBooks(Books books) {
        this.books = books;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(Date loanDate) {
        this.loanDate = loanDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public entities.enums.loanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(entities.enums.loanStatus loanStatus) {
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
