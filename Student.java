
import java.util.ArrayList;
//Student Class implementing Report card
class Student implements ReportCard {
    private String studentID;
    private String name;
    private ArrayList<String> subjects;
    private ArrayList<Integer> marks;

    
    public Student(String studentID, String name) {
        this.studentID = studentID;
        this.name = name;
        this.subjects = new ArrayList<>();
        this.marks = new ArrayList<>();
    }

    // Getter for student id

    public String getStudentID() {
        return studentID;
    }

    // adding or updating marks for a subject
    
    public void addSubjectMarks(String subject, int marks) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).equalsIgnoreCase(subject)) {
                this.marks.set(i, marks); 
                return;
            }
        }
        subjects.add(subject);
        this.marks.add(marks);
    }

    // calculating the average marks
    
    public double calculateAverage() {
        if (marks.isEmpty()) {
            return 0.0;
        }
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total / (double) marks.size();
    }

    // calculating  the grade
    public String calculateGrade() {
        double average = calculateAverage();
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else if (average >= 50) {
            return "E";
        } else {
            return "F";
        }
    }

    // displaying the report card
    
    public void displayReportCard() {
        System.out.println("\nReport Card for " + name + " (ID: " + studentID + "):");
        if (subjects.isEmpty()) {
            System.out.println("No subjects added yet.");
        } else {
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println("  " + subjects.get(i) + ": " + marks.get(i));
            }
        }
        System.out.printf("Average Marks: %.2f\n", calculateAverage());
        System.out.println("Grade: " + calculateGrade());
    }
}
