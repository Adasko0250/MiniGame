package com.company;

import com.company.level.Level;
import com.company.level.LevelDataStore;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends JFrame {

    public Game(){
        setSize(400,400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

    }


    public static void main(String[] args) {

        Game game = new Game();
        Random random = new Random();
        Character player = new Character("Bob");
        Monster rat = new Monster("RAT", 47, 15, 20, 120);
        Monster skeleton = new Monster("Skeleton", 500, 15, 20, 100);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println(player);
        System.out.println(rat);
        System.out.println(skeleton);

        Inventory playerInventory = new Inventory(new ArrayList<>());
        EquippedItems equippedItems = new EquippedItems(new ArrayList<>());

        List<Item> items = new ArrayList<>();
        items.add(new Item("Axe", 30, 15));
        items.add(new Item("Sword", 42, 24));
        items.add(new Item("Shield", 2, 50));
        items.add(new Item("Helmet", 0, 35));

        List<Item> monRatLoot = new ArrayList<>();
        monRatLoot.add(new Item("Gold x", random.nextInt(10) + 1));
        monRatLoot.add(new Item("Wodden Sword", 10, 5));
        monRatLoot.add(new Item("Wodden Shield", 0, 5));


        MonsterLoot ratLoot = new MonsterLoot(new ArrayList<>());
        ratLoot.addItem(new Item("Gold x", random.nextInt(6) + 1));
        ratLoot.addItem(new Item(monRatLoot.get(random.nextInt(monRatLoot.size()))));
        ratLoot.addItem(new Item(monRatLoot.get(random.nextInt(monRatLoot.size()))));
        rat.setMonsterloot(ratLoot);


        player.setEquippedItems(equippedItems);


        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");


        player.checkHit(rat);
        player.checkHit(skeleton);
        player.checkHit(skeleton);
        player.checkHit(skeleton);
        player.checkHit(skeleton);
        player.checkHit(skeleton);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        skeleton.checkHit(player);


       // player.openMonsterLoot(rat);

        // player.takeAllLoot(monster, playerInventory);
       // player.takeLoot(rat, playerInventory, 0);

        //player.openMonsterLoot(rat);
        //player.takeLoot(rat, playerInventory, 0);

        /* System.out.println(equippedItems);
        player.equipItem(playerInventory.getInventory().get(1), playerInventory, equippedItems);
        System.out.println(equippedItems);
        player.unEquipItem(equippedItems.getEqItem().get(0), equippedItems, playerInventory);
        System.out.println(playerInventory);
        System.out.println(equippedItems); */

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        System.out.println(player);
        player.checkHit(rat);
        player.checkHit(skeleton);
        System.out.println(player);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");



    }
}
