package com.example.antsimulator;

public class SimulationHandler {
    private World world;


    SimulationHandler(World world){
        this.world = world;


        for(int i = 0; i < 100; i++){
            for(int y = 12; y < 100; y++) {
                world.addEntity(new Wall(world, i,y), true);
            }
        }
        makeChamber(40,30,20,12);
        makeChamber(70,33,25,11);
        makeChamber(10,37,22,16);
        makeSquare(25,39, 20, 3);
        makeSquare(55,35, 20, 3);
        makeSquare(45,12, 3, 20);
        for(int x = 10; x < 13; x++){
            world.addEntity(new Food(x,51, world),true);
        }
        for(int x = 10; x < 19; x++){
            world.addEntity(new Food(x,52, world),true);
        }
        for(int x = 70; x < 79; x++){
            world.addEntity(new Larva(x,43, world),true);
        }
        for(int x = 82; x < 85; x++){
            world.addEntity(new Larva(x,43, world),true);
        }


    }
    private void makeChamber(int x, int y, int width, int height){
        for(int a = x; a < x+width; a++){
            for(int b = y; b < y+height; b++) {
                world.removeEntity(a,b);
                if (a%2 == 1) world.addEntity(new Ant(world, a, b), true);
            }
        }
        for(int a = x-2; a < x+width+2; a++){
            for(int b = y+2; b < y+height-2; b++) {
                world.removeEntity(a,b);
            }
        }
    }
    private void makeSquare(int x, int y, int width, int height){
        for(int a = x; a < x+width; a++){
            for(int b = y; b < y+height; b++) {
                world.removeEntity(a,b);
            }
        }
    }


    public World getWorld(){
        return world;
    }
}
