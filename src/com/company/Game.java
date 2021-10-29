package com.company;

import com.company.menagers.PlayerMenager;
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
        PlayerMenager playerMenager = new PlayerMenager();

        Monster rat = new Monster("RAT", 47, 15, 10, 450);
        Monster skeleton = new Monster("Skeleton", 50, 15, 20, 1500);

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


        //player.setEquippedItems(equippedItems);
        //player.setInventory(playerInventory);
       // playerInventory.addItem(items.get(0));
        //playerInventory.addItem(items.get(1));



        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        playerMenager.checkHit(rat, player);
        //player.checkHit(skeleton, player);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        //playerMenager.openMonsterLoot(rat);


        //playerMenager.takeLoot(rat, playerInventory, 0,player);

       // playerMenager.openMonsterLoot(rat);

       // System.out.println(equippedItems);
        //System.out.println(playerInventory);

        //playerMenager.equipItem(playerInventory.getInventory().get(1), playerInventory, equippedItems,player);
       // System.out.println(equippedItems);

        //playerMenager.unEquipItem(equippedItems.getEqItem().get(0), equippedItems, playerInventory,player);
       // System.out.println(playerInventory);
        System.out.println(playerMenager.hpBoost());

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        System.out.println(player);
        playerMenager.checkHit(rat, player);
        playerMenager.checkHit(skeleton, player);
        System.out.println(player);

        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");

        rat.checkHit(player);
        System.out.println(player);

    }
}
