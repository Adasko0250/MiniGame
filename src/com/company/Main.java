package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) {

        Character player = new Character("Bob");
        Monster monster = new Monster("RAT",47,15,50);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(player);
        System.out.println(monster);

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


        Inventory playerInventory = new Inventory(new ArrayList<>());
        EquippedItems equippedItems = new EquippedItems(new ArrayList<>());

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        monster.checkHit(player);
        player.criticalAttack(monster);

        System.out.println(monster);
        System.out.println(player);






















    }
}
