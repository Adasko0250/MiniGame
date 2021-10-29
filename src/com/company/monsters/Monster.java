package com.company.monsters;


import com.company.player.Player;

import java.util.Random;

public class Monster {

    private String Name;
    private int damage;
    private int defence;
    private int HP;
    private int experience;
    private MonsterItems monsterloot;

    public Monster(String name, int damage, int defence, int HP,int experience) {
        Name = name;
        this.damage = damage;
        this.defence = defence;
        this.HP = HP;
        this.experience = experience;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public MonsterItems getMonsterloot() {
        return monsterloot;
    }

    public void setMonsterloot(MonsterItems monsterloot) {
        this.monsterloot = monsterloot;
    }

    public void checkHit(Player player) {
        Random random = new Random();
        int num = random.nextInt(6) + 1;
        switch (num) {
            case 1, 2, 3 -> missAttack();
            case 4, 5 -> attack(player);
            case 6 -> criticalAttack(player);
            default -> throw new IllegalStateException("Unexpected value: " + num);
        }
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

    private void attack(Player player) {
        int charDEF = player.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (getDamage() * check);
        int dmg = (getDamage() - defMod);

        if (dmg >= player.getBoostedHP()) {
            player.setBoostedHP(0);
            System.out.println(getName() + " hit " + player.getName() + " for " + dmg + " HP and kill " + player.getName());
        } else {
            System.out.println(getName() + " hit " + player.getName() + " for " + dmg + " HP.");
            player.setBaseHP(player.getBaseHP() - dmg);
        }
    }

    private void criticalAttack(Player player) {
        int charDEF = player.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (getDamage() * check);
        int dmg = ((getDamage() * 2) - defMod);
        if (dmg >= player.getBoostedHP()) {
            player.setBoostedHP(0);
            System.out.println(getName() + " critical hit " + player.getName() + " for " + dmg + " and kill " + player.getName());
        } else {
            System.out.println(getName() + " critical hit " + player.getName() + " for " + dmg + " HP.");
            //player.setBoostedHP(player.getBoostedHP() - dmg);
            player.setBaseHP(player.getBaseHP() - dmg);
        }
    }

    private void missAttack() {
        System.out.println(getName() + " miss attack ! ");
    }


    @Override
    public String toString() {
        return "Monster :: " +
                "Name ='" + Name + '\'' +
                ", Damage = " + damage +
                ", Defence = " + defence +
                ", HP :: " + HP +
                ", EXP ::" + experience;
    }
}
