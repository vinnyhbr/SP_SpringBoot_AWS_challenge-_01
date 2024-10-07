package services;
import entities.Loan;
import entities.*;
import entities.enums.LoanStatus;
import exceptions.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class LibraryServices {
    private EntityManagerFactory emf;

    LocalDate currentDate = LocalDate.now();
    LocalDate returnDate = currentDate.plusDays(5);

    public void LibraryService() {
        this.emf = Persistence.createEntityManagerFactory("Library");
    }

    public void registerBook(Book book) throws ISBNAlreadyExistsException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            // Check if ISBN is unique
            Book existingBook = em.find(Book.class, book.getISBN());
            if (existingBook == null) {
                em.persist(book);
            } else {
                throw new ISBNAlreadyExistsException("ISBN already registered: " + book.getISBN());
            }

            em.getTransaction().commit();
        } catch (ISBNAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error registering book: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void registerAuthor(Author Author) throws AuthorAlreadyExistsException{
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();


            Author existingAuthor = em.createQuery("SELECT a FROM authors a WHERE a.name = :name", Author.class)
                    .setParameter("name", Author.getName())
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            if (existingAuthor == null) {
                em.persist(Author);
            } else {
                throw new AuthorAlreadyExistsException("Author already registered: " + Author.getName());
            }

            em.getTransaction().commit();
        } catch (AuthorAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error registering Author: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void registerMember(Member member) throws EmailAlreadyExistsException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Member existingMember = em.createQuery("SELECT m FROM members m WHERE m.email = :email", Member.class)
                    .setParameter("email", member.getEmail())
                    .getResultStream()
                    .findFirst()
                    .orElse(null);

            if (existingMember == null) {
                em.persist(member);
            } else {
                throw new EmailAlreadyExistsException("Email already registered: " + member.getEmail());
            }

            em.getTransaction().commit();
        } catch (EmailAlreadyExistsException e) {
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error registering member: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void registerLoan(Book book, Member member) throws PendingFineException, BookNotFoundException, MemberNotFoundException {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            Book existingBook = em.find(Book.class, book.getISBN());
            if (existingBook == null) {
                throw new BookNotFoundException("Book not found: " + book.getISBN());
            }

            Member existingMember = em.find(Member.class, member.getEmail());
            if (existingMember == null) {
                throw new MemberNotFoundException("Member not found: " + member.getEmail());
            }

            if (existingBook.getQuantity() > 0) {

                if (existingMember.getFine().compareTo(BigDecimal.ZERO) == 0) {

                    Loan loan = new Loan(existingBook, existingMember, LocalDate.now(), null, LoanStatus.ACTIVE, BigDecimal.ZERO);
                    em.persist(loan);

                    existingBook.setQuantity(existingBook.getQuantity() - 1);
                    em.merge(existingBook);
                } else {
                    throw new PendingFineException("Member has pending fines.");
                }
            } else {
                throw new BookNotFoundException("Book not available for loan.");
            }

            em.getTransaction().commit();
        } catch (PendingFineException | BookNotFoundException | MemberNotFoundException e) {
            throw e;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error registering loan: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public void returnBook(Loan loan) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            LocalDate returnDate = LocalDate.now();
            loan.setReturnDate(returnDate);

            long daysLate = java.time.temporal.ChronoUnit.DAYS.between(loan.getLoanDate(), returnDate);
            if (daysLate > 0) {
                BigDecimal finePerDay = new BigDecimal("2.00");
                loan.setFine(finePerDay.multiply(new BigDecimal(daysLate)));
            } else {
                loan.setFine(BigDecimal.ZERO);
            }

            loan.setLoanStatus(LoanStatus.COMPLETED);
            em.merge(loan);

            Book book = loan.getBook();
            book.setQuantity(book.getQuantity() + 1);
            em.merge(book);

            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            System.out.println("Error returning book: " + e.getMessage());
        } finally {
            em.close();
        }
    }

    public List<Book> listBook() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM books", Book.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error listing Book: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    public List<Author> listAuthors() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM authors", Author.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error listing Authors: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }
    public void listMembersWithFines() {
        EntityManager em = emf.createEntityManager();
        List<Member> members = em.createQuery("SELECT m FROM members m WHERE m.fine > 0", Member.class).getResultList();
        for (Member member : members) {
            System.out.println("Member: " + member.getName() + ", Fine: " + member.getFine());
        }
    }

    public void listAllMembers() {
        EntityManager em = emf.createEntityManager();
        List<Member> members = em.createQuery("SELECT m FROM members m", Member.class).getResultList();
        for (Member member : members) {
            System.out.println("Member: " + member.getName() + ", Email: " + member.getEmail());
        }
    }
    public void listAllBook() {
        EntityManager em = emf.createEntityManager();
        List<Book> listbook = em.createQuery("SELECT b FROM books b", Book.class).getResultList();
        for (Book book : listbook) {
            System.out.println("Title: " + book.getTitle() + ", ISBN: " + book.getISBN() + ", Quantity: " + book.getQuantity());
        }
    }

    public List<Loan> listLoans() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("FROM loans", Loan.class).getResultList();
        } catch (Exception e) {
            System.out.println("Error listing loans: " + e.getMessage());
            return null;
        } finally {
            em.close();
        }
    }

    public void close() {
        if (emf != null) {
            emf.close();
        }
    }

    public void registerBook(String title, Author author, LocalDate publicationDate, String isbn, String genre, int quantity) {

    }


}
