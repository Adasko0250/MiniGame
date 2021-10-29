package com.company.menagers;

import com.company.*;
import com.company.monsters.Monster;
import com.company.monsters.MonsterItems;
import com.company.player.EquippedItems;
import com.company.player.Inventory;
import com.company.player.Player;
import com.company.player.PlayerInterface;

import java.util.HashMap;
import java.util.Random;

public class PlayerMenager implements PlayerInterface {


    public PlayerMenager() {

    }

    // EQ
    public void equipItem(Item item, Inventory inventory, EquippedItems equippedItems, Player player) {
        equippedItems.addEqItem(item);
        player.setDamage(item.getDamage() + player.getDamage());
        player.setDefence(item.getDefence() + player.getDefence());
        inventory.removeItem(item);
    }

    public void unEquipItem(Item item, EquippedItems equippedItems, Inventory inventory, Player player) {
        equippedItems.removeEqItem(item);
        player.setDamage(player.getDamage() - item.getDamage());
        player.setDefence(player.getDefence() - item.getDefence());
        inventory.addItem(item);
    }

    // Loot
    public void openMonsterLoot(Monster monster) {
        MonsterItems loot = monster.getMonsterloot();
        if (loot == null) {
            System.out.println("EMPTY LOOT ");
        } else
            System.out.println(loot);

    }

    public void takeAllLoot(Monster monster, Inventory inventory) {
        MonsterItems loot = monster.getMonsterloot();
        for (Item i : loot.getMonsterItems()) {
            inventory.addItem(i);
        }
        loot.removeAllItems();
    }

    public void takeLoot(Monster monster, Inventory inventory, int position, Player player) {
        MonsterItems loot = monster.getMonsterloot();
        if (loot.getMonsterItems().get(position).getName().equals("Gold x")) {
            int i = loot.getMonsterItems().get(position).getValue();
            player.setGold(player.getGold() + i);
            inventory.removeItem(loot.getMonsterItems().get(position));
        } else
            inventory.addItem(loot.getMonsterItems().get(position));
        loot.removeItem(monster.getMonsterloot().getMonsterItems().get(position));
    }

    // Attack
    public void checkHit(Monster monster, Player player) {
        Random random = new Random();
        int num = random.nextInt(6) + 1;
        switch (num) {
            case 1, 2, 3 -> missAttack(player);
            case 4, 5 -> attack(monster, player);
            case 6 -> criticalAttack(monster, player);
            default -> throw new IllegalStateException("Unexpected value: " + num);
        }
    }

    private void attack(Monster monster, Player player) {
        int charDEF = monster.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (player.getDamage() * check);
        int dmg = (player.getDamage() - defMod);
        if (dmg >= monster.getHP()) {
            monster.setHP(0);
            player.setExperience(player.getExperience() + monster.getExperience());
            //checkLevelUp();
            checkLvL(player);
            System.out.println(player.getName() + " hit " + monster.getName() + " for " + dmg + " HP and kill " + monster.getName() + "." + player.getName() + " gain " + monster.getExperience() + " exp.");
        } else {
            System.out.println(player.getName() + " hit " + monster.getName() + " for " + dmg + " HP.");
            monster.setHP(monster.getHP() - dmg);
        }
    }

    private void criticalAttack(Monster monster, Player player) {
        int charDEF = monster.getDefence();
        double check = checkDefMod(charDEF);
        int defMod = (int) (player.getDamage() * check);
        int dmg = ((player.getDamage() * 2) - defMod);
        if (dmg >= monster.getHP()) {
            monster.setHP(0);
            player.setExperience(player.getExperience() + monster.getExperience());
            //checkLevelUp();
            checkLvL(player);
            System.out.println(player.getName() + " critical hit " + monster.getName() + " for " + dmg + " HP and kill " + monster.getName() + "." + player.getName() + " gain " + monster.getExperience() + " exp.");
        } else {
            System.out.println(player.getName() + " critical hit " + monster.getName() + " for " + dmg + " HP.");
            monster.setHP(monster.getHP() - dmg);
        }
    }

    private void missAttack(Player player) {
        System.out.println(player.getName() + " miss attack ! ");
    }

    // Helpers
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

