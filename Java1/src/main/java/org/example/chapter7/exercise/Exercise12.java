package org.example.chapter7.exercise;

public class Exercise12 {
    public static void main(String[] args) {
        Apartment apartment = new Apartment(10, "감자");
        apartment.resetPeoplelist();
        apartment.addPerson("김치말이");
        apartment.addPerson("김치말이");
        apartment.addPerson("김치말이");
        apartment.addPerson("감자튀김");
        apartment.addPerson("김치말이");
        apartment.addPerson("김치말이");
        apartment.addPerson("김치말이");
        apartment.removePerson(2);
        System.out.println(apartment.getPersonNmae(3));
        System.out.println(apartment.getNumberOfPeople());
        System.out.println(apartment);
    }
}