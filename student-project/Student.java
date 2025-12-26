package StudentManagementSystem;

import java.util.Arrays;

public class Student {

    private int id;
    private String name;
    private int[] marks;

    public Student(int id, String name, int[] marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public int getTotalMarks() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return sum;
    }

    public double calculateAverage() {
        return getTotalMarks() / 3.0;
    }

    public void display() {
        System.out.println(
                "Id: " + id +
                        " | Name: " + name +
                        " | Marks: " + Arrays.toString(marks)
        );
    }
}
