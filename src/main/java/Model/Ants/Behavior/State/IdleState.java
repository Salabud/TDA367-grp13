package Model.Ants.Behavior.State;

import Model.Ants.Ant;

public class IdleState implements AntState{
    protected Ant ant;
    public IdleState(Ant ant) {
        this.ant = ant;
    }
    @Override
    public void update() {
        ant.setAge(ant.getAge() + 1);
    }
}
