package model.ants.status;

import model.ants.Ant;
import model.tasks.FeedBeingTask;
import model.tasks.Task;

public class Poisoned implements Status {

    private final float poisonDamagePerTick;
    private final float poisonHungerPerTick;

    public Poisoned() {
        this.poisonDamagePerTick = 0.3F;
        this.poisonHungerPerTick = 0.2F;
     }

    public void applyStatusEffect(Ant ant) {
        ant.healthTick(-poisonDamagePerTick);
        ant.hungerTick(poisonHungerPerTick);
    }  
    @Override
    public boolean allowsTask(Task task) {
        return !(task instanceof FeedBeingTask);
    }
}
