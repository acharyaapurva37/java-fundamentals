package collections.StudentManagementSystem;

import java.util.*;

public class StudentService {

    private List<Student> studentList;
    private Map<Integer, Student> studentMap;

    public StudentService() {
        studentList = new ArrayList<>();
        studentMap = new HashMap<>();
    }

    public void addStudent(Student s){
        if(studentMap.containsKey(s.getStudentId())){
            System.out.println("Student already exists. ");
        }else{
            studentList.add(s);
            studentMap.put(s.getStudentId(),s);
            System.out.println("Student added successfully.");
        }
    }

    public void removeStudent(int id){
        Student s ;
        if(studentMap.containsKey(id)){
            s = studentMap.get(id);
            studentMap.remove(id);
            studentList.remove(s);
            System.out.println("Student removed successfully");

        }else{
            System.out.println("Student with id "+id+" not found.");
        }
    }

    public Student findStudent(int id){
        Student s;
        if(studentMap.containsKey(id)){
            return studentMap.get(id);
        }
        return null;
    }


    public void displayAllStudents()
    {
        if(!studentList.isEmpty()) {
            for (Student s : studentList) {
                System.out.println(s.toString());
            }
        }else{
            System.out.println("No students to print.");

        }
    }
    public void sortStudentsByName() {
        studentList.sort((s1, s2) ->
                s1.getStudentName().compareTo(s2.getStudentName()));
    }

    public Map<String, Integer> countStudentsByCourse() {
        Map<String, Integer> courseCount = new HashMap<>();

        for (Student s : studentList) {
            String course = s.getCourse();
            int count;
            if (courseCount.containsKey(course)) {
                count = courseCount.get(course);
                courseCount.put(course,count+1);
            } else {
                courseCount.put(course,1);
            }
        }

        return courseCount;
    }


    public void sortStudentsByMarks(){
        studentList.sort((s1,s2)->
                Integer.valueOf(s2.getMarks()).compareTo(Integer.valueOf(s1.getMarks())));
    }
}
