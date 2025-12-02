package model.ants;

import Model.AntType;
import Model.Ants.Behavior.AntBehavior;
import Model.Ants.Movement.AntMovement;
import Model.Ants.State.AntState;
import Model.Ants.Status.Status;
import Model.Being;
import Model.BeingType;
import Model.Colony.AntColony;
import Model.Colony.ColonyMediator;
import Model.Entity;
import org.json.JSONObject;

import java.util.List;

/** Abstract class representing an ant in the simulation. */
public abstract class Ant extends Being {
    protected int colonyId;
    protected String nickname;
    protected AntColony colony;
    protected ColonyMediator mediator;
    protected List<Status> statuses;
    protected AntState state;
    protected AntBehavior behavior;
    protected AntMovement movement;
    protected AntType antType;


    public AntMovement getMovement() {
        return movement;
    }

    /**
     * Sets the movement strategy for the ant.
     * @param movement : The movement strategy to set.
     */
    public void setMovement(AntMovement movement) {
        this.movement = movement;
    }

    @Override
    public void update() {
        //System.out.println("ant update");
        this.movement.move(this);
        super.update();
    }

    public AntType getAntType(){
        return antType;
    }

    /**
     * Create a JSON Object of the entity
     * @return
     */
    @Override
    public JSONObject toJSON(){
        JSONObject obj = super.toJSON();
        obj.put("nickname", nickname);
        obj.put("antType", antType);
        //TODO implement after refactoring of Entity
        return obj;
    }

}
