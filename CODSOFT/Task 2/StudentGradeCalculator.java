import java.util.Scanner;
public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of subjects
        System.out.print("Enter the number of subjects: ");
        int subjects = scanner.nextInt();

        double total_marks = 0;

        // Input marks for each subject
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            double marks = scanner.nextDouble();
            total_marks += marks;
        }

        // Calculate average marks
        double averageMarks = total_marks / subjects;

        // Determine grade
        char grade;
        if (averageMarks >= 90) {
            grade = 'A';
        } else if (averageMarks >= 75) {
            grade = 'B';
        } else if (averageMarks >= 50) {
            grade = 'C';
        } else {
            grade = 'F';
        }

        // Output results
        System.out.println("\nTotal Marks: " + total_marks);
        System.out.println("Average Marks: " + averageMarks +"%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

