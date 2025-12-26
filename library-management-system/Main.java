package LibraryManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Book> bookList = new ArrayList<>();
    private static Scanner sc;
    public static void main(String[] args) {
        boolean proceed= true;
        sc = new Scanner(System.in);
        int choice ;
        while(proceed) {
            System.out.println("Please choose: 1.Add a Book\n" +
                    "2.View All Books\n" +
                    "3.Issue a Book\n" +
                    "4.Return a book\n" +
                    "5.Search Book by Id\n" +
                    "6.Exit");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    showAllBooks();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    System.out.println("Thank you for using the library utility.");
                    proceed = false;
                    break;
            }

        }
    }

    private static boolean addBook(){
        System.out.println("Please provide book Id: ");
        int id = sc.nextInt();
        if (findBookById(id) != null) {
            System.out.println("A book with id " + id + " already exists.");
            return false;
        }

        System.out.println("Please provide the title: ");
        String bookTitle = sc.next();

        System.out.println("Please provide author name: ");
        String auth = sc.next();

        Book book = new Book(id, bookTitle, auth, false);
        bookList.add(book);

        System.out.println("Book added successfully.");
        return true;

    }

    private static void showAllBooks() {
        if (!bookList.isEmpty()) {
            for (Book book : bookList) {
                book.display();
            }
        }else{
            System.out.println("There are no books in the library. ");
        }
    }

    private static void issueBook(){
        System.out.println("Please give the id of the book you want. ");
        int b = sc.nextInt();
        Book book = findBookById(b);
            if(book!=null){
                if (!book.isIssued()) {
                    book.setIssued(true);
                    System.out.println("Book issued successfully.");
                }
                else {
                    System.out.println("The book is already issued.");
                }
            }else{
                System.out.println("Book with id"+b+ "not found");
            }

    }
    private static void returnBook(){
        System.out.println("Please give the id of the book you want. ");
        int id = sc.nextInt();
        Book book = findBookById(id);

        if(book!=null){
                if (book.isIssued()) {
                    book.setIssued(false);
                    System.out.println("Book returned successfully.");
                }
                else {
                    System.out.println("The book is already available.");
                }
            }else{
                System.out.println("Book with id"+id+ "not found");
            }

    }

    private static void searchBook(){
        System.out.println("Please give the id of the book you want to search. ");
        int id = sc.nextInt();
        Book book = findBookById(id);

            if(book!=null){
                book.display();
            }else{
                System.out.println("A book with this id is not in the library.");
            }


    }
    private static Book findBookById(int id) {
        for (Book b : bookList) {
            if (b.getBookId() == id) {
                return b;   // 🔥 return immediately when found
            }
        }
        return null;        // 🔥 only return null if not found at all
    }

}
