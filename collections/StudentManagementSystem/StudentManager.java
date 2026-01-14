package collections.StudentManagementSystem;

import java.util.Scanner;

public class StudentManager {
    private StudentService service;
    private Scanner scanner;
    private boolean shouldContinue = true;
    int choice;


    public StudentManager(){
        service = new StudentService();
        scanner = new Scanner(System.in);
    }


    public void start(){
        while(shouldContinue){
            showMenu();
            choice = scanner.nextInt();
            handleChoice(choice);
            System.out.println("Do you wish to continue? Y or N: ");
            if(scanner.next().equalsIgnoreCase("N"))
                shouldContinue=false;
        }
    }

    private void showMenu(){
        System.out.println("What do you want to do? \n" +
                "1. Add a Student\n" +
                "2. Remove a Student\n" +
                "3. Display all students\n" +
                "4. Sort students by name\n" +
                "5.Sort students by marks\n" +
                "6.Count students by course\n" +
                "7. Find a student\n");

    }
    private void handleChoice(int choice){
        Student s ;
        switch (choice){
            case 1:
                System.out.println("Please provide an id for student: ");
                int id = scanner.nextInt();
                 s = service.findStudent(id);

                while (s != null) {
                    System.out.println("Student with id " + id + " already exists. Kindly provide another id.");
                    id = scanner.nextInt();
                    s = service.findStudent(id);   // re-check with new id
                }

                System.out.println("Please provide name: ");
                String name = scanner.next();
                System.out.println("Please provide course: ");
                String course = scanner.next();
                System.out.println("Please provide marks: ");
                int marks = scanner.nextInt();

                while (marks < 0) {
                    System.out.println("Invalid marks, cannot be negative. Kindly enter again:");
                    marks = scanner.nextInt();
                }

                service.addStudent(new Student(id, name, course , marks));
                break;
            case 2:
                System.out.println("Please provide the id to remove a student: ");
                int idToRemove= scanner.nextInt();
                service.removeStudent(idToRemove);
                break;
            case 3:
                service.displayAllStudents();
                break;
            case 4:
                service.sortStudentsByName();
                service.displayAllStudents();
                break;
            case 5:
                service.sortStudentsByMarks();
                service.displayAllStudents();
                break;
            case 6:
                System.out.println(service.countStudentsByCourse());
                break;
            case 7:
                System.out.println("Please input the student id you want to find: ");
                int idToFind = scanner.nextInt();

                 s = service.findStudent(idToFind);
                if(s != null) {
                    System.out.println(s);
                } else {
                    System.out.println("Student not found.");
                }
                break;

            default:
                System.out.println("Invalid input");
        }
    }



}
