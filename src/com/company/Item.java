package com.company;

public class Item {

    private String name;
    private int damage;
    private int defence;

    public Item(){

    }
    public Item (String name, int damage, int defence) {
        this.name = name;
        this.damage = damage;
        this.defence = defence;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {

        return "----- " + name.toUpperCase() + " ----- " + " Damage: " + damage + ", Defence: " + defence + ")" +"\n";

    }

}
