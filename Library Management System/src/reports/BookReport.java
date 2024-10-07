package reports;

import entities.Book;
import interfaces.Report;

import java.util.List;

public class BookReport implements Report<Book> {
    private List<Book> books;

    public BookReport(List<Book> books) {
        this.books = books;
    }

    @Override
    public void generateReport(Book book) {
        System.out.println("Book: " + book.getTitle() + ", Author: " + book.getAuthor().getName() + ", ISBN: " + book.getISBN());
    }

    public void generateCompleteReport() {
        System.out.println("===== Book Report =====");
        for (Book book : books) {
            generateReport(book);
        }
    }
}
