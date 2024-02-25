package ru.diana.oceansimulator.entity;

public class KillerWhale {
    private int health = 100;
    private int energy = 100;
    private float factor = 2.5F;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public int getEnergy() {
        return this.energy;
    }

    public float getFactor() {
        return this.factor;
    }
}
