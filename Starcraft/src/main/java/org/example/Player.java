// Player.java

package org.example;

import java.util.ArrayList;
import org.example.unit.Race;
import org.example.unit.Unit;

public class Player {
    private Race race;
    private ArrayList<Unit> units = new ArrayList<>();

    public Player(Race race) {
        this.race = race;
    }

    public Race getRace() {
        return race;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }
}
