package com.company.player;

import com.company.level.Level;
import com.company.level.LevelDataStore;
import com.company.menagers.PlayerMenager;


import java.util.HashMap;
import java.util.Optional;

public class Player extends PlayerMenager {

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


    public Player(String name) {
        this.Name = name;
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

    public void setLvlGate(int lvlgate) {
        this.lvlgate = lvlgate;
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

    void checkLevelUp() {
        Optional<Level> levelOptional = findLevelByExp();
        if (levelOptional.isPresent()) {
            Level level = levelOptional.get();
            setHpOnCheck(level);
            if (level.getLvl() > this.lvl) {
                if (this.experience > LevelDataStore.FIRST_LEVEL_EXPERIENCE) {
                    setLvl(level.getLvl());
                    setLvlGate(level.getRange().getUpperBound());
                }
            }
        }
    }

    private Optional<Level> findLevelByExp() {
        Optional<Level> first = LevelDataStore.Levels.stream()
                .filter(lvl ->
                        lvl.getRange().getLowerBound() < this.experience &&
                                lvl.getRange().getUpperBound() > this.experience)
                .findFirst();
        return first;
    }

    private void setHpOnCheck(Level level) {
        int levelDifference = level.getLvl() - this.lvl;
        if (levelDifference >= 1) {
            for (int i = 0; i < levelDifference; i++) {
                Level lvl = LevelDataStore.Levels.get(level.getLvl() - i - 1);
                setHP(lvl.getHpBoost() + this.HP);
            }
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
