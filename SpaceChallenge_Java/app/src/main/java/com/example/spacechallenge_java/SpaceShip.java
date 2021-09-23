package com.example.spacechallenge_java;

public interface SpaceShip {

    boolean launch();
    boolean land();
    boolean canCarry(Item item);
    void carry(Item item);
}

