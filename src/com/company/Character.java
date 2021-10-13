package com.company;


import java.util.HashMap;
import java.util.Random;

public class Character {

    private String Name;
    private int damage = 25;
    private int defence = 60;
    private int HP = 500;
    private int gold = 0;
    private int experience = 0;
    private int lvl = 0;
    private int lvlgate = 450;
    private Inventory inventory;
    private EquippedItems equippedItems;


    public Character(String name) {
        Name = name;
    }

    public EquippedItems getEquippedItems() {
        return equippedItems;
    }

    public void setEquippedItems(EquippedItems equippedItems) {
        this.equippedItems = equippedItems;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public int getLvlgate() {
        return lvlgate;
    }

    public void setLvlgate(int lvlgate) {
        this.lvlgate = lvlgate;
    }

    // move Item - from Inventory -> to EquippedItems
    public void equipItem(Item item, Inventory inventory, EquippedItems equippedItems) {
        equippedItems.addEqItem(item);
        setDamage(item.getDamage() + getDamage());
        setDefence(item.getDefence() + getDefence());
        inventory.removeItem(item);
    }

    // move Item - from EquippedItems -> to Inventory
    public void unEquipItem(Item item, EquippedItems equippedItems, Inventory inventory) {
        equippedItems.removeEqItem(item);
        setDamage(getDamage() - item.getDamage());
        setDefence(getDefence() - item.getDefence());
        inventory.addItem(item);
    }

    public void checkHit(Monster monster) {
        Random random = new Random();
        int num = random.nextInt(6) + 1;
        switch (num) {
            case 1, 2, 3 -> missAttack();
            case 4, 5 -> attack(monster);
            case 6 -> criticalAttack(monster);
            default -> throw new IllegalStateException("Unexpected value: " + num);
        }
    }

    public double checkDefMod(int specMod) {
        return switch (specMod) {
            case 10, 11, 12, 13, 14, 15, 16, 17, 18, 19 -> 0.1;
            case 20, 21, 22, 23, 24, 25, 26, 27, 28, 29 -> 0.2;
            case 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 -> 0.3;
            case 40, 41, 42, 43, 44, 45, 46, 47, 48, 49 -> 0.4;
            case 50, 51, 52, 53, 54, 55, 56, 57, 58, 59 -> 0.5;
            case 60, 61, 62, 63, 64, 65, 66, 67, 68, 69 -> 0.6;
            default -> 0;
        };
    }

    public void attack(Monster monster) {
        int charDEF = monster.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (getDamage() * check);
        int dmg = (getDamage() - defMod);
        if (dmg >= monster.getHP()) {
            monster.setHP(0);
            setExperience(getExperience() + monster.getExperience());
            checkLvL();
            System.out.println(getName() + " hit " + monster.getName() + " for " + dmg + " HP and kill " + monster.getName() + "."+ getName() +" gain " + monster.getExperience() + " exp.");
        } else {
            System.out.println(getName() + " hit " + monster.getName() + " for " + dmg + " HP.");
            monster.setHP(monster.getHP() - dmg);
        }
    }

    public void criticalAttack(Monster monster) {
        int charDEF = monster.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (getDamage() * check);
        int dmg = ((getDamage() * 2) - defMod);
        if (dmg >= monster.getHP()) {
            monster.setHP(0);
            setExperience(getExperience() + monster.getExperience());
            checkLvL();
            System.out.println(getName() + " critical hit " + monster.getName() + " for " + dmg + " HP and kill " + monster.getName()+ "."+ getName() +" gain " + monster.getExperience() + " exp.");
        } else {
            System.out.println(getName() + " critical hit " + monster.getName() + " for " + dmg + " HP.");
            monster.setHP(monster.getHP() - dmg);
        }
    }

    public void missAttack() {
        System.out.println(getName() + " miss attack ! ");
    }

    public void openMonsterLoot(Monster monster) {
        MonsterLoot loot = monster.getMonsterloot();
        if (loot == null) {
            System.out.println("EMPTY LOOT ");
        } else
            System.out.println(loot);

    }

    public void takeAllLoot(Monster monster, Inventory inventory) {
        MonsterLoot loot = monster.getMonsterloot();
        for (Item i : loot.getMonsterloot()) {
            inventory.addItem(i);
        }
        loot.removeAllItems();
    }

    public void takeLoot(Monster monster, Inventory inventory, int position) {
        MonsterLoot loot = monster.getMonsterloot();
        if (loot.getMonsterloot().get(position).getName().equals("Gold x")) {
            int i = loot.getMonsterloot().get(position).getValue();
            setGold(getGold() + i);
            inventory.removeItem(loot.getMonsterloot().get(position));
        } else
            inventory.addItem(loot.getMonsterloot().get(position));
        loot.removeItem(monster.getMonsterloot().getMonsterloot().get(position));
    }

    public HashMap<Integer, Integer> hpBoost() {
        HashMap<Integer, Integer> gainlvl = new HashMap<>();
        for (int i = 10; i < 100; i++) {
            for (int j = 1; j <= 20; j++) {
                i += ((i + (i * 2)) / (j + 2));
                gainlvl.put(j, i);
            }
        }
        return gainlvl;
    }

    public HashMap<Integer, Integer> lvlList() {
        HashMap<Integer, Integer> gainlvl = new HashMap<>();
        for (int i = 100; i < 1000; i++) {
            for (int j = 1; j <= 20; j++) {
                i += ((i + (i * 6)) / (j + 1));
                gainlvl.put(j, i);
            }
        }
        return gainlvl;
    }

    public void checkLvL() {
        HashMap<Integer, Integer> levelUp = lvlList();
        HashMap<Integer, Integer> hpBoost = hpBoost();

        if (getExperience() >= levelUp.get(1) && getExperience() < levelUp.get(2)) {
            setLvl(1);
            setHP(getHP() + hpBoost.get(1));
            setLvlgate(levelUp.get(2));
            setExperience(getExperience()-levelUp.get(1));
        }
        if (getExperience() >= levelUp.get(2) && getExperience() < levelUp.get(3)) {
            setLvl(2);
            setHP(getHP() + hpBoost.get(2));
            setLvlgate(levelUp.get(3));
            setExperience(getExperience()-levelUp.get(2));
        }
        if (getExperience() >= levelUp.get(3) && getExperience() < levelUp.get(4)) {
            setLvl(3);
            setHP(getHP() + hpBoost.get(3));
            setLvlgate(levelUp.get(4));
            setExperience(getExperience()-levelUp.get(3));
        }
        if (getExperience() >= levelUp.get(4) && getExperience() < levelUp.get(5)) {
            setLvl(4);
            setHP(getHP() + hpBoost.get(4));
        }
        if (getExperience() >= levelUp.get(5) && getExperience() < levelUp.get(6)) {
            setLvl(5);
            setHP(getHP() + hpBoost.get(5));
        }
        if (getExperience() >= levelUp.get(6)) {
            setLvl(6);
            setHP(getHP() + hpBoost.get(6));
        }
        if (getExperience() >= levelUp.get(7)) {
            setLvl(7);
            setHP(getHP() + hpBoost.get(7));
        }
        if (getExperience() >= levelUp.get(8)) {
            setLvl(8);
            setHP(getHP() + hpBoost.get(8));
        }
        if (getExperience() >= levelUp.get(9)) {
            setLvl(9);
            setHP(getHP() + hpBoost.get(9));
        }
        if (getExperience() >= levelUp.get(10)) {
            setLvl(10);
            setHP(getHP() + hpBoost.get(10));
        }
        if (getExperience() >= levelUp.get(11)) {
            setLvl(11);
            setHP(getHP() + hpBoost.get(11));
        }
        if (getExperience() >= levelUp.get(12)) {
            setLvl(12);
            setHP(getHP() + hpBoost.get(12));
        }
        if (getExperience() >= levelUp.get(13)) {
            setLvl(13);
            setHP(getHP() + hpBoost.get(13));
        }
        if (getExperience() >= levelUp.get(14)) {
            setLvl(14);
            setHP(getHP() + hpBoost.get(14));
        }
        if (getExperience() >= levelUp.get(15)) {
            setLvl(15);
            setHP(getHP() + hpBoost.get(15));
        }
        if (getExperience() >= levelUp.get(16)) {
            setLvl(16);
            setHP(getHP() + hpBoost.get(16));
        }
        if (getExperience() >= levelUp.get(17)) {
            setLvl(17);
            setHP(getHP() + hpBoost.get(17));
        }
        if (getExperience() >= levelUp.get(18)) {
            setLvl(18);
            setHP(getHP() + hpBoost.get(18));
        }
        if (getExperience() >= levelUp.get(19)) {
            setLvl(19);
            setHP(getHP() + hpBoost.get(19));
        }
        if (getExperience() >= levelUp.get(20)) {
            setLvl(20);
            setHP(getHP() + hpBoost.get(20));
        }


    }


    public void test1() {
        for (int i = 10; i < 100; i++) {
            for (int j = 1; j <= 20; j++) {
                i += ((i + (i * 2)) / (j + 2));
                System.out.println(i);
            }
        }

    }


    public void test2(){


    }


    @Override
    public String toString() {
        return "Character :: " +
                "Name = '" + Name + '\'' +
                ", Damage = " + damage +
                ", Defence = " + defence +
                ", GOLD :: " + gold +
                ", HP :: " + HP +
                ", EXP :: " + experience + "/" + lvlgate +
                ", LVL." + lvl;

    }
}
