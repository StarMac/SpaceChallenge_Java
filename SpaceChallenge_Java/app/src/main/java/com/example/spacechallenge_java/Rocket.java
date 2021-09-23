package com.example.spacechallenge_java;

public class Rocket implements SpaceShip{

    protected int cost;
    protected int weight;
    protected int weightInclCargo;
    protected int maxWeight;
    protected double chanceOfLaunchExplosion;
    protected double chanceOfLandingCrash;

    public boolean launch() {
        return true;
    }

    public boolean land() {
        return true;
    }

    public boolean canCarry(Item item) {
        return this.weightInclCargo + item.weight <= maxWeight;
    }

    public void carry(Item item) {
        this.weightInclCargo += item.weight;
    }

    protected int getCost() {
        return cost;
    }
}
