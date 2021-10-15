package com.company.level;

public class Level {

    private int hpBoost;
    private int lvl;
    private LevelRange range;

    public Level(int hpBoost, int lvl, LevelRange range) {
        this.hpBoost = hpBoost;
        this.lvl = lvl;
        this.range = range;
    }

    public int getHpBoost() {
        return hpBoost;
    }

    public void setHpBoost(int hpBoost) {
        this.hpBoost = hpBoost;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    public LevelRange getRange() {
        return range;
    }

    public void setRange(LevelRange range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Level{" +
                "hpBoost=" + hpBoost +
                ", lvl=" + lvl +
                ", range=" + range +
                '}';
    }
}
