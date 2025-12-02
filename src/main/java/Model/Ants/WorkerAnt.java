package Model.Ants;

import java.util.List;

import Model.Colony.ColonyMediator;
import Model.Datastructures.Position;
import Model.EntityType;
import Model.Ants.Status.Status;
import Model.Tasks.Task;
import Model.World.World;
import org.json.JSONObject;

/** Represents a worker ant in the simulation. */
public class WorkerAnt extends TaskPerformerAnt {

    public WorkerAnt(EntityType type, World world, int colonyId, int x, int y, ColonyMediator mediator){
        this.type = EntityType.WORKER_ANT;
        this.world = world;
        this.colonyId = colonyId;
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
        //TODO implement after refactoring of Entity
        return obj;
    }
}
