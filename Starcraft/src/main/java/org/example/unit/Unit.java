package org.example.unit;

public abstract class Unit {
    protected String name;
    protected boolean canFly;
    protected int attackPower;
    protected int healthPoint;

    public String getName() {
        return name;
    }


    public int getHealthPoint() {
        return healthPoint;
    }

    public Race race;

    public enum Race {
        TERRAN, PROTOSS, ZERG;
    }


    public Unit(String name, boolean canFly, int attackPower, int healthPoint, Race race) {
        this.name = name;
        this.canFly = canFly;
        this.attackPower = attackPower;
        this.healthPoint = healthPoint;
        this.race = race;

    }

    public Race getRace() {
        return race;
    }

    // 공격하는 메서드 - 하위 타입위에서 오버라이드할 수 있게
    public abstract void attack(Unit target);

    // 공격받는 메서드
    public void takeDamage(int damage) {
        healthPoint -= damage;
//        if (healthPoint <= 0) {
//            System.out.println(name + " 유닛이 소멸되었습니다.");
//        }
    }

/*
    public boolean isAlive() {
        return healthPoint > 0;
    }
*/


}

