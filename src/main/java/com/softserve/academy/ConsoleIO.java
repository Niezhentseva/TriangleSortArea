package com.softserve.academy;

import java.util.List;
import java.util.Scanner;

public class ConsoleIO {

    public final static String START_PROGRAM = "Enter attributes of triangle: " +
            "<name>, <side1>, <side2>, <side3>: ";
    public final static String CONTINUE_PROGRAM = "Do you want to add another triangle? (y/yes or n/no)";
    public final static String INFORM_NO_NUMBER = "Check the input. Sides must be numbers";
    public final static String INFORM_NO_TRIANGLE = "Check the input. " +
            "These attributes cannot be sides of a triangle. " +
            "Rule: The sum of two arbitrary triangle sides " +
            "is always greater then the third side";
    public final static String INFORM_NO_THREE_SIDES = "You need to enter three sides of a triangle";

    static Scanner scanner = new Scanner(System.in);

    public static String enterValue() {
        return scanner.nextLine();
    }

    public static boolean isContinue() {
        String scan = scanner.nextLine();
        return (scan.equalsIgnoreCase("y")
                || scan.equalsIgnoreCase("yes"));
    }

    public static void printToConsole(String message) {
        System.out.println(message);
    }

    public static void closeScanner() {
        scanner.close();
    }

    public static void printListTriangles(List<Triangle> triangles) {
        System.out.println("============= Triangles list: =============");
        int i = 1;
        for (Triangle temp : triangles) {
            System.out.println(i++ + ". " + temp);
        }
    }
}
