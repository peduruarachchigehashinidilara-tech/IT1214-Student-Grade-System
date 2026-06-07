package src;

import java.util.ArrayList;

public class GradeCalculator {
    public static double calculateAverage(ArrayList<Double> marks) {
        if (marks.isEmpty()) return 0.0;
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        return sum / marks.size();
    }

    public static String calculateGrade(double average) {
        if (average >= 75) return "A";
        else if (average >= 65) return "B";
        else if (average >= 55) return "C";
        else if (average >= 45) return "S";
        else return "F";
    }
}
