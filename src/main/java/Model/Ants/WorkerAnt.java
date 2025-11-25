package Model.Ants;

import java.util.List;

import Model.TaskPerformer;
import Model.Ants.Status.Status;
import Model.Tasks.Task;

public class WorkerAnt extends TaskPerformerAnt {
  
    @Override
    public void update() {
        if (currentTask != null) {
            currentTask.execute(this);
        }
    }
}
