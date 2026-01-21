package collections.LibraryManagementSystem;

import java.util.Date;
import java.util.Scanner;

public class LibraryManager {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean shouldContinue=true;
        LibraryService service = new LibraryService();
        int id , memberId , transactionId , bookId;
        String title, author, category , name , continuePrgrm;
        String issueDate, returnDate;
        while(shouldContinue){
        System.out.println("Kindly choose te option you want to proceed with:\n" +
                "1.Add Book\n2.Add Member\n3.Issue Book\n4.Return book\n5.View all books\n6.View issued books");
        int choice = s.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Kindly provide the book id: ");
                id = s.nextInt();
                System.out.println("Book title: ");
                title = s.next();
                System.out.println("Author: ");
                author = s.nextLine();
                System.out.println("Book Category: ");
                category = s.nextLine();
                service.addBook(new Book(id, title, author, category));
                break;
            case 2:
                System.out.println("Kindly provide member id:");
                memberId = s.nextInt();
                System.out.println("Member name: ");
                name = s.nextLine();
                service.addMember(new Member(memberId, name));
                break;
            case 3:
                System.out.println("Please provide transaction id: ");
                transactionId = s.nextInt();
                System.out.println("Please provide the id of the book to be issued: ");
                bookId = s.nextInt();
                System.out.println("Please give the member id: ");
                memberId = s.nextInt();
                System.out.println("Please provide issue date (YYYY-MM-DD)");
                issueDate = s.next();
                while (!issueDate.matches("\\d{4}-\\d{2}-\\d{2}")){
                    System.out.println("The pattern is incorrect. Kindly re- enter");
                    issueDate = s.next();

                }

                service.issueBook(transactionId, bookId, memberId, issueDate);
                break;
            case 4:
                System.out.println("Please provide transactionId: ");
                transactionId = s.nextInt();
                System.out.println("Please provide return date (YYYY-MM-DD)");
                returnDate = s.next();
                while (!returnDate.matches("\\d{4}-\\d{2}-\\d{2}")){
                    System.out.println("The pattern is incorrect. Kindly re- enter");
                    returnDate = s.next();

                }
                service.returnBook(transactionId, returnDate);
                break;
            case 5:
                service.displayAllBooks();
                break;
            case 6:
                service.displayIssuedBooks();
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
            System.out.println("Do you wish to continue? Y or N:");
        continuePrgrm = s.next();
        if(continuePrgrm.equalsIgnoreCase("N"))
            shouldContinue=false;
        }
    }
}
