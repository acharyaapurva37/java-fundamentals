// Console-based Student Result Management System
// Built to practice core Java fundamentals
package StudentManagementSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Student> studentsList = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean proceed = true;

        while (proceed) {

            System.out.println(
                    "\nPlease choose one of the following:\n" +
                            "1. Add new Student\n" +
                            "2. View all students\n" +
                            "3. Calculate average marks for a student\n" +
                            "4. Find the Topper"
            );

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    viewAllStudents();
                    break;

                case 3:
                    calculateAverage(sc);
                    break;

                case 4:
                    findTopper();
                    break;

                default:
                    System.out.println("Invalid choice");
            }

            System.out.println("Do you wish to continue? Y or N");
            String proc = sc.next();

            if (proc.equalsIgnoreCase("N")) {
                proceed = false;
            }
        }
    }

    // -------- helper methods --------

    private static void addStudent(Scanner sc) {
        int[] marks = new int[3];

        System.out.print("Enter id: ");
        int id = sc.nextInt();

        System.out.print("Enter name: ");
        String name = sc.next();

        System.out.print("Maths: ");
        marks[0] = sc.nextInt();

        System.out.print("Science: ");
        marks[1] = sc.nextInt();

        System.out.print("English: ");
        marks[2] = sc.nextInt();

        studentsList.add(new Student(id, name, marks));
        System.out.println("Student added successfully");
    }

    private static void viewAllStudents() {
        if (studentsList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : studentsList) {
            s.display();
        }
    }

    private static void calculateAverage(Scanner sc) {
        System.out.print("Enter student id: ");
        int searchId = sc.nextInt();

        for (Student s : studentsList) {
            if (s.getId() == searchId) {
                System.out.println("Average marks: " + s.calculateAverage());
                return;
            }
        }
        System.out.println("Student not found.");
    }

    private static void findTopper() {
        if (studentsList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        Student topper = studentsList.get(0);

        for (Student s : studentsList) {
            if (s.getTotalMarks() > topper.getTotalMarks()) {
                topper = s;
            }
        }

        System.out.println(
                "Topper is ID: " + topper.getId() +
                        " with total marks: " + topper.getTotalMarks()
        );
    }
}
