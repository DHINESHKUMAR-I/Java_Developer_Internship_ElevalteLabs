import java.io.*;
import java.util.Scanner;

public class NotesApp {

    private static final String FILE_NAME = "notes.txt";

    public static void addNote() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your note: ");
        String note = sc.nextLine();

        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {

            writer.write(note + System.lineSeparator());

            System.out.println("Note saved successfully.");

        } catch (IOException e) {

            System.out.println("Error writing to file.");
        }
    }

    public static void viewNotes() {

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;

            System.out.println("\n------ Notes ------");

            while ((line = reader.readLine()) != null) {

                System.out.println(line);
            }

        } catch (FileNotFoundException e) {

            System.out.println("No notes found.");

        } catch (IOException e) {

            System.out.println("Error reading file.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int choice;

        do {

            System.out.println("\n===== Notes App =====");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addNote();
                    break;

                case 2:
                    viewNotes();
                    break;

                case 3:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 3);

        sc.close();
    }
}