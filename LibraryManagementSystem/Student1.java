package LibraryManagementSystem;
public class Student1 extends Person {

    public Student1(int id, String name) {
        super(id, name);
    }

    @Override
    public void displayDetails() {
        System.out.println("\n----- Student Details -----");
        super.displayDetails();
    }
}