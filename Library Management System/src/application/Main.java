package application;

import entities.Author;
import entities.Book;
import entities.Member;
import services.LibraryServices;
import exceptions.*;
import exceptions.MemberNotFoundException;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LibraryServices libraryServices = new LibraryServices();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("===== Library Management System =====");
            System.out.println("1. Register a Loan");
            System.out.println("2. Return a Book");
            System.out.println("3. List Members with Fines");
            System.out.println("4. List All Books");
            System.out.println("5. List All Members");
            System.out.println("6. Register New Member");
            System.out.println("7. Register New Book");
            System.out.println("8. Register New Author");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1: // Register a Loan
                    try {
                        System.out.print("Enter Member Email: ");
                        String memberEmail = scanner.nextLine();
                        System.out.print("Enter Book ISBN: ");
                        String bookIsbn = scanner.nextLine();
                        // libraryServices.registerLoan(memberEmail, bookIsbn);
                    } catch (MemberNotFoundException | BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2: // Return a Book
                    try {
                        System.out.print("Enter Member Email: ");
                        String returnMemberEmail = scanner.nextLine();
                        System.out.print("Enter Book ISBN: ");
                        String returnBookIsbn = scanner.nextLine();
                        //libraryServices.returnBook(returnMemberEmail, returnBookIsbn);
                    } catch (MemberNotFoundException | BookNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3: // List Members with Fines
                    libraryServices.listMembersWithFines();
                    break;

                case 4: // List All Books
                    libraryServices.listAllBook();
                    break;

                case 5: // List All Members
                    System.out.println("a");
                    break;

                case 6: // Register New Member
                    try {
                        System.out.print("Enter Member Name: ");
                        String memberName = scanner.nextLine();
                        System.out.print("Enter Member Address: ");
                        String address = scanner.nextLine();
                        System.out.print("Enter Member Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Enter Member Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Enter Membership Start Date (yyyy-MM-dd): ");
                        String membershipStartDate = scanner.nextLine();
                        LocalDate startDate = LocalDate.parse(membershipStartDate);

                        Member member = new Member(null, memberName, address, phoneNumber, email, LocalDate.parse(membershipStartDate));
                        libraryServices.registerMember(member);
                        System.out.println("Member registered successfully!");
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 7: // Register New Book
                    try {
                        System.out.print("Enter Book Title: ");
                        String title = scanner.nextLine();

                        System.out.print("Enter Author Name: ");
                        String authorName = scanner.nextLine();
                        System.out.print("Enter Author Nationality: ");
                        String nationality = scanner.nextLine();
                        System.out.print("Enter Author Birthdate (yyyy-MM-dd): ");
                        String birthDate = scanner.nextLine();
                        System.out.print("Enter Author Biography: ");
                        String biography = scanner.nextLine();

                        Author author = new Author(authorName, null, LocalDate.parse(birthDate), nationality, biography);

                        System.out.print("Enter Publication Date (yyyy-MM-dd): ");
                        String pubDate = scanner.nextLine();
                        LocalDate publicationDate = LocalDate.parse(pubDate);

                        System.out.print("Enter ISBN: ");
                        String isbn = scanner.nextLine();

                        System.out.print("Enter Genre: ");
                        String genre = scanner.nextLine();

                        System.out.print("Enter Quantity: ");
                        int quantity = scanner.nextInt();

                        libraryServices.registerBook(title, author, publicationDate, isbn, genre, quantity);
                    } catch (ISBNAlreadyExistsException e) {
                        System.out.println("Error: " + e.getMessage());

                    }
                    break;

                case 8:

                    System.out.print("Enter Author Name: ");
                    String authorName = scanner.nextLine();
                    System.out.print("Enter Author Nationality: ");
                    String nationality = scanner.nextLine();
                    System.out.print("Enter Author Birthdate (yyyy-MM-dd): ");
                    String birthDate = scanner.nextLine();
                    System.out.print("Enter Author Biography: ");
                    String biography = scanner.nextLine();
                    Author author = new Author(authorName, null, LocalDate.parse(birthDate), nationality, biography);




            case 0: // Exit
                running = false;
                System.out.println("Exiting the system...");
                break;

            default:
                System.out.println("Invalid option, please try again.");

            }
        }

        scanner.close();
    }
}
