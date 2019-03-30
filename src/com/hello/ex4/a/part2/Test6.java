package com.hello.ex4.a.part2;

import java.util.Calendar;

public class Test6 {

    /**
     * Usage:  java PATH_TO_THIS_CLASS <year> <month>
     *   <year>  required
     *   <month> required (1-12)
     *   -h      display this help and exit
     * @author kaixinguo
     */
    public static void main(String[] args) {

        // Check Input Parameters
        if (args.length == 2) {
            try {

                // Get YEAR and MONTH from args[]
                int year = Integer.valueOf(args[0]);
                int month = Integer.valueOf(args[1]);

                // Check YEAR and MONTH
                if (month >= 1 && month <= 12) {
                    printCalendar(year, month);
                } else {
                    printError("Illegal month: " + month);
                }
            } catch (NumberFormatException e) {
                printError("Illegal parameter: " + e.getMessage());
            }
        } else if (args.length == 1 && "-h".equals(args[0])) {
            printHelp();
        } else {
            printError("Illegal number of parameters!");
        }
    }

    /**
     * Print Calendar
     */
    private static void printCalendar(int year, int month) {

        // Get new Calendar Instance
        Calendar calendar = Calendar.getInstance();

        // Get Days of Previous Month
        calendar.set(year, month - 1, 0);
        int prevDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Get Days of This Month
        calendar.set(year, month - 1, 1);
        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        // Get DAY_OF_WEEK of the first day of this month
        int weekday = calendar.get(Calendar.DAY_OF_WEEK) - 1;

        // Column Counter
        int col = 1;

        // Print Title
        out(String.format("             %4d - %02d\n", year, month));
        out(" Sun  Mon  Tue  Wed  Thu  Fri  Sat\n");

        // Print Previous Month
        for (int i = 0; i < weekday; i++, col++) {
            out(String.format(" (%2d)", prevDays + 1 - weekday + i));
        }

        // Print This Month
        for (int i = 0; i < days; i++, col++) {
            if (col >= 8) {
                col = 1;
                out("\n");
            }
            out(String.format(" %3d ", i + 1));
        }

        // Print Next Month
        for (int i = 0; col < 8; i++, col++) {
            out(String.format("  (%d)", i + 1));
        }

        out("\n");
    }

    /**
     * Print Help Info
     */
    private static void printHelp() {

        // The help information of this application
        out("Usage:  java " + Test6.class.getCanonicalName() + " <year> <month>\n" +
                "  <year>  required\n" +
                "  <month> required (1-12)\n" +
                "  -h      display this help and exit\n");
    }

    /**
     * Print Error Info
     */
    private static void printError(String message) {

        // Print the input error message
        out(message + "\n");

        // Then print help information
        printHelp();
    }

    private static void out(String str) {
        System.out.print(str);
    }
}
