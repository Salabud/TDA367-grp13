package Model.Ants;

import Model.Ants.State.AntState;
import Model.Tasks.Task;

public class TaskPerformerAnt extends Ant{
    protected Task currentTask;

    public boolean isAvailableForTask(Task task) {
        return true; // Simplified for this example
    }
    public void assignTask(Task task) {
        this.currentTask = task;
    }

    @Override
    public void update() {
        if (currentTask != null) {
            currentTask.execute(this);
        }
        super.update();
    }
}
