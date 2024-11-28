import java.util.ArrayList;
import java.util.Scanner;

// Report card system class

public class ReportCardSystem {
    private ArrayList<Student> students;
    private Scanner scanner;

    
    public ReportCardSystem() {
        this.students = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    
    public void addNewStudent() {
        System.out.print("\nEnter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student added successfully!");
    }

    // adding marks for a student
    public void addMarks() {
        System.out.print("\nEnter Student ID: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student != null) {
            while (true) {
                System.out.print("Enter Subject Name (or type 'done' to finish): ");
                String subject = scanner.nextLine();
                if (subject.equalsIgnoreCase("done")) {
                    break;
                }
                System.out.print("Enter Marks for " + subject + ": ");
                int marks = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                student.addSubjectMarks(subject, marks);
            }
            System.out.println("Marks added successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }

    
    public void displayReportCard() {
        System.out.print("\nEnter Student ID: ");
        String id = scanner.nextLine();
        Student student = findStudentById(id);
        if (student != null) {
            student.displayReportCard();
        } else {
            System.out.println("Student not found.");
        }
    }

    // Helper method to find a student by ID
    private Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getStudentID().equals(id)) {
                return student;
            }
        }
        return null;
    }

    
    public void displayMenu() {
        while (true) {
            System.out.println("\nStudent Report Card System");
            System.out.println("1. Add New Student");
            System.out.println("2. Add Marks for a Student");
            System.out.println("3. Display Report Card");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addNewStudent();
                    break;
                case 2:
                    addMarks();
                    break;
                case 3:
                    displayReportCard();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    
    public static void main(String[] args) {
        ReportCardSystem system = new ReportCardSystem();
        system.displayMenu();
    }
}