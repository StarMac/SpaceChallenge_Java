package com.example.spacechallenge_java;

import android.content.Context;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    final private Context context;

    public Simulation(Context context) {
        this.context = context;
    }

    public ArrayList<Item> loadItems(String fileName) throws IOException{
        ArrayList<Item> allItemsList = new ArrayList();

        Scanner fileScanner = new Scanner(context.getAssets().open(fileName));

        while (fileScanner.hasNextLine()) {
            String[] tokens = fileScanner.nextLine().split("=");
            Item item = new Item(tokens[0],Integer.parseInt(tokens[tokens.length-1]));
            allItemsList.add(item);
        }
        return allItemsList;
    }

    public ArrayList<Rocket> loadU1(ArrayList<Item> allItemsList) {
        ArrayList<Rocket> rocketsU1List = new ArrayList<>();
        Rocket rocketU1 = new U1();

        for (Item item : allItemsList) {

            if (!rocketU1.canCarry(item)) {
                rocketsU1List.add(rocketU1);
                rocketU1 = new U1();
            }
            rocketU1.carry(item);
        }
        rocketsU1List.add(rocketU1);

        return rocketsU1List;
    }

    public ArrayList<Rocket> loadU2(ArrayList<Item> allItemsList) {

        ArrayList<Rocket> rocketsU2List = new ArrayList();
        Rocket rocketU2 = new U2();

        for (Item item : allItemsList) {

            if (!rocketU2.canCarry(item)) {
                rocketsU2List.add(rocketU2);
                rocketU2 = new U1();
            }
            rocketU2.carry(item);
        }
        rocketsU2List.add(rocketU2);

        return rocketsU2List;
    }

    public int runSimulation(ArrayList<Rocket> rockets) {

        int totalBudget = 0;

        for (Rocket rocket : rockets) {
            totalBudget += rocket.getCost();

            while (!rocket.launch() || !rocket.land()){
                totalBudget += rocket.getCost();
            }
        }
        return totalBudget;
    }

}
