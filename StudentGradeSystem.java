import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int rollNo;
    ArrayList<Integer> marks = new ArrayList<>();

    Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    void addMarks(int mark) {
        marks.add(mark);
    }

    int getTotal() {
        int total = 0;
        for (int m : marks) total += m;
        return total;
    }

    double getAverage() {
        return marks.size() > 0 ? (double) getTotal() / marks.size() : 0.0;
    }

    String getGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A+";
        else if (avg >= 75) return "A";
        else if (avg >= 60) return "B";
        else if (avg >= 40) return "C";
        else return "F";
    }

    void displayReport() {
        System.out.println("\nStudent Report");
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
        System.out.println("Total Marks: " + getTotal());
        System.out.println("Average: " + getAverage());
        System.out.println("Grade: " + getGrade());
    }
}

public class StudentGradeSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = sc.nextLine();
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();

        Student s = new Student(name, roll);
        System.out.print("Enter number of subjects: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            int mark = sc.nextInt();
            s.addMarks(mark);
        }

        s.displayReport();
        sc.close();
    }
}
