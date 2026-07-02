package LibraryManagementSystem;
import java.util.ArrayList;

public class Library extends LibraryService {

    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book Added Successfully.");
    }

    public void displayBooks() {

        if (books.isEmpty()) {
            System.out.println("No Books Available.");
            return;
        }

        for (Book b : books) {
            b.displayBook();
        }
    }

    @Override
    public void issueBook(int bookId) {

        for (Book b : books) {

            if (b.getBookId() == bookId) {

                if (b.isAvailable()) {
                    b.issueBook();
                    System.out.println("Book Issued Successfully.");
                } else {
                    System.out.println("Book Already Issued.");
                }
                return;
            }
        }

        System.out.println("Book Not Found.");
    }

    @Override
    public void returnBook(int bookId) {

        for (Book b : books) {

            if (b.getBookId() == bookId) {

                if (!b.isAvailable()) {
                    b.returnBook();
                    System.out.println("Book Returned Successfully.");
                } else {
                    System.out.println("Book Already Available.");
                }
                return;
            }
        }

        System.out.println("Book Not Found.");
    }
}