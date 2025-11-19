package com.example.antsimulator;

public class Wall implements Entity{
    private int x;
    private int y;
    private World world;

    public Wall(World world, int x, int y){
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
        return "Wall";
    }
}
