package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Character player = new Character("Bob");
        System.out.println(player);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");



        List<Item> items = new ArrayList<>();
        items.add(new Item("Axe",30,15));
        items.add(new Item("Sword",42,24));
        items.add(new Item("Shield",2,50));
        items.add(new Item("Helmet",0,35));

        Random random = new Random();

        Item item1 = new Item(items.get(random.nextInt(items.size())));
        Item item2 = new Item(items.get(random.nextInt(items.size())));
        Item item3 = new Item(items.get(random.nextInt(items.size())));
        Item item4 = new Item(items.get(random.nextInt(items.size())));
        Item item5 = new Item(items.get(random.nextInt(items.size())));
        Item item6 = new Item(items.get(random.nextInt(items.size())));
        Item item7 = new Item(items.get(random.nextInt(items.size())));


        Inventory playerInventory = new Inventory( new ArrayList<>());


        playerInventory.addItem(item1);
        playerInventory.addItem(item2);
        playerInventory.addItem(item3);
        playerInventory.addItem(item4);
        playerInventory.addItem(item5);
        playerInventory.addItem(item6);

        playerInventory.addItem(item7);

        System.out.println(playerInventory);
        playerInventory.removeItem(item2);
        System.out.println(playerInventory);














    }
}