    public void checkLvL(Player player) {
        HashMap<Integer, Integer> levelUp = lvlList();
        HashMap<Integer, Integer> hpBoost = hpBoost();

        if (player.getExperience() >= levelUp.get(1) && player.getExperience() < levelUp.get(2)) {
            player.setLvl(1);
            player.setLvlGate(levelUp.get(2));
            if (player.getBoostedHP() == 520) {

            } else {
                player.setBoostedHP(player.getBoostedHP() + hpBoost.get(1));
                player.setBaseHP(player.getBoostedHP());
            }

        }
        if (player.getExperience() >= levelUp.get(2) && player.getExperience() < levelUp.get(3)) {
            player.setLvl(2);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(2));
            player.setLvlGate(levelUp.get(3));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(3) && player.getExperience() < levelUp.get(4)) {
            player.setLvl(3);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(3));
            player.setLvlGate(levelUp.get(4));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(4) && player.getExperience() < levelUp.get(5)) {
            player.setLvl(4);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(5));
            player.setLvlGate(levelUp.get(5));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(5) && player.getExperience() < levelUp.get(6)) {
            player.setLvl(5);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(5));
            player.setLvlGate(levelUp.get(6));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(6) && player.getExperience() < levelUp.get(7)) {
            player.setLvl(6);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(6));
            player.setLvlGate(levelUp.get(7));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(7) && player.getExperience() < levelUp.get(8)) {
            player.setLvl(7);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(7));
            player.setLvlGate(levelUp.get(8));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(8) && player.getExperience() < levelUp.get(9)) {
            player.setLvl(8);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(8));
            player.setLvlGate(levelUp.get(9));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(9) && player.getExperience() < levelUp.get(10)) {
            player.setLvl(9);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(9));
            player.setLvlGate(levelUp.get(10));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(10) && player.getExperience() < levelUp.get(11)) {
            player.setLvl(10);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(10));
            player.setLvlGate(levelUp.get(11));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(11) && player.getExperience() < levelUp.get(12)) {
            player.setLvl(11);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(11));
            player.setLvlGate(levelUp.get(12));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(12) && player.getExperience() < levelUp.get(13)) {
            player.setLvl(12);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(12));
            player.setLvlGate(levelUp.get(13));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(13) && player.getExperience() < levelUp.get(14)) {
            player.setLvl(13);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(13));
            player.setLvlGate(levelUp.get(14));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(14) && player.getExperience() < levelUp.get(15)) {
            player.setLvl(14);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(14));
            player.setLvlGate(levelUp.get(15));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(15) && player.getExperience() < levelUp.get(16)) {
            player.setLvl(15);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(15));
            player.setLvlGate(levelUp.get(16));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(16) && player.getExperience() < levelUp.get(17)) {
            player.setLvl(16);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(16));
            player.setLvlGate(levelUp.get(17));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(17) && player.getExperience() < levelUp.get(18)) {
            player.setLvl(17);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(17));
            player.setLvlGate(levelUp.get(18));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(18) && player.getExperience() < levelUp.get(19)) {
            player.setLvl(18);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(18));
            player.setLvlGate(levelUp.get(19));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(19) && player.getExperience() < levelUp.get(20)) {
            player.setLvl(19);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(19));
            player.setLvlGate(levelUp.get(20));
            player.setBaseHP(player.getBoostedHP());
        }
        if (player.getExperience() >= levelUp.get(20)) {
            player.setLvl(20);
            player.setBoostedHP(player.getBoostedHP() + hpBoost.get(20));
            player.setLvlGate(levelUp.get(20));
            player.setBaseHP(player.getBoostedHP());
        }
    }

    private double checkDefMod(int specMod) {
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
    // Helpers2
    /*
    void checkLevelUp(Player player) {
        Optional<Level> levelOptional = findLevelByExp();
        if (levelOptional.isPresent()) {
            Level level = levelOptional.get();
            setHpOnCheck(level);
            if (level.getLvl() > player.getLvl()) {
                if (player.getExperience() > LevelDataStore.FIRST_LEVEL_EXPERIENCE) {
                    player.setLvl(level.getLvl());
                    player.setLvlGate(level.getRange().getUpperBound());
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

     */
}
