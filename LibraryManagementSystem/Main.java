package LibraryManagementSystem;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        Student1 student = new Student1(1, "Dhineshkumar");

        User user = new User(101, "Dhineshkumar");

        student.displayDetails();
        user.displayUser();

        int choice;

        do {

            System.out.println("\n===== Library Management System =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter Choice : ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Book ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Book Title : ");
                    String title = sc.nextLine();

                    System.out.print("Author : ");
                    String author = sc.nextLine();

                    library.addBook(new Book(id, title, author));

                    break;

                case 2:

                    library.displayBooks();

                    break;

                case 3:

                    System.out.print("Enter Book ID : ");
                    int issueId = sc.nextInt();

                    library.issueBook(issueId);

                    break;

                case 4:

                    System.out.print("Enter Book ID : ");
                    int returnId = sc.nextInt();

                    library.returnBook(returnId);

                    break;

                case 5:

                    System.out.println("Thank You!");

                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 5);

        sc.close();
    }
}