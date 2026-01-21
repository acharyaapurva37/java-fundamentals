package collections.LibraryManagementSystem;

import java.util.Objects;

public class Book {
    private int bookId;
    private String bookTitle;
    private String author;
    private String bookCategory;
    private boolean isAvailable;

    public Book(int bookId, String bookTitle, String author, String bookCategory){
        this.bookId=bookId;
        this.bookTitle=bookTitle;
        this.author=author;
        this.bookCategory=bookCategory;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", bookCategory='" + bookCategory + '\'' +
                ", isAvailable=" + isAvailable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;              // same object in memory
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return this.bookId == book.bookId;       // same logical identity
    }


    @Override
    public int hashCode() {
        return Objects.hashCode(bookId);
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(String bookCategory) {
        this.bookCategory = bookCategory;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }



}
