package org.example.unit;

// 날 수 있는 유닛
public class FlyingUnit extends Unit {
    public FlyingUnit(String name, int attackPower, int healthPoint, Race race) {
        super(name, true, attackPower, healthPoint, race);
    }

    @Override
    public void attack(Unit target) {
        target.takeDamage(attackPower);
    }
}
