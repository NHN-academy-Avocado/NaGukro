package org.example.unit;

// 공중 공격이 가능한 지상 유닋
public class SpecialGroundUnit extends GroundUnit {
    public SpecialGroundUnit(String name, int attackPower, int healthPoint, Race race) {
        super(name, attackPower, healthPoint, race);
    }

    @Override
    public void attack(Unit target) {
        target.takeDamage(attackPower);  // 공중 유닛도 공격 가능
    }
}

