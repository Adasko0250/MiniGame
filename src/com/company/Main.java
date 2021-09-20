package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Character player = new Character("Bob");
        player.showCharacter();
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");


        List<Item> items = new ArrayList<>();
        items.add(new Item("Axe",30,15));
        items.add(new Item("Sword",42,24));
        items.add(new Item("Shield",2,50));
        items.add(new Item("Helmet",0,35));

        Random random = new Random();

        List<Item> inventory = new ArrayList<>();

        inventory.add(items.get(random.nextInt(items.size())));
        inventory.add(items.get(random.nextInt(items.size())));

        player.setItems(inventory);
        player.showCharacter();

        System.out.println("XXXXXXXXXXXXXXXXXXXX <<< EQUIPPED ITEM >>> XXXXXXXXXXXXXXXXXXXX");
        player.equipItem(inventory.get(0));

        player.showCharacter();

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        player.unEquipItem(inventory.get(0));
        player.showCharacter();





    }
}
