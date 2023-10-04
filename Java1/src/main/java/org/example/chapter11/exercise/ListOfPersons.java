package org.example.chapter11.exercise;

import java.util.ArrayList;

class ListOfPersons {
    private ArrayList<Person> persons;

    public ListOfPersons() {
        this.persons = new ArrayList<>();
    }

    public void addPerson(Person person) {
        persons.add(person);
    }

    public void deletePerson(Person person) {
        persons.remove(person);
    }

    public void modifyPerson(Person person, String name, String surname, int age, String city) {
        person.setName(name);
        person.setSurname(surname);
        person.setAge(age);
        person.setCity(city);
    }

    public void printAllPersons() {
        for (Person person : persons) {
            System.out.println(person.getName() + " " + person.getSurname() + ", " + person.getAge() + ", " + person.getCity());
        }
    }

    public int countPersonsInCity(String city) {
        int count = 0;
        for (Person person : persons) {
            if (person.getCity().equals(city)) {
                count++;
            }
        }
        return count;
    }

    public double computeAverageAge() {
        if (persons.isEmpty()) return 0;

        double sum = 0;
        for (Person person : persons) {
            sum += person.getAge();
        }
        return sum / persons.size();
    }
}

