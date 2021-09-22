package com.company;

import java.util.List;

public class Inventory  extends Item{
    private List<Item> inventory;

    public Inventory() {
    }

    public Inventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }
    public void addItem(Item item){
        inventory.add(item);
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "inventory=" + inventory +
                '}';
    }
}
