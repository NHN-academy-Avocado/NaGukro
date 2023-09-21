package org.example.chapter7;

public class ApartmentOwner {
    private String owner;
    private String[] apartments;

    public ApartmentOwner(String owner) {
        this.owner = owner;
        apartments = new String[10];
    }

    public String getOwner() {
        return owner;
    }

    public String getApartment(int slot) {
        return apartments[slot];
    }

    public void setApartment(String address, int slot) {
        apartments[slot] = address;
    }

    public int countApartments() {
        int num = 0;
        for (int i = 0; i < 10; i++)
            if (apartments[i] != null)
                num ++;
        return num;
    }

    public void reorganizeApartments() {
        int empty = -1; // index of the first empty slot
        for (int i = 0; i < 10; i++) {
            if (apartments[i] == null && empty == -1)
                empty = i;
            if (apartments[i] != null && empty != -1) {
                apartments[empty] = apartments[i];
                apartments[i] = null;
                empty++;
            }
        }
    }

    public String toString() {
        String ris = "";
        ris += "Owner: " + owner;
        for (int i = 0; i < 10; i++)
            if (apartments[i] != null)
                ris += "\nApartment " + i + ": " + apartments[i];
        return ris;
    }
}