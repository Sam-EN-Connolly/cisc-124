package Exercises;

public class Time {
    public static void main (String[] args) {
        int hour = 11;
        int minute = 10;
        int second = 24;

        // Display number of seconds since midnight
        int secondsSinceMidnight = hour * 60 * 60 + minute * 60 + second;
        System.out.println("It has been " + secondsSinceMidnight + " seconds since midnight.");

        // Display the remaining number of seconds in the day
        int secondsInDay = 24*60*60;
        int remainingSeconds = secondsInDay - secondsSinceMidnight;
        System.out.println("There are " + remainingSeconds + " seconds left in the day.");

        // Display the percent of day that has passed
        float percentOfDayPassed = (float) secondsSinceMidnight / (float) secondsInDay * 100;
        System.out.println(percentOfDayPassed + "% of the day has passed.");
    }
}