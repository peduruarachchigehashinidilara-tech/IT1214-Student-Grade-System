package src;

import java.util.ArrayList;

public class StudentManager {
    private ArrayList<Student> studentList = new ArrayList<>();

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public Student searchStudent(String studentID) {
        for (Student s : studentList) {
            if (s.getStudentID().equalsIgnoreCase(studentID)) {
                return s;
            }
        }
        return null;
    }
}
