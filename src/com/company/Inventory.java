package com.company;

import java.util.List;

public class Inventory extends Item {
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

    public void addItem(Item item) {
        if (inventory.size() == 6) {
            System.out.println("Cant add " + item.getName() + " to inventory! ");
        } else
            inventory.add(item);
    }

    public void removeItem(Item item) {
        inventory.remove(item);

    }

    public void clearInventory() {
        inventory.removeAll(getInventory());
    }

    @Override
    public String toString() {
        int invSize = inventory.size();

        return switch (invSize) {
            case 1 -> "XXXXXXXXXXXXXXXXXXXX <<< Inventory >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + inventory.get(0);
            case 2 -> "XXXXXXXXXXXXXXXXXXXX <<< Inventory >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + inventory.get(0) +
                    "2. " + inventory.get(1);
            case 3 -> "XXXXXXXXXXXXXXXXXXXX <<< Inventory >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + inventory.get(0) +
                    "2. " + inventory.get(1) +
                    "3. " + inventory.get(2);
            case 4 -> "XXXXXXXXXXXXXXXXXXXX <<< Inventory >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + inventory.get(0) +
                    "2. " + inventory.get(1) +
                    "3. " + inventory.get(2) +
                    "4. " + inventory.get(3);
            case 5 -> "XXXXXXXXXXXXXXXXXXXX <<< Inventory >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + inventory.get(0) +
                    "2. " + inventory.get(1) +
                    "3. " + inventory.get(2) +
                    "4. " + inventory.get(3) +
                    "5. " + inventory.get(4);
            case 6 -> "XXXXXXXXXXXXXXXXXXXX <<< Inventory >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + inventory.get(0) +
                    "2. " + inventory.get(1) +
                    "3. " + inventory.get(2) +
                    "4. " + inventory.get(3) +
                    "5. " + inventory.get(4) +
                    "6. " + inventory.get(5);
            default -> "XXXXXXXXXXXXXXXXXXXX <<< Inventory >>> XXXXXXXXXXXXXXXXXXXX" + "\n" + "EMPTY";
        };

    }
}
