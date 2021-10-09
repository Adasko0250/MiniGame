package com.company;

import java.util.List;

public class MonsterLoot {
    private List<Item> monsterloot;

    public MonsterLoot() {
    }

    public MonsterLoot(List<Item> monsterloot) {
        this.monsterloot = monsterloot;
    }

    public List<Item> getMonsterloot() {
        return monsterloot;
    }

    public void setMonsterloot(List<Item> monsterloot) {
        this.monsterloot = monsterloot;
    }

    public void addItem(Item item) {
        if (monsterloot.size() == 6) {
            System.out.println("Cant add " + item.getName() + " to monsterloot! ");
        } else
            monsterloot.add(item);
    }

    public void removeItem(Item item) {
        monsterloot.remove(item);

    }

    public void removeAllItems() {
        monsterloot.removeAll(getMonsterloot());
    }
    public List<Item> rollItems(List<Item> rolledItems){


        return rolledItems;
    }

    @Override
    public String toString() {
        int invSize = monsterloot.size();

        return switch (invSize) {
            case 1 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterloot.get(0);
            case 2 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterloot.get(0) +
                    "2. " + monsterloot.get(1);
            case 3 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterloot.get(0) +
                    "2. " + monsterloot.get(1) +
                    "3. " + monsterloot.get(2);
            case 4 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterloot.get(0) +
                    "2. " + monsterloot.get(1) +
                    "3. " + monsterloot.get(2) +
                    "4. " + monsterloot.get(3);
            case 5 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterloot.get(0) +
                    "2. " + monsterloot.get(1) +
                    "3. " + monsterloot.get(2) +
                    "4. " + monsterloot.get(3) +
                    "5. " + monsterloot.get(4);
            case 6 -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + monsterloot.get(0) +
                    "2. " + monsterloot.get(1) +
                    "3. " + monsterloot.get(2) +
                    "4. " + monsterloot.get(3) +
                    "5. " + monsterloot.get(4) +
                    "6. " + monsterloot.get(5);
            default -> "XXXXXXXXXXXXXXXXXXXX <<< Loot >>> XXXXXXXXXXXXXXXXXXXX" + "\n" + "EMPTY";
        };

    }
}
