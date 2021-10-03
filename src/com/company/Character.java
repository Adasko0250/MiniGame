package com.company;

import java.util.List;

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
