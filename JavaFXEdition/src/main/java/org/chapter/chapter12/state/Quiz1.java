package org.chapter.chapter12.state;

import java.util.Scanner;

public class Quiz1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the time interval (e.g. 100 or 100n): ");
        String inputTime = scanner.nextLine();

        try {
            long delayTime = getDelayTime(inputTime);
            startTicker(delayTime);
        } catch (Exception e) {
            System.out.println("Invalid time format or error: " + e.getMessage());
        }

        scanner.close();
    }

    private static long getDelayTime(String inputTime) throws IllegalArgumentException {
        long delayTime;
        if (inputTime.endsWith("n")) {
            String nanoStr = inputTime.substring(0, inputTime.length() - 1);
            delayTime = Long.parseLong(nanoStr) / 1_000_000; // convert nanoseconds to milliseconds
        } else {
            delayTime = Long.parseLong(inputTime);
        }
        return delayTime;
    }

    private static void startTicker(long delayTime) {
        long expectedEndTime = System.currentTimeMillis() + delayTime;

        while (true) {
            System.out.println("tick");
            long sleepTime = expectedEndTime - System.currentTimeMillis();
            if (sleepTime > 0) {
                try {
                    Thread.sleep(sleepTime);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Ticker interrupted");
                    return;
                }
            }
            expectedEndTime += delayTime;
        }
    }
}
