package com.company.menagers;

import com.company.monsters.Monster;
import com.company.monsters.MonsterInterface;
import com.company.player.Player;

import java.util.Random;

public class MonsterMenager implements MonsterInterface{


    @Override
    public void checkHit(Player player, Monster monster) {
        Random random = new Random();
        int num = random.nextInt(6) + 1;
        switch (num) {
            case 1, 2, 3 -> missAttack(monster);
            case 4, 5 -> attack(player, monster);
            case 6 -> criticalAttack(player, monster);
            default -> throw new IllegalStateException("Unexpected value: " + num);
        }
    }

    private void attack(Player player, Monster monster) {
        int charDEF = player.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (monster.getDamage() * check);
        int dmg = (monster.getDamage() - defMod);

        if (dmg >= player.getBoostedHP()) {
            player.setBoostedHP(0);
            System.out.println(monster.getName() + " hit " + player.getName() + " for " + dmg + " HP and kill " + player.getName());
        } else {
            System.out.println(monster.getName() + " hit " + player.getName() + " for " + dmg + " HP.");
            player.setBaseHP(player.getBaseHP() - dmg);
        }
    }

    private void criticalAttack(Player player, Monster monster) {
        int charDEF = player.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (monster.getDamage() * check);
        int dmg = ((monster.getDamage() * 2) - defMod);
        if (dmg >= player.getBoostedHP()) {
            player.setBoostedHP(0);
            System.out.println(monster.getName() + " critical hit " + player.getName() + " for " + dmg + " and kill " + player.getName());
        } else {
            System.out.println(monster.getName() + " critical hit " + player.getName() + " for " + dmg + " HP.");
            player.setBaseHP(player.getBaseHP() - dmg);
        }
    }

    private void missAttack(Monster monster) {
        System.out.println(monster.getName() + " miss attack ! ");
    }

    private double checkDefMod(int specMod) {
        return switch (specMod) {
            case 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 -> 0.1;
            case 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 -> 0.2;
            case 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 -> 0.3;
            case 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 -> 0.4;
            case 50, 51, 52, 53, 54, 55, 56, 57, 58, 59 -> 0.5;
            case 60, 61, 62, 63, 64, 65, 66, 67, 68, 69 -> 0.6;
            default -> 0;
        };
    }


}
