import java.util.Scanner;
import java.util.Arrays;
import java.io.*;

public class Scores {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("What is the name of the file containing the scores?");
        String fileName = keyboard.nextLine();
        File inputFile = new File(fileName);

        Scanner fileScan = new Scanner(inputFile);

        int numStudents = fileScan.nextInt();
//        System.out.println(numStudents);
        int numAssignments = fileScan.nextInt();
   //     System.out.println(numAssignments);
        int[][] scores = new int[numStudents][numAssignments];

        while (fileScan.hasNextInt()) {
            for (int i = 0; i < numStudents; i++) {
                for (int j = 0; j < numAssignments; j++) {
                    scores[i][j] = fileScan.nextInt();
                }
            }
        }

        System.out.println("Array of scores:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(Arrays.toString(scores[i]));
        }
        fileScan.close();

        System.out.println("Average score of each assignment:");
        for (int i = 0; i < numAssignments; i++) {
            double sum = 0;
            for (int j = 0; j < numStudents; j++) {
                sum += scores[j][i];
            }
            double average = sum/numStudents;
            System.out.printf("Assignment #" + (i+1) + " Average = %.1f", average);
            System.out.println();
        }
    }
}


