package com.company.monsters;

import com.company.Item;

import java.util.List;

public class MonsterItems {
    private List<Item> monsterItems;

    public MonsterItems() {
    }

    public MonsterItems(List<Item> monsterLoot) {
        this.monsterItems = monsterLoot;
    }

    public List<Item> getMonsterItems() {
        return monsterItems;
    }

    public void setMonsterItems(List<Item> monsterItems) {
        this.monsterItems = monsterItems;
    }

    public void addItem(Item item) {
        if (monsterItems.size() == 6) {
            System.out.println("Cant add " + item.getName() + " to monster loot! ");
        } else
            monsterItems.add(item);
    }

    public void removeItem(Item item) {
        monsterItems.remove(item);

    }

    public void removeAllItems() {
        monsterItems.removeAll(getMonsterItems());
    }
    public List<Item> rollItems(List<Item> rolledItems){


        return rolledItems;
    }

    @Override
    public String toString() {
        int invSize = monsterItems.size();

        return switch (invSize) {
            case 1 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterItems.get(0);
            case 2 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterItems.get(0) +
                    "2. " + monsterItems.get(1);
            case 3 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterItems.get(0) +
                    "2. " + monsterItems.get(1) +
                    "3. " + monsterItems.get(2);
            case 4 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterItems.get(0) +
                    "2. " + monsterItems.get(1) +
                    "3. " + monsterItems.get(2) +
                    "4. " + monsterItems.get(3);
            case 5 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterItems.get(0) +
                    "2. " + monsterItems.get(1) +
                    "3. " + monsterItems.get(2) +
                    "4. " + monsterItems.get(3) +
                    "5. " + monsterItems.get(4);
            case 6 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterItems.get(0) +
                    "2. " + monsterItems.get(1) +
                    "3. " + monsterItems.get(2) +
                    "4. " + monsterItems.get(3) +
                    "5. " + monsterItems.get(4) +
                    "6. " + monsterItems.get(5);
            default -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" + "EMPTY";
        };

    }
}
