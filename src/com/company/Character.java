package com.company;

import java.util.List;
import java.util.Random;

public class Character {

    private String Name;
    private int damage = 25;
    private int defence = 60;
    private int HP = 500;
    private List<Item> inventory;
    private List<Item> equippedItems;


    public Character(String name) {
        Name = name;
    }

    public List<Item> getEquippedItems() {
        return equippedItems;
    }

    public void setEquippedItems(List<Item> equippedItems) {
        this.equippedItems = equippedItems;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
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

    public void equipItem(Item item){
        setDamage(item.getDamage()+getDamage());
        setDefence(item.getDefence()+getDefence());
    }

    public void unEquipItem(Item item){
        setDamage(getDamage()-item.getDamage());
        setDefence(getDefence()-item.getDefence());

    }
    public void checkHit(Monster monster){
        Random random = new Random();
        int num = random.nextInt(6)+1;
        switch (num){
            case 1, 2, 3 -> missAttack();
            case 4, 5 -> attack(monster);
            case 6 -> criticalAttack(monster);
            default ->
                    throw new IllegalStateException("Unexpected value: " + num);
        }
    }

    public double checkDefMod(int specMod) {
        return switch (specMod) {
            case 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 -> 0.1;
            case 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 -> 0.2;
            case 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 -> 0.3;
            case 40 ,41, 42, 43, 44, 45, 46, 47, 48, 49 -> 0.4;
            case 50 ,51, 52, 53, 54, 55, 56, 57, 58, 59 -> 0.5;
            case 60 ,61, 62, 63, 64, 65, 66, 67, 68, 69  -> 0.6;
            default -> 0;
        };
    }

    public void attack(Monster monster){
        int charDEF = monster.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (getDamage()*check);
        int dmg = (getDamage()-defMod);

        System.out.println(dmg);
        if(dmg >= monster.getHP()){
            monster.setHP(0);
            System.out.println(getName() + " hit " + monster.getName() + " for " + dmg + " and kill " + monster.getName());
        }else {
            System.out.println(getName() + " hit " + monster.getName() + " for " + dmg);
            monster.setHP(monster.getHP() - dmg);
        }
    }

    public void criticalAttack(Monster monster){
        int charDEF = monster.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (getDamage()*check);
        int dmg = ((getDamage()*2)-defMod);
        if(dmg >= monster.getHP()){
            monster.setHP(0);
            System.out.println(getName() + " critical hit " + monster.getName() + " for " + dmg +" and kill " + monster.getName() );
            }else{
            System.out.println(getName() + " critical hit " + monster.getName() + " for " + dmg);
            monster.setHP(monster.getHP()-dmg);
        }
    }

    public void missAttack(){
        System.out.println(getName() + " miss attack");
    }

    @Override
    public String toString() {
            return "Character :: " +
                    "Name = '" + Name + '\'' +
                    ", Damage = " + damage +
                    ", Defence = " + defence +
                    ", HP :: " + HP +
                    "\n";

    }
}
