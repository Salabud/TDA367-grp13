package model.ants;

import model.AntType;
import model.ants.status.Status;
import model.BeingType;
import model.Carryable;
import model.colony.events.HungryEvent;
import model.datastructures.Position;
import model.EntityType;
import model.world.World;

import java.util.ArrayList;
import java.util.List;

/** Represents a larva in the simulation. */
public class Larva extends Ant implements Carryable {
    private float TRANSFORM_AGE = 5*60F; // In seconds
    private static final float HUNGER_THRESHOLD = 30f; // Report hunger when below this level
    private boolean hasReportedHunger = false; // Prevent spamming reports

    public Larva(World world, int colonyId, int x, int y){
        this.position = new Position(x,y);
        type = EntityType.BEING;
        beingType = BeingType.ANT;
        antType = AntType.LARVA;
        this.statuses = new ArrayList<>();
        this.world = world;
    }
    public Larva(World world, int colonyId, int x, int y, int age,
                 String nickname, float health, float maxHealth, float hunger,
                 float maxHunger, int movementInterval, List<Status> statuses){
        position = new Position(x,y);
    }

    @Override
    public void moveTo(Position position) {
        this.position = position;
    }

    //TODO: Implement becomeWorker
    public void becomeWorker(){
        System.out.println("becoming worker");
    }

    @Override
    public void update(){
        // Broadcast hunger event (hasReportedHunger prevents spamming)
        if (getHunger() < HUNGER_THRESHOLD && !hasReportedHunger) {
            broadcastEvent(new HungryEvent(this));
            hasReportedHunger = true;
        }
        
        // Reset the flag once hunger is restored
        if (getHunger() >= HUNGER_THRESHOLD && hasReportedHunger) {
            hasReportedHunger = false;
        }
        
        if (this.getAge() > TRANSFORM_AGE){
            becomeWorker();
        }
        super.update();
    }
}
