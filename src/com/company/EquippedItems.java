package com.company;

import java.util.List;

public class EquippedItems {

    private List<Item> eqItem;

    public EquippedItems() {

    }

    public EquippedItems(List<Item> eqItem) {
        this.eqItem = eqItem;
    }

    public List<Item> getEqItem() {
        return eqItem;
    }

    public void setEqItem(List<Item> eqItem) {
        this.eqItem = eqItem;
    }

    public void addEqItem(Item item) {
        if (eqItem.size() == 6 || eqItem.contains(item)) {
            System.out.println("Cant equip" + item.getName() + " !");
        } else
            eqItem.add(item);
    }

    public void removeEqItem(Item item) {
        eqItem.remove(item);
    }

    @Override
    public String toString() {
        int eqSize = eqItem.size();

        return switch (eqSize) {
            case 1 -> "XXXXXXXXXXXXXXXXXXXX <<< EQ >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + eqItem.get(0);
            case 2 -> "XXXXXXXXXXXXXXXXXXXX <<< EQ >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + eqItem.get(0) +
                    "2. " + eqItem.get(1);
            case 3 -> "XXXXXXXXXXXXXXXXXXXX <<< EQ >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + eqItem.get(0) +
                    "2. " + eqItem.get(1) +
                    "3. " + eqItem.get(2);
            case 4 -> "XXXXXXXXXXXXXXXXXXXX <<< EQ >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + eqItem.get(0) +
                    "2. " + eqItem.get(1) +
                    "3. " + eqItem.get(2) +
                    "4. " + eqItem.get(3);
            case 5 -> "XXXXXXXXXXXXXXXXXXXX <<< EQ >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + eqItem.get(0) +
                    "2. " + eqItem.get(1) +
                    "3. " + eqItem.get(2) +
                    "4. " + eqItem.get(3) +
                    "5. " + eqItem.get(4);
            case 6 -> "XXXXXXXXXXXXXXXXXXXX <<< EQ >>> XXXXXXXXXXXXXXXXXXXX" + "\n" +
                    "1. " + eqItem.get(0) +
                    "2. " + eqItem.get(1) +
                    "3. " + eqItem.get(2) +
                    "4. " + eqItem.get(3) +
                    "5. " + eqItem.get(4) +
                    "6. " + eqItem.get(5);
            default -> "XXXXXXXXXXXXXXXXXXXX <<< EQ >>> XXXXXXXXXXXXXXXXXXXX" + "\n" + "EMPTY";
        };
    }
}
