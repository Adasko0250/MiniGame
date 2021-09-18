package com.company;

import java.util.ArrayList;

public class Character {

    private String Name;
    private int damage = 25;
    private int defence = 20;
    private int HP = 500;
    private ArrayList<Item> items;

    public Character(String name) {
        Name = name;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
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

    public void showCharacter()
    {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Character{" +
                "Name='" + Name + '\'' +
                ", damage=" + damage +
                ", defence=" + defence +
                ", HP :: " + HP +
                "\n" +" Inventor :: "+ "\n" + items +
                '}';
    }
}
