package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Character player = new Character("Bob");
        System.out.println(player);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");


        List<Item> items = new ArrayList<>();
        items.add(new Item("Axe",30,15));
        items.add(new Item("Sword",42,24));
        items.add(new Item("Shield",2,50));
        items.add(new Item("Helmet",0,35));

        Random random = new Random();

        Item item1 = items.get(random.nextInt(items.size()));
        Item item2 = items.get(random.nextInt(items.size()));

        List<Item> inventory = new ArrayList<>();
        inventory.add(item1);
        inventory.add(item2);

        player.setInventory(inventory);
        System.out.println(player);

        System.out.println("XXXXXXXXXXXXXXXXXXXX <<< EQUIPPED ITEM >>> XXXXXXXXXXXXXXXXXXXX");
        player.equipItem(item1);

        System.out.println(player);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        player.unEquipItem(item1);
        System.out.println(player);





    }
}
