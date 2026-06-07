import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.util.new);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n=========================================");
            System.out.println("  STUDENT GRADE MANAGEMENT SYSTEM (IT1214) ");
            System.out.println("=========================================");
            System.out.println("1. Add a New Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate and Display Average Mark");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            
            // Input Validation for choice
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number (1-5): ");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    displayAllStudents();
                    break;
                case 3:
                    searchStudentById();
                    break;
                case 4:
                    calculateAverage();
                    break;
                case 5:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }

    // 1. Add a student
    private static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine().trim();
        
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter Marks: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Invalid marks. Please enter a valid number: ");
            scanner.next();
        }
        double marks = scanner.nextDouble();
        scanner.nextLine(); 

        // Creating Student Object and adding to List
        Student newStudent = new Student(id, name, marks);
        studentList.add(newStudent);
        System.out.println("Student record added successfully!");
    }

    // 2. Display all students
    private static void displayAllStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n-------------------------------------------------");
        System.out.printf("| %-12s | %-20s | %-6s |\n", "Student ID", "Student Name", "Marks");
        System.out.println("-------------------------------------------------");
        for (Student student : studentList) {
            student.displayStudentDetails();
        }
        System.out.println("-------------------------------------------------");
		
    }

    // 3. Search student by ID
    private static void searchStudentById() {
        if (studentList.isEmpty()) {
            System.out.println("No student records available to search.");
            return;
        }

        System.out.print("Enter Student ID to search: ");
        String searchId = scanner.nextLine().trim();
        boolean found = false;

        for (Student student : studentList) {
            if (student.getStudentId().equalsIgnoreCase(searchId)) {
                System.out.println("\nStudent Found:");
                System.out.println("-------------------------------------------------");
                System.out.printf("| %-12s | %-20s | %-6s |\n", "Student ID", "Student Name", "Marks");
                System.out.println("-------------------------------------------------");
                student.displayStudentDetails();
                System.out.println("-------------------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with ID '" + searchId + "' not found.");
        }
    }

    //4. Calculate and display average mark
    private static void calculateAverage() {
        if (studentList.isEmpty()) {
            System.out.println("No records found to calculate average.");
            return;
        }

        double totalMarks = 0;
        for (Student student : studentList) {
            totalMarks += student.getMarks();
        }

        double average = totalMarks / studentList.size();
        System.out.println("\nTotal Students: " + studentList.size());
        System.out.printf("Average Marks of All Students: %.2f\n", average);
    }
}