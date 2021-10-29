package com.company.player;

public class Player  {

    private String Name;
    private int damage = 60;
    private int defence = 60;
    private int boostedHP = 500;
    private int baseHP = 500;
    private int gold = 0;
    private int experience = 0;
    private int lvl = 0;
    private int lvlgate = 450;
    private Inventory inventory;
    private EquippedItems equippedItems;


    public Player(String name) {
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

    public int getBoostedHP() {
        return boostedHP;
    }

    public void setBoostedHP(int boostedHP) {
        this.boostedHP = boostedHP;
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

    public int getBaseHP() {
        return baseHP;
    }

    public void setBaseHP(int baseHP) {
        this.baseHP = baseHP;
    }
    /*
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

     */

    @Override
    public String toString() {
        return "Character :: " +
                "Name = '" + Name + '\'' +
                ", Damage = " + damage +
                ", Defence = " + defence +
                ", GOLD :: " + gold +
                ", HP :: " + baseHP + "/" + boostedHP +
                ", EXP :: " + experience + "/" + lvlgate +
                ", LVL." + lvl;

    }
}
