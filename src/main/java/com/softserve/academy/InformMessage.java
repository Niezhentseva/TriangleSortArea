package com.softserve.academy;

public interface InformMessage {
    String START_PROGRAM = "Enter attributes of triangle: " +
            "<name>, <side1>, <side2>, <side3>: ";
    String CONTINUE_PROGRAM = "Do you want to add another triangle? (y/yes or n/no)";
    String INFORM_NO_NUMBER = "Check the input. Sides must be numbers";
    String INFORM_NO_TRIANGLE = "Check the input. " +
            "These attributes cannot be sides of a triangle. " +
            "Rule: The sum of two arbitrary triangle sides " +
            "is always greater then the third side";
    String INFORM_NO_THREE_SIDES = "You need to enter three sides of a triangle";
}