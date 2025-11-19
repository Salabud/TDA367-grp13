package com.example.antsimulator;

public class SimulationHandler {
    private World world;


    SimulationHandler(World world){
        this.world = world;

        for(int i = 0; i < 30; i++){
            world.addEntity(new Ant(world,i*2, 50));
            world.addEntity(new Ant(world,i*2, 51));
            world.addEntity(new Ant(world,i*2, 52));
        }

        for(int i = 0; i < 70; i++){
            world.addEntity(new Wall(world, 70,i));
            world.addEntity(new Wall(world, 71,i));
            world.addEntity(new Wall(world, 40,i));

        }

    }

    public World getWorld(){
        return world;
    }
}
