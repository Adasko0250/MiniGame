package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) {

        Random random = new Random();
        Character player = new Character("Bob");
        Monster monster = new Monster("RAT",47,15,50);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(player);
        System.out.println(monster);

        Inventory playerInventory = new Inventory(new ArrayList<>());
        EquippedItems equippedItems = new EquippedItems(new ArrayList<>());

        List<Item> items = new ArrayList<>();
        items.add(new Item("Axe",30,15));
        items.add(new Item("Sword",42,24));
        items.add(new Item("Shield",2,50));
        items.add(new Item("Helmet",0,35));


        Inventory monsterLoot = new Inventory(new ArrayList<>());
        monsterLoot.addItem(new Item("Wodden Sword",10,5));
        monsterLoot.addItem(new Item("Gold x 100"));

        monster.setInventory(monsterLoot);




        Item item1 = new Item(items.get(random.nextInt(items.size())));
        Item item2 = new Item(items.get(random.nextInt(items.size())));
        Item item3 = new Item(items.get(random.nextInt(items.size())));
        Item item4 = new Item(items.get(random.nextInt(items.size())));
        Item item5 = new Item(items.get(random.nextInt(items.size())));
        Item item6 = new Item(items.get(random.nextInt(items.size())));

        playerInventory.addItem(item1);
        //equippedItems.addEqItem(item2);
        player.setEquippedItems(equippedItems);




        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        monster.checkHit(player);
        player.checkHit(monster);

        System.out.println(player);
        System.out.println(monster);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + " " +player.getName());

        System.out.println(playerInventory);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX  LOOT XXXXXXXXXXXXXXXXXXXXXXXXXXXX" + " " +monster.getName());
        player.openMonsterLoot(monster);

        player.takeLoot(monster,playerInventory);




        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" + " " +player.getName());
        System.out.println(playerInventory);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXX  LOOT XXXXXXXXXXXXXXXXXXXXXXXXXXXX" + " " +monster.getName());
        player.openMonsterLoot(monster);

        System.out.println(equippedItems);
        player.equipItem(playerInventory.getInventory().get(1), playerInventory,equippedItems);



        /*player.equipItem(equippedItems.getEqItem().get(0));
        System.out.println(player);
        */

        System.out.println(playerInventory);
        System.out.println(equippedItems);
        player.unEquipItem(equippedItems.getEqItem().get(0),equippedItems,playerInventory);

        System.out.println(playerInventory);
        System.out.println(equippedItems);







    }
}
