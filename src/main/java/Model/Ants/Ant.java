package Model.Ants;

import Model.Ants.Behavior.State.AntState;
import Model.Colony.AntColony;
import Model.Colony.ColonyMediator;
import Model.Entity;

public abstract class Ant extends Entity {
    int colonyId;
    String nickname;
    AntColony colony;
    ColonyMediator mediator;
    AntState state;
    public void suggestTask(){
    }

    @Override
    public void update() {
        state.update();
    }
}
