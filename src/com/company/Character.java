package com.company;

import java.util.List;

public class Character {

    private String Name;
    private int damage = 25;
    private int defence = 20;
    private int HP = 500;
    private List<Item> items;

    public Character(String name) {
        Name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
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
    public void equipItem(Item item){
        setDamage(item.getDamage()+getDamage());
        setDefence(item.getDefence()+getDefence());
        item.setNote("Equipped");

    }
    public void unEquipItem(Item item){
        setDamage(getDamage()-item.getDamage());
        setDefence(getDefence()-item.getDefence());
        item.setNote(null);

    }


    @Override
    public String toString() {


        if(items == null){
            return "Character :: " +
                    "Name = '" + Name + '\'' +
                    ", Damage = " + damage +
                    ", Defence = " + defence +
                    ", HP :: " + HP +
                    "\n";
        }else {
            return "Character :: " +
                    "Name = '" + Name + '\'' +
                    ", Damage = " + damage +
                    ", Defence = " + defence +
                    ", HP :: " + HP +
                    "\n" +" Inventor :: "+ "\n" + items +
                    ' ';
        }
    }
}
