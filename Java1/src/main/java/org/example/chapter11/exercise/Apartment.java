package org.example.chapter11.exercise;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Apartment {

    private int size;
    private String address;

    // LinkedList로 변경
    private LinkedList<Person> peopleList = new LinkedList<>();

    public Apartment(int size, String address) {
        this.size = size;
        this.address = address;
    }

    public int getSize() {
        return size;
    }

    public String getAddress() {
        return address;
    }

    public int countPersons() {
        return peopleList.size();
    }

    public boolean checkFamily() {
        if (peopleList.isEmpty()) return true;

        String surname = peopleList.getFirst().getSurname();
        for (Person person : peopleList) {
            if (!person.getSurname().equals(surname)) {
                return false;
            }
        }
        return true;
    }
    public void addPerson(String name, String surname, int age, String city) {
        Person person = new Person(name, surname, age, city);
        peopleList.add(person);
    }


    public void removePerson(String name) {
        peopleList.removeIf(person -> person.getName().equals(name));
    }

    public void modifyPerson(String name, String newSurname, int newAge, String newCity) {
        for (Person person : peopleList) {
            if (person.getName().equals(name)) {
                person.setSurname(newSurname);
                person.setAge(newAge);
                person.setCity(newCity);
                return;
            }
        }
        System.out.println("해당 이름의 사람이 리스트에 없습니다.");
    }

    public void printAllPersons() {
        if (peopleList.isEmpty()) {
            System.out.println("아파트에 사는 사람이 없습니다.");
            return;
        }

        for (Person person : peopleList) {
            System.out.println("이름: " + person.getName() +
                    ", 성: " + person.getSurname() +
                    ", 나이: " + person.getAge() +
                    ", 도시: " + person.getCity());
        }
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "size=" + size +
                ", address='" + address + '\'' +
                ", peopleList=" + peopleList +
                '}';
    }

    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(fileName))) {
            writer.println(size);
            writer.println(address);
            for (Person person : peopleList) {
                writer.println(person.getName());
                writer.println(person.getSurname());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

/*
    public static Apartment readFromFile(BufferedReader reader) throws IOException {
        int size = Integer.parseInt(reader.readLine());
        String address = reader.readLine();
        Apartment apt = new Apartment(size, address);

        String name;
        while ((name = reader.readLine()) != null) {
            String surname = reader.readLine();
            apt.addPerson(name, surname);
        }

        return apt;
    }
*/
}

