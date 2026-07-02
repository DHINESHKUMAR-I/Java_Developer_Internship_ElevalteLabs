package LibraryManagementSystem;
public class Book {

    private int bookId;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void issueBook() {
        available = false;
    }

    public void returnBook() {
        available = true;
    }

    public void displayBook() {

        System.out.println("----------------------------");
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Status  : " + (available ? "Available" : "Issued"));
    }
}