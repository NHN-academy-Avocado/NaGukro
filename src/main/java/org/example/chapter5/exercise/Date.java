package org.example.chapter5.exercise;

public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int days;
    private String date;

    public String getDate() {
        return date;
    }

    public Date(String s) {
        date = s;
        year = Integer.parseInt(date.substring(0, 4));
        month = Integer.parseInt(date.substring(4, 6));
        days = Integer.parseInt(date.substring(6, s.length()));
    }

    public Date(Date date) {
        this.year = date.getYear();
        this.month = date.getMonth();
        this.days = date.getDays() + 1;
        this.date = date.getDate();
    }


    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDays() {
        return days;
    }

    @Override
    public int compareTo(Date date) {
        if (this.getYear() < date.getYear()) {
            return -1;
        } else if (this.getYear() == date.getYear()) {
            if (this.getMonth() < date.getMonth()) {
                return -1;
            } else if (this.getMonth() == date.getMonth()) {
                if (this.getDays() < date.getDays()) {
                    return -1;
                } else if (this.getDays() == date.getDays()) {
                    return 0;
                }
            }
        }
        return 1;
    }



    @Override
    public String toString() {
        return year +
                "년 " + month +
                "월 " + days +
                "일";
    }
}
