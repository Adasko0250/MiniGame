package com.company;

import java.util.List;
import java.util.Random;

public class Monster {

    private String Name;
    private int damage;
    private int defence;
    private int HP;
    private List<Item> inventory;

    public Monster (String name, int damage, int defence, int HP) {
        Name = name;
        this.damage = damage;
        this.defence = defence;
        this.HP = HP;
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

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
    public void checkHit(Character character){
        Random random = new Random();
        int num = random.nextInt(6)+1;
        System.out.println(num);
        switch (num){
            case 1, 2, 3 -> missAttack(character);
            case 4, 5 -> attack(character);
            case 6 -> criticalAttack(character);
            default ->
                throw new IllegalStateException("Unexpected value: " + num);
        }
    }

    public double checkDefMod(int specMod) {
        return switch (specMod) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9 -> 2;
            case 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 -> 0.1;
            case 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 -> 0.2;
            case 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 -> 0.3;
            case 40 ,41, 42, 43, 44, 45, 46, 47, 48, 49 -> 0.4;
            case 50 ,51, 52, 53, 54, 55, 56, 57, 58, 59 -> 0.5;
            case 60 ,61, 62, 63, 64, 65, 66, 67, 68, 69  -> 0.6;
            default -> 0;
        };
    }
    public void attack(Character character){
        int charDEF = character.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (getDamage()*check);
        int dmg = (getDamage()-defMod);
        //System.out.println("check " + check);
       // System.out.println("defMod " + defMod);
       // System.out.println("char def " + charDEF);
        System.out.println("DMG : " + dmg);
        character.setHP(character.getHP()-(getDamage()-defMod));
        System.out.println("HIT !");
    }
    public void criticalAttack(Character character){
        int charDEF = character.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (getDamage()*check);
        int dmg = ((getDamage()-defMod))*2;
        //System.out.println("check " + check);
        //System.out.println("defMod " + defMod);
        //System.out.println("char def " + charDEF);
        System.out.println("DMG : " + dmg);
        character.setHP(character.getHP()-((getDamage()-defMod))*2);
        System.out.println("CRITICAL HIT !");
    }
    public void missAttack(Character character){
        setDamage(0);
        character.setHP(character.getHP()-getDamage());
        System.out.println("MISS !");
    }


    @Override
    public String toString() {
        return "Monster{" +
                "Name='" + Name + '\'' +
                ", damage=" + damage +
                ", defence=" + defence +
                ", HP=" + HP +
                '}';
    }
}
