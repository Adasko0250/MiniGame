package com.company.monsters;

public class Monster {

    private String Name;
    private int damage;
    private int defence;
    private int HP;
    private int experience;
    private MonsterItems monsterloot;

    public Monster(String name, int damage, int defence, int HP, int experience) {
        Name = name;
        this.damage = damage;
        this.defence = defence;
        this.HP = HP;
        this.experience = experience;
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

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public MonsterItems getMonsterloot() {
        return monsterloot;
    }

    public void setMonsterloot(MonsterItems monsterloot) {
        this.monsterloot = monsterloot;
    }


    @Override
    public String toString() {
        return "Monster :: " +
                "Name ='" + Name + '\'' +
                ", Damage = " + damage +
                ", Defence = " + defence +
                ", HP :: " + HP +
                ", EXP ::" + experience;
    }
}
