package com.example.antsimulator;

public class Food implements Entity{
    private int x;
    private int y;
    private final World world;

    public Food(int x, int y, World world){
        this.x = x;
        this.y = y;
        this.world = world;
    }

    @Override
    public void update() {
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public String getType() {
        return "Food";
    }
}
