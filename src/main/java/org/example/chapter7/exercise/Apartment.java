package org.example.chapter7.exercise;

import java.util.Arrays;

public class Apartment {

    private int size;
    private String address;

    private Person[] peoplelist = new Person[10];

    public Apartment(int size, String address) {
        this.size = size;
        this.address = address;
    }

    public void resetPeoplelist() {
        for (int i = 0; i < 10; i++) {
            Person person = new Person(i);
            peoplelist[i] = person;
        }
    }

    public int getSize() {
        return size;
    }

    public String getAddress() {
        return address;
    }

    public int getNumberOfPeople() {
        int count = 0;
        for (Person person : peoplelist) {
            if (person.getName() != null) {
                count++;
            }
        }
        return count;
    }

    public void addPerson(String name) {
        Person person = new Person(name);
        for (Person p : peoplelist) {
            if (p.getName() == null) {
                int id = p.getId();
                person.setId(id);
                p.setName(person.getName());
                break;
            }
        }

    }

    public void setId() {
        int count = 0;
        for (Person p : peoplelist) {
            p.setId(count);
            count++;
        }
    }

    public String getPersonNmae(int id) {
        for (Person person : peoplelist) {
            if (person.getId() == id) {
                return person.getName();
            }
        }
        return null;
    }

    public void removePerson (int id) {
        for (Person person : peoplelist) {
            if (person.getId()== id) {
                person.setName(null);
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "size=" + size +
                ", address='" + address + '\'' +
                ", peoplelist=" + Arrays.toString(peoplelist) +
                '}';
    }
}