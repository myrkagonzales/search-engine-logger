package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


import java.time.format.DateTimeFormatter;

public class SearchEngineLogger {

    //  format timestamps consistently across all log entries
    // pattern: year-month-day hour:minute:second
    private static final DateTimeFormatter LOG_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {

        // create a scanner to read user input
        Scanner aScanner = new Scanner(System.in);

        // log user launch the application
        logAction("Launch");

        // display user header
        System.out.println("--- Search Engine Logger ---");

        // loop indefinitely to process multiple searches until user chooses to exit app
        while (true) {
            System.out.print("Enter a search term (X or x to exit): ");
            String input = aScanner.nextLine().trim();

            // ignore case sensitivity
            if (input.equalsIgnoreCase("x")) {
                logAction("exit");
                System.out.println("Goodbye!");
                break;

            }
            // ensure input is not blank before logging a search term
            if (!input.isEmpty()) {
                logAction("Search: " + input);
                System.out.println("Logged search for: " + input);
            }
        }
        // close scanner
        aScanner.close();

    }
        // appends a single user action with a formatted time stamp to logs.txt
        public static void logAction (String action){
            // grab current date/time from clock and convert to string format
            String timeStamp = LocalDateTime.now().format(LOG_FORMATTER);

            // combine timestamp and action string with a space separator
            String logEntry = timeStamp + " " + action;
            // open logs.txt in append mode (true) with a space separator
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("logs.txt", true))) {
                // write the formatted log line to the file buffer
                writer.write(logEntry);

                // move cursor to a new line so future log entries start on a fresh line
                writer.newLine();
            } catch (IOException e) {
                // DISPLAY ERROR message if the file cannot be created or accessed
                System.err.println("Error writing to log file: " + e.getMessage());


            }

        }

    }

