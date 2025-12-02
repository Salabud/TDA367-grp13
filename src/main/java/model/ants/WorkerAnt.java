package Model.Ants;

import java.util.List;

import Model.AntType;
import Model.BeingType;
import Model.Colony.ColonyMediator;
import Model.Datastructures.Position;
import Model.EntityType;
import Model.Ants.Status.Status;
import Model.Tasks.Task;
import Model.World.World;
import org.json.JSONObject;

/** Represents a worker ant in the simulation. */
public class WorkerAnt extends TaskPerformerAnt {

    public WorkerAnt(World world, int colonyId, int x, int y, ColonyMediator mediator){
        this.type = EntityType.BEING;
        this.beingType = BeingType.ANT;
        this.antType = AntType.WORKER_ANT;
        this.world = world;
        this.colonyId = colonyId; //TODO Should this be in Ant.java?
        this.position = new Position(x,y);
        this.mediator = mediator;
    }

    @Override
    public void update() {
        //System.out.println("workerAnt update");
        super.update();
    }


    /**
     * Create a JSON Object of the entity
     * @return
     */
    @Override
    public JSONObject toJSON(){
        JSONObject obj = super.toJSON();
        obj.put("colonyId", colonyId);
        //TODO
        return obj;
    }
}
