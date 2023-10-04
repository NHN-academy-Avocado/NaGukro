package org.example.chapter4.exercise;

public class Product {

    //Todo 4-9
    private String name;
    private int price;

    public Product(String name) {
        this.name = name;
    }

    public void downLoad(int num) {
        price -= num;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void upLoad(int num) {
        price += num;
    }


}
