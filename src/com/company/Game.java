package com.company;

import com.company.monsters.Monster;
import com.company.monsters.MonsterItems;
import com.company.player.EquippedItems;
import com.company.player.Inventory;
import com.company.player.Player;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Game extends JFrame {

    private GameScreen gameScreen;

    public Game() {
        setSize(400, 400);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        gameScreen = new GameScreen();
        add(gameScreen);

    }


    public static void main(String[] args) {

        //Game game = new Game();
        Random random = new Random();
        Player player = new Player("Bob");
        Monster rat = new Monster("RAT", 47, 15, 10, 120);
        Monster skeleton = new Monster("Skeleton", 50, 15, 20, 100);

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


        MonsterItems ratLoot = new MonsterItems(new ArrayList<>());
        ratLoot.addItem(new Item("Gold x", random.nextInt(6) + 1));
        ratLoot.addItem(new Item(monRatLoot.get(random.nextInt(monRatLoot.size()))));
        ratLoot.addItem(new Item(monRatLoot.get(random.nextInt(monRatLoot.size()))));
        rat.setMonsterloot(ratLoot);


        player.setEquippedItems(equippedItems);
        player.setInventory(playerInventory);
        playerInventory.addItem(items.get(0));
        playerInventory.addItem(items.get(1));



        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        player.checkHit(rat, player);
        player.checkHit(skeleton, player);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        player.openMonsterLoot(rat);


        player.takeLoot(rat, playerInventory, 0,player);

        player.openMonsterLoot(rat);

        System.out.println(equippedItems);
        System.out.println(playerInventory);

        player.equipItem(playerInventory.getInventory().get(1), playerInventory, equippedItems,player);
        System.out.println(equippedItems);

        //player.unEquipItem(equippedItems.getEqItem().get(0), equippedItems, playerInventory,player);
        System.out.println(playerInventory);


        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        System.out.println(player);
        player.checkHit(rat, player);
        player.checkHit(skeleton, player);
        System.out.println(player);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");


    }
}
