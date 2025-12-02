package model.ants;

import Model.AntType;
import Model.Ants.Status.Status;
import Model.BeingType;
import Model.Carryable;
import Model.Colony.ColonyMediator;
import Model.Datastructures.Position;
import Model.EntityType;
import Model.World.World;

import java.util.List;

/** Represents a larva in the simulation. */
public class Larva extends Ant implements Carryable {
    public Larva(World world, int colonyId, int x, int y, ColonyMediator mediator){
        this.position = new Position(x,y);
        type = EntityType.BEING;
        beingType = BeingType.ANT;
        antType = AntType.LARVA;

    }
    public Larva(World world, int colonyId, int x, int y, int age,
                 String nickname, ColonyMediator mediator, float health, float maxHealth, float hunger,
                 float maxHunger, int movementInterval, List<Status> statuses){
        position = new Position(x,y);
        type = EntityType.LARVA;
    }

    @Override
    public void move(Position position) {

    }


    public void becomeWorker(){

    }
}
