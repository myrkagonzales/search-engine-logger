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

    public static final main(String[] args) {


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
}
