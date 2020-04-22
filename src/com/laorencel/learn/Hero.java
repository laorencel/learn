package com.laorencel.learn;

public class Hero implements Comparable<Hero> {
    public String name;
    public int damage;
    public float hp;

    public Hero() {
    }

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, int damage, float hp) {
        this.name = name;
        this.damage = damage;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getHp() {
        return hp;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    @Override
    public int compareTo(Hero hero) {
        return this.damage < hero.damage ? 1 : -1;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                ", damage=" + damage +
                ", hp=" + hp +
                '}';
    }

    public boolean isDead() {
        return false;
    }

    public void attackHero(Hero hero) {

    }
}
