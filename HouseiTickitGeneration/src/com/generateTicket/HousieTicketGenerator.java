package com.generateTicket;

import java.util.Arrays;
import java.util.Collections;

public class HousieTicketGenerator {

    public static void main(String[] args) {
        int[][] housieTicket = generateHousieTicket();
        printHousieTicket(housieTicket);
    }

    // Function to generate a Housie ticket
    public static int[][] generateHousieTicket() {
        int[][] ticket = new int[3][5];

        // Fill each column with values
        for (int col = 0; col < 5; col++) {
            fillColumn(ticket, col);
        }

        return ticket;
    }

    // Function to fill a column with values
    private static void fillColumn(int[][] ticket, int col) {
        // Create a list of values for the column
        Integer[] values = new Integer[10];
        for (int i = 0; i < 10; i++) {
            values[i] = col * 10 + i + 1;
        }

        // Shuffle the list to randomize the order
        Collections.shuffle(Arrays.asList(values));

        // Fill the first two non-repeating values in the column
        for (int row = 0; row < 3; row++) {
            int count = 0;
            for (int i = 0; i < 10 && count < 2; i++) {
                if (count == 0 || !isValuePresentInColumn(ticket, col, values[i])) {
                    ticket[row][col] = values[i];
                    count++;
                }
            }
        }
    }

    // Function to check if a value is present in a column
    private static boolean isValuePresentInColumn(int[][] ticket, int col, int value) {
        for (int row = 0; row < 3; row++) {
            if (ticket[row][col] == value) {
                return true;
            }
        }
        return false;
    }

    // Function to print the Housie ticket
    public static void printHousieTicket(int[][] ticket) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 5; col++) {
                System.out.printf("%2d\t", ticket[row][col]);
            }
            System.out.println();
        }
    }
}

