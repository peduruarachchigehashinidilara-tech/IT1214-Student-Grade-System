package src;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.class);
        StudentManager manager = new StudentManager();

        System.out.println("=== IT1214 Student Grade Management System ===");

        // Adding Student
        System.out.print("\nEnter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();

        Student student = new Student(id, name);

        System.out.print("Enter marks for Subject 1: ");
        student.addMark(scanner.nextDouble());
        System.out.print("Enter marks for Subject 2: ");
        student.addMark(scanner.nextDouble());
        scanner.nextLine(); // Clear buffer

        manager.addStudent(student);

        // Searching Student
        System.out.print("\nEnter Student ID to search: ");
        String searchID = scanner.nextLine();
        Student foundStudent = manager.searchStudent(searchID);

        if (foundStudent != null) {
            double avg = GradeCalculator.calculateAverage(foundStudent.getMarks());
            String grade = GradeCalculator.calculateGrade(avg);
            
            System.out.println("\n--- Result ---");
            System.out.println("Name: " + foundStudent.getName());
            System.out.println("Average: " + avg);
            System.out.println("Final Grade: " + grade);
        } else {
            System.out.println("Student not found!");
        }

        scanner.close();
    }
}
        
        
