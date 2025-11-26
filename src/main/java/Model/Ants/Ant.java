package Model.Ants;

import Model.Ants.Behavior.AntBehavior;
import Model.Ants.Movement.AntMovement;
import Model.Ants.State.AntState;
import Model.Ants.Status.Status;
import Model.Colony.AntColony;
import Model.Colony.ColonyMediator;
import Model.Entity;

import java.util.List;

public abstract class Ant extends Entity {
    int colonyId;
    String nickname;
    AntColony colony;
    ColonyMediator mediator;
    List<Status> statuses;
    AntState state;
    AntBehavior behavior;
    AntMovement movement;
    

    @Override
    public void update() {}
}
