package com.company;

public class Item {

    private String name;
    private int damage;
    private int defence;
    private String note;


    public Item() {

    }

    public Item(String name) {
        this.name = name;
    }

    public Item(Item item) {
        this.name = item.getName();
        this.damage = item.getDamage();
        this.defence = item.getDefence();
        this.note = item.getNote();


    }

    public Item(String name, int damage, int defence) {
        this.name = name;
        this.damage = damage;
        this.defence = defence;
    }

    public Item(String name, int damage, int defence, String note) {
        this.name = name;
        this.damage = damage;
        this.defence = defence;
        this.note = note;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }


    @Override
    public String toString() {
        if (note == null) {
            return "----- " + name.toUpperCase() + " ----- " + " Damage: " + damage + ", Defence: " + defence + " ---- " + "\n";
        } else
            return "----- " + name.toUpperCase() + " ----- " + " Damage: " + damage + ", Defence: " + defence + " ---- " + note + "\n";

    }

}
