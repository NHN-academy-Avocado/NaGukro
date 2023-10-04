package org.example.chapter11.exercise;

public class Exercise4 {
    public static void main(String[] args) {
        Apartment apartment = new Apartment(100, "필문대로 287번길");

        System.out.println("아파트에 살고 있는 사람 수: " + apartment.countPersons());
        System.out.println("이 아파트에는 한 가족만 살고 있나요? " + apartment.checkFamily());

        apartment.addPerson("하나", "김", 30, "광주");
        apartment.addPerson("두리", "박", 28, "서울");

        System.out.println("이제, 아파트에 살고 있는 사람 수: " + apartment.countPersons());
        System.out.println("이 아파트에는 한 가족만 살고 있나요? " + apartment.checkFamily());

        apartment.addPerson("삼이", "이", 55, "부산");

        System.out.println("추가 후, 아파트에 살고 있는 사람 수: " + apartment.countPersons());
        System.out.println("이 아파트에는 한 가족만 살고 있나요? " + apartment.checkFamily());
    }
}
