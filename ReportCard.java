//interface for report card
interface ReportCard {
    void addSubjectMarks(String subject, int marks);
    double calculateAverage();
    String calculateGrade();
    void displayReportCard();
}
