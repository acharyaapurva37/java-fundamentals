package collections.LibraryManagementSystem;

import java.util.*;

public class LibraryService {
    Map<Integer, Book> bookMap;     // key = bookId
    Map<Integer, Member> memberMap;  // key = memberId
    Map<Integer, IssueRecord> issueMap;  // key = transactionId
    Set<IssueRecord> issueSet;      // uses equals & hashCode

    public LibraryService(){
        bookMap = new HashMap<>();
        memberMap = new HashMap<>();
        issueMap = new HashMap<>();
        issueSet = new HashSet<>();
    }

    private boolean doesBookExist(int bId){
        return bookMap.containsKey(bId);
    }
    private boolean doesMemberExist(int mId){
        return memberMap.containsKey(mId);
    }

    public void addBook(Book book){
        if(doesBookExist(book.getBookId()))
            System.out.println("Book already exists. ");
        else {
            bookMap.put(book.getBookId(), book);
            System.out.println("Book added successfully");
        }
    }

    public void addMember(Member m){
        if(doesMemberExist(m.getMemberId()))
            System.out.println("Member already exists");
        else {
            memberMap.put(m.getMemberId(), m);
            System.out.println("Book added successfully");
        }
    }
    public void issueBook(int transactionId, int bookId, int memberId, String issueDate){
        Book book;
        IssueRecord issueRecord;

        if(doesMemberExist(memberId)){
            if(doesBookExist(bookId)){
                book = bookMap.get(bookId);
                if(book.isAvailable()){
                    issueRecord = new IssueRecord(transactionId, book, memberMap.get(memberId), issueDate);
                    if(issueSet.contains(issueRecord) || issueMap.containsKey(transactionId)){
                        System.out.println("The record already exists.");
                    } else {
                        issueMap.put(transactionId, issueRecord);
                        issueSet.add(issueRecord);
                        book.setAvailable(false);
                    }
                } else {
                    System.out.println("Apologies, the book is already issued.");
                }
            } else {
                System.out.println("Book does not exist, book cannot be issued.");
            }
        } else {
            System.out.println("Member does not exist, book cannot be issued.");
        }
    }

    public void returnBook(int transactionId, String returnDate){
        IssueRecord issueRecord;
        if(issueMap.containsKey(transactionId)){
            issueRecord = issueMap.get(transactionId);
            if(issueRecord.isReturned())
                System.out.println("Book is already returned");
            else {
                issueRecord.setReturned(true);
                issueRecord.setReturnDate(returnDate);
                issueRecord.getBook().setAvailable(true);
            }
        }else{
            System.out.println("Incorrect transaction id. ");
        }
    }

    public void displayAllBooks(){
        for(Book book: bookMap.values()){
            System.out.println(book.toString());
        }
    }
    public void displayIssuedBooks(){
        for(IssueRecord record: issueMap.values()){
            if(!record.isReturned())
                     System.out.println(record.getBook().toString());
        }
    }


}
