package com.example.spacechallenge_java;

public class U2 extends Rocket{

    public U2 (){
        cost = 120;
        weight = 18000;
        weightInclCargo = weight;
        maxWeight = 29000;
        chanceOfLaunchExplosion = 0.0;
        chanceOfLandingCrash = 0.0;
    }

    public boolean launch() {
        int random = (int)(Math.random() * 100 + 1);
        this.chanceOfLaunchExplosion = 4.0 * (this.weightInclCargo - this.weight) / (this.maxWeight - this.weight);

        return this.chanceOfLaunchExplosion <= random;
    }

    public boolean land() {
        int random = (int)(Math.random() * 100 + 1);
        this.chanceOfLandingCrash = 8.0 * (this.weightInclCargo - this.weight) / (this.maxWeight - this.weight);

        return this.chanceOfLandingCrash <= random;
    }
}

