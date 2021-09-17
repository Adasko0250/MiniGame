package com.company;


import java.util.ArrayList;

public class Box {

    public Item item;
    public ArrayList<Item> items;


    public Box(Item item){
        this.item=item;
    }
    public Box(ArrayList<Item> items){
        this.items=items;
    }


    public void openBox(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Box items: " + "\n"+
                "--------------------------------------"+"\n"+
                items +
                "--------------------------------------" +'}';
    }
}
