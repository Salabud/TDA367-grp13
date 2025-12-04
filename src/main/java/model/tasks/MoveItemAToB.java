package model.tasks;

import model.Entity;
import model.EntityType;
import model.ants.Ant;
import model.ants.TaskPerformerAnt;
import model.ants.WorkerAnt;
import model.ants.behavior.AntBehavior;
import model.ants.movement.AntMovement;
import model.ants.movement.NoMovement;
import model.ants.movement.PathfindingMovement;
import model.ants.state.AntState;
import model.datastructures.Position;
import model.world.Item;
import model.world.MaterialType;

/**
 * A temporary task used for testing movement implementations.
 * Implements a simple carry behaviour: go to (5,5), pick up food there,
 * walk to (10,10) and drop it.
 */
public class MoveItemAToB extends Task{
    private Ant antAssigned;
    boolean isComplete = false;
    boolean isAssigned = false;
    int step = 1;
    Position itemPosition;
    Position endPosition;
    Entity entity;
    public MoveItemAToB(Entity entity, Position endPosition){
        super();
        this.itemPosition = entity.getPosition();
        this.endPosition = endPosition;
        this.entity = entity;
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public Position getTargetLocation() {
        return null;
    }


    public Position getitemPosition() {
        return this.itemPosition;  // food location created in World constructor
    }

    public AntBehavior getBehaviorStrategy() {
        return null;
    }

    public AntMovement getMovementStrategy() {
        return null;
    }

    @Override
    public boolean isComplete() {
        return isComplete;
    }

    @Override
    public void execute(TaskPerformerAnt ant) {

        switch(phase){
            case NOT_STARTED:
                ant.setState(AntState.MOVING);
                ant.setMovement(new PathfindingMovement(
                        ant.getPosition(),
                        getTargetLocation(),
                        ant.getWorld().getTileGrid()
                ));
                ant.setBehavior(null);
                setPhase(TaskPhase.MOVING_TO_TARGET);
                break;

            case MOVING_TO_TARGET:
                if (ant.getPosition().isAdjacentTo(itemPosition)){
                    ant.setState(AntState.WORKING);
                    ant.setMovement(new NoMovement());
                    setPhase(TaskPhase.RETURNING);
                    ant.attemptCarry(entity);
                }
                break;

            case RETURNING:
                ant.setState(AntState.MOVING);
                ant.setMovement(new PathfindingMovement(
                        ant.getPosition(),
                        endPosition,
                        ant.getWorld().getTileGrid()
                ));
                if (ant.getPosition().isAdjacentTo(itemPosition)){
                    setPhase(TaskPhase.COMPLETE);
                }
            case COMPLETE:
                break;
            default:
                break;
        }
    }
    @Override
    public String getDescription() {
        return "Carry food from (5,5) to (10,10)";
    }

    @Override
    public boolean isAssigned() {
        return isAssigned;
    }

    @Override
    public void setAssigned(boolean status) {
        this.isAssigned = status;
    }
}
