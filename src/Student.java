package src;

import java.util.ArrayList;

public class Student {
    private String studentID;
    private String name;
    private ArrayList<Double> marks;

    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.marks = new ArrayList<>();
    }

    public void addMark(double mark) {
        if (mark >= 0 && mark <= 100) {
            marks.add(mark);
        }
    }

    public String getStudentID() { return studentID; }
    public String getName() { return name; }
    public ArrayList<Double> getMarks() { return marks; }
}
