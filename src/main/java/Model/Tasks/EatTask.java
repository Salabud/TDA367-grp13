package Model.Tasks;

import Model.Ants.Behavior.AntBehavior;
import Model.Ants.Movement.AntMovement;
import Model.Ants.Movement.NoMovement;
import Model.Ants.Movement.PathfindingMovement;
import Model.Ants.TaskPerformerAnt;
import Model.Datastructures.Position;

public class EatTask implements Task{
    private Position foodPosition;
    private boolean needNewPath;
    public EatTask(Position foodPosition) {
        this.foodPosition = foodPosition;
        this.needNewPath = true;
    }
    @Override
    public void execute(TaskPerformerAnt ant) {
        if (needNewPath) {
            ant.setMovement(new PathfindingMovement(
                    ant.getPosition(),
                    getTargetLocation(),
                    ant.getWorld().getTileGrid()
            ));
            needNewPath = false;
        }
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public Position getTargetLocation() {
        return foodPosition;
    }

    @Override
    public AntBehavior getBehaviorStrategy() {
        return null;
    }

    @Override
    public AntMovement getMovementStrategy() {
        return null;
    }

    @Override
    public boolean isComplete() {
        return false;
    }

    @Override
    public String getDescription() {
        return "ant is hungry, ant go eat";
    }

    @Override
    public boolean isAssigned() {
        return false;
    }

    @Override
    public void setAssigned(boolean status) {

    }
}
