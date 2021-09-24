package com.example.spacechallenge_java;

import java.util.Random;

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
        this.chanceOfLaunchExplosion = 4.0 * (this.weightInclCargo - this.weight) / (this.maxWeight - this.weight);
        return this.chanceOfLaunchExplosion <= new Random().nextInt(100) + 1;
    }

    public boolean land() {
        this.chanceOfLandingCrash = 8.0 * (this.weightInclCargo - this.weight) / (this.maxWeight - this.weight);
        return this.chanceOfLandingCrash <= new Random().nextInt(100) + 1;
    }
}

