// GameController.java

package org.example;

import java.util.Random;
import java.util.Scanner;
import org.example.unit.Race;
import org.example.unit.Unit;
import org.example.unit.protoss.Carrier;
import org.example.unit.protoss.Corsair;
import org.example.unit.protoss.Dragoon;
import org.example.unit.protoss.HighTempler;
import org.example.unit.protoss.Scout;
import org.example.unit.protoss.Zealot;
import org.example.unit.terran.BattleCruzer;
import org.example.unit.terran.Goliath;
import org.example.unit.terran.Marine;
import org.example.unit.terran.Tank;
import org.example.unit.terran.Valkyrie;
import org.example.unit.terran.Wraith;
import org.example.unit.zerg.Guardian;
import org.example.unit.zerg.Hydralisk;
import org.example.unit.zerg.Mutalisk;
import org.example.unit.zerg.Queen;
import org.example.unit.zerg.Ultralisk;
import org.example.unit.zerg.Zergling;

public class GameController {
    private Player player;
    private Player computer;
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();

    public void startGame() {
        System.out.println("종족을 선택하세요: 1. Terran 2. Protos 3. Zerg");
        int choice = scanner.nextInt();
        while (choice < 1 || choice > 3) {
            System.out.println("오류: 1, 2, 3 중에서 선택해주세요.");
            System.out.println("종족을 선택하세요: 1. Terran 2. Protos 3. Zerg");
            choice = scanner.nextInt();
        }

        player = new Player(Race.values()[choice - 1]);
        computer = new Player(Race.values()[random.nextInt(3)]);

        initializeUnits(player);
        initializeUnits(computer);

        while (true) {
            displayUnits();

            if (isGameOver()) {
                break;
            }

            playerTurn();
            computerTurn();
        }
    }


    //유닛 초기화
    private void initializeUnits(Player p) {
        int unitCount;
        switch (p.getRace()) {
            case TERRAN:
                unitCount = 5;
                break;
            case PROTOSS:
                unitCount = 4;
                break;
            case ZERG:
                unitCount = 8;
                break;
            default:
                unitCount = 5;
        }

        for (int i = 0; i < unitCount; i++) {
            Unit newUnit = createRandomUnit(p.getRace());
            p.getUnits().add(newUnit);
        }
    }

    //유닛 랜덤으로 생성
    private Unit createRandomUnit(Race race) {
        switch (race) {
            case TERRAN:
                int randomChoiceTerran = random.nextInt(6);
                switch (randomChoiceTerran) {
                    case 0:
                        return new Marine();
                    case 1:
                        return new Tank();
                    case 2:
                        return new Goliath();
                    case 3:
                        return new Wraith();
                    case 4:
                        return new Valkyrie();
                    case 5:
                        return new BattleCruzer();
                    default:
                        return null;
                }

            case PROTOSS:
                int randomChoiceProtos = random.nextInt(6);
                switch (randomChoiceProtos) {
                    case 0:
                        return new Zealot();
                    case 1:
                        return new Dragoon();
                    case 2:
                        return new HighTempler();
                    case 3:
                        return new Scout();
                    case 4:
                        return new Corsair();
                    case 5:
                        return new Carrier();
                    default:
                        return null;
                }

            case ZERG:
                int randomChoiceZerg = random.nextInt(6);
                switch (randomChoiceZerg) {
                    case 0:
                        return new Zergling();
                    case 1:
                        return new Hydralisk();
                    case 2:
                        return new Ultralisk();
                    case 3:
                        return new Mutalisk();
                    case 4:
                        return new Guardian();
                    case 5:
                        return new Queen();
                    default:
                        return null;
                }

            default:
                return null;
        }
    }


    private void displayUnits() {
        System.out.println("당신의 유닛들:");
        for (Unit u : player.getUnits()) {
            System.out.println(u.getName() + " - 체력: " + u.getHealthPoint());
        }

        System.out.println("\n컴퓨터의 유닛들:");
        for (Unit u : computer.getUnits()) {
            System.out.println(u.getName() + " - 체력: " + u.getHealthPoint());
        }
    }

    private boolean isGameOver() {
        if (player.getUnits().isEmpty() || computer.getUnits().isEmpty()) {
            if (player.getUnits().isEmpty()) {
                System.out.println("당신이 패배했습니다!");
            } else {
                System.out.println("당신이 승리했습니다!");
            }
            return true;
        }
        return false;
    }

    private void playerTurn() {
        System.out.println("어떤 유닛으로 공격하시겠습니까?");
        for (int i = 0; i < player.getUnits().size(); i++) {
            System.out.println(i + ". " + player.getUnits().get(i).getName());
        }

        int attackerIndex = scanner.nextInt();
        Unit attacker = player.getUnits().get(attackerIndex);

        System.out.println("어떤 적 유닛을 공격하시겠습니까?");
        for (int i = 0; i < computer.getUnits().size(); i++) {
            System.out.println(i + ". " + computer.getUnits().get(i).getName());
        }

        int defenderIndex = scanner.nextInt();
        Unit defender = computer.getUnits().get(defenderIndex);

        attacker.attack(defender);

        if (defender.getHealthPoint() <= 0) {
            computer.getUnits().remove(defender);
            System.out.println(defender.getName() + " 유닛이 소멸되었습니다!");
        }
    }

    private void computerTurn() {
        if (computer.getUnits().isEmpty() || player.getUnits().isEmpty()) {
            return;
        }

        Unit attacker = computer.getUnits().get(random.nextInt(computer.getUnits().size()));
        Unit defender = player.getUnits().get(random.nextInt(player.getUnits().size()));

        System.out.println("컴퓨터의 " + attacker.getName() + "가 당신의 " + defender.getName() + "를 공격합니다!");
        attacker.attack(defender);

        if (defender.getHealthPoint() <= 0) {
            player.getUnits().remove(defender);
            System.out.println(defender.getName() + " 유닛이 소멸되었습니다!");
        }
    }
}
