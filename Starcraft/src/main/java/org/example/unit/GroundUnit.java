package org.example.unit;

// 지상 유닛
public class GroundUnit extends Unit {
    public GroundUnit(String name, int attackPower, int healthPoint,Race race) {
        super(name, false, attackPower, healthPoint, race);
    }

    @Override
    public void attack(Unit target) {
        if (target.canFly) {
            System.out.println("대공 유닛이 아닙니다.");
            return;
        }
        target.takeDamage(attackPower);
    }
}
