package com.softserve.academy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TriangleSortArea {
    public static void main(String[] args) {
        List<Triangle> triangles = new ArrayList<>(); // create a list
        do {
            ConsoleIO.printToConsole(InformMessage.START_PROGRAM);
            String input = ConsoleIO.enterValue();
            if (!(WorkWithAttributes.isForCommas(input))) { //checking the number of commas
                ConsoleIO.printToConsole(InformMessage.INFORM_NO_THREE_SIDES);
            } else {
                String[] arrInput = WorkWithAttributes.parseInput(input); // split string
                try {
                    triangles.add(
                            Triangle.createTriangle(
                                    arrInput[0],
                                    Double.parseDouble(arrInput[1]),
                                    Double.parseDouble(arrInput[2]),
                                    Double.parseDouble(arrInput[3])));
                } catch (NumberFormatException e) {
                    ConsoleIO.printToConsole(InformMessage.INFORM_NO_NUMBER);
                } catch (IllegalArgumentException e) {
                    ConsoleIO.printToConsole(InformMessage.INFORM_NO_TRIANGLE);
                }
            }
            ConsoleIO.printToConsole(InformMessage.CONTINUE_PROGRAM);
        } while (ConsoleIO.isContinue());
        triangles.sort(Comparator.comparing(Triangle::getArea).reversed());
        ConsoleIO.printListTriangles(triangles);
    }
}