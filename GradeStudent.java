import java.util.*;
/**
 * GradeStudent
 */
public class GradeStudent {

//Weight adjustment
    static ArrayList<Integer> Weight = new ArrayList<Integer>();

/**
 * Introduction
 */
    static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
    }

/**
 * Mid term
 */
    public double midTerm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nMidterm:");
        int weight;
        do {
            System.out.print("Weight (0-100)? ");
            weight = scanner.nextInt();
        } while (weight > 100 || weight < 0);
        Weight.add(weight);
        System.out.print("Score earned? ");
        int score = scanner.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int bool = scanner.nextInt();
        int shift;
        if (bool == 1) {
            System.out.print("Shift amount? ");
            shift = scanner.nextInt();
        }else{
            shift = 0;
        }
        int total = score + shift;
        if (total > 100) {
            total = 100;
        }
        double weightedScore = (total/100.0)*weight;
        System.out.println("Total points = " + total + " / 100");
        System.out.println("Weighted score = " + Math.round(weightedScore * 100.0) / 100.0 + " / " + weight);

        //Return Score
        return weightedScore;
}

/**
 * Final term
 */
    public double finalTerm() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nFinal:");

        int sum = 0;
        for (Integer integer : Weight) {
            sum += integer;
        }
        int weight;
        do {
            System.out.print("Weight (0-" + (100 - sum) + ")? ");
            weight = scanner.nextInt();
        } while (weight > (100 - sum) || weight < 0);
        Weight.add(weight);

        System.out.print("Score earned? ");
        int score = scanner.nextInt();
        System.out.print("Were scores shifted (1=yes, 2=no)? ");
        int bool = scanner.nextInt();
        int shift;
        if (bool == 1) {
            System.out.print("Shift amount? ");
            shift = scanner.nextInt();
        }else{
            shift = 0;
        }
        int total = score + shift;
        if (total > 100) {
            total = 100;
        }
        double weightedScore = (total/100.0)*weight;
        System.out.println("Total points = " + total + " / 100");
        System.out.println("Weighted score = " + Math.round(weightedScore * 100.0) / 100.0 + " / " + weight);

        //Return Score
        return weightedScore;
    }

/**
 * Homework
 */
    public double homework() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nHomework:");

        int sum = 0;
        for (Integer integer : Weight) {
            sum += integer;
        }

        int weight = 100 - sum;
        Weight.add(weight);
        System.out.println("Weight = " + weight);

        System.out.print("Number of assignments? ");
        int assignments = scanner.nextInt();
        int score[][] = new int[assignments][2];
        for (int i = 0; i < assignments; i++) {
            System.out.println("Assignment "+(i+1)+" score and max? ");
            System.out.print("Score? ");
            score[i][0] = scanner.nextInt();
            System.out.print("Max? ");
            score[i][1] = scanner.nextInt();
        }
        System.out.print("How many sections did you attend? ");
        int attendent = scanner.nextInt();

        int section = attendent * 5;
        if (section > 30) {
            section = 30;
        }

        double total = 0;
        for (int i = 0; i < assignments; i++) {
            total = total + score[i][0];
        }
        if (total > 150) {
            total = 150;
        }

        double max = 0;
        for (int i = 0; i < assignments; i++) {
            max = max + score[i][1];
        }
        if (max > 150) {
            max = 150;
        }

        double weightedScore = (total/max)*weight;

        System.out.println("Section points = " + section + " / 30");
        System.out.println("Total points = " + total + " / " + max);
        System.out.println("Weighted score = " + Math.round(weightedScore * 100.0) / 100.0 + " / " + weight);

        //Return Score
        return weightedScore;
    }

/**
 * GPA calculate
 */
    static void report(Double a,Double b,Double c) {
        double overall = a + b + c;
        double grade;
        if (overall >= 85) {
            grade = 3.0;
        }
        else if (overall >= 75) {
            grade = 2.0;
        }
        else if (overall >= 60) {
            grade = 1.0;
        }
        else{
            grade = 0.0;
        }
        System.out.println("\nOverall percentage = " + Math.round(overall * 100.0) / 100.0);
        System.out.println("Your grade will be at least: " + grade);
    }

/**
 * MainMethod
 */
    public static void main(String[] args) {
        //Introduction
        begin();

        //Get grades and calculate
        GradeStudent obj = new GradeStudent();
        double a = obj.midTerm();
        double b = obj.finalTerm();
        double c = obj.homework();

        //Report GPA
        report(a, b, c);
    }
}