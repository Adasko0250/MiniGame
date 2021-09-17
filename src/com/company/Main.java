package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Character player = new Character("Bob");
        player.showCharcter();


        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Axe",30,15,"Rusty"));
        items.add(new Item("Sword",42,24,"Very old"));
        items.add(new Item("Shield",2,50));
        items.add(new Item("Helmet",0,35));




        Random random = new Random();
        player.setItems(items);
        player.showCharcter();




        ArrayList<Item> emptyBoxListItem = new ArrayList<>();

        emptyBoxListItem.add(items.get(random.nextInt(items.size())));
        emptyBoxListItem.add(items.get(random.nextInt(items.size())));
        Box box3 = new Box(emptyBoxListItem);
        box3.openBox();




    }
}
