package org.example.chapter8;

import java.io.BufferedReader;
import java.io.IOException;

public class Car {
    private String model;
    private int year;

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", km=" + km +
                ", price=" + price +
                '}';
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public int getKm() {
        return km;
    }

    public double getPrice() {
        return price;
    }

    private int km;
    private double price;

    public Car(String model, int year, int km, double price) {
        this.model = model;
        this.year = year;
        this.km = km;
        this.price = price;
    }

    public boolean equalTo(Car c) {
        if (this.model.equals(c.model) && this.year == (c.year) && this.km == (c.km) &&
                this.price == (c.price)) {
            return true;
        } else {
            return false;
        }
    }

    public static Car read(BufferedReader br) throws IOException {
        String s = br.readLine();
        if (s == null) {
            return null;
        } else {
            return new Car(s, Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), Double.parseDouble(
                    br.readLine()));
        }
    }


}
