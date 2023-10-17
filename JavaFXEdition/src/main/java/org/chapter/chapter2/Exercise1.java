package org.chapter.chapter2;

public class Exercise1 {
    public static void main(String[] args) {
        printInitials();
    }

    private static void printInitials() {
        String[] initials = {
                "*     *   *****  ******  ",
                "**    *  *       *    * ",
                "* *   *  *       *    * ",
                "*  *  *  *   *** *****  ",
                "*   * *  *     * *   *  ",
                "*    **  *     * *    * ",
                "*     *   *****  *     *",
                "",
                ""
        };

        for (String line : initials) {
            System.out.println(line);
        }
    }
}