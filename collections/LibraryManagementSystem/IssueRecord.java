package collections.LibraryManagementSystem;

import java.util.Date;

public class IssueRecord {
    private int transactionId;
    private Book book;
    private Member member;
    private String issueDate;
    private String returnDate;
    private boolean isReturned;

    public IssueRecord(int transactionId, Book book, Member member, String issueDate){
        this.transactionId = transactionId;
        this.book = book;
        this.member = member;
        this.issueDate = issueDate;
        this.isReturned = false;
        this.returnDate = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssueRecord that = (IssueRecord) o;
        return book.equals(that.book) && member.equals(that.member) && issueDate.equals(that.issueDate);
    }

    @Override
    public int hashCode() {
        int result = book.hashCode();
        result = 31 * result + member.hashCode();
        result = 31 * result + issueDate.hashCode();
        return result;
    }
    public boolean isReturned() {
        return isReturned;
    }

    public void setReturned(boolean returned) {
        isReturned = returned;
    }

    public Book getBook() {
        return book;
    }


    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }




}
