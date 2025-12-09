package model.ants;

import model.AntType;
import model.BeingType;
import model.ants.behavior.ScoutBehavior;
import model.colony.events.HungryEvent;
import model.datastructures.Position;
import model.EntityType;
import model.ants.movement.RandomMovement;
import model.ants.state.AntState;
import model.colony.tasks.BirthTask;
import model.colony.tasks.EatTask;
import model.colony.tasks.Task;
import model.world.World;
import org.json.JSONObject;

import java.util.ArrayList;

/** Represents a worker ant in the simulation. */
public class WorkerAnt extends TaskPerformerAnt {
    private static final float HUNGER_THRESHOLD = 30f;
    private boolean hasReportedHunger = false;

    public WorkerAnt(World world, int colonyId, int x, int y){
        this.type = EntityType.BEING;
        this.beingType = BeingType.ANT;
        this.antType = AntType.WORKER_ANT;
        this.world = world;
        this.colonyId = colonyId;
        this.position = new Position(x,y);
        this.statuses = new ArrayList<>();
    }

    @Override
    public void update() {
        // Broadcast hunger event (hasReportedHunger prevents spamming)
        if (getHunger() < HUNGER_THRESHOLD && getState() != AntState.FEEDING 
                && !(currentTask instanceof EatTask) && !hasReportedHunger) {
            broadcastEvent(new HungryEvent(this));
            hasReportedHunger = true;
        }
        
        // Reset the flag once hunger is restored
        if (getHunger() >= HUNGER_THRESHOLD) {
            hasReportedHunger = false;
        }
        
        if (currentTask == null && this.state == AntState.IDLE && !(this.movement instanceof RandomMovement)) {
            this.behavior = new ScoutBehavior();
            this.movement = new RandomMovement(this, world.getTileGrid());
        }
        super.update();
    }

    @Override
    protected boolean isTaskTypeAllowed(Task task) {
        // Workers cannot give birth
        if (task instanceof BirthTask) {
            return false;
        }
        return true;
    }

    /**
     * Create a JSON Object of the entity
     * @return
     */
    @Override
    public JSONObject toJSON(){
        JSONObject obj = super.toJSON();
        //TODO
        return obj;
    }
}
