package com.example.spacechallenge_java;

import java.util.Random;

public class U1 extends Rocket{

    public U1 (){
        cost = 100;
        weight = 10000;
        weightInclCargo = weight;
        maxWeight = 18000;
        chanceOfLaunchExplosion = 0.0;
        chanceOfLandingCrash = 0.0;
    }

    @Override
    public boolean launch(){
        this.chanceOfLaunchExplosion = 5.0 * (this.weightInclCargo - this.weight) / (this.maxWeight - this.weight);
        return this.chanceOfLaunchExplosion <= new Random().nextInt(100) + 1;
    }

    @Override
    public boolean land(){
        this.chanceOfLandingCrash = 1.0 * (this.weightInclCargo - this.weight) / (this.maxWeight - this.weight);
        return this.chanceOfLandingCrash <= new Random().nextInt(100) + 1;
    }
}
