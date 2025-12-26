package LibraryManagementSystem;

public class Book {
    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    private int bookId;
    private String title;
    private String author;

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    private boolean isIssued;

    //constructor
    public Book(int bookId , String title, String author , boolean isIssued){
        this.bookId=bookId;
        this.title=title;
        this.author=author;
        this.isIssued=isIssued;
    }
     public void display(){
         System.out.println("ID: "+bookId+" |Title: "+title+" |Author: "+author+" |IsIssued: "+isIssued);
     }



}
