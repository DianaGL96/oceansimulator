package ru.diana.oceansimulator.entity;

public class KillerWhale {
    //hp: 100
    //energy: 100
    //cf: 2,5


    private int healf = 100;
    private int energy = 100;
    private float factor = 2.5F;

    public void setHealf(int healf) {

        this.healf = healf;
    }
    public int getHealf() {

        return this.healf;
    }
    public void setEnergy(int energy) {

        this.energy = energy;
    }
    public int getEnergy() {

        return this.energy;
    }
    public double getFactor() {

        return this.factor;
    }
}
