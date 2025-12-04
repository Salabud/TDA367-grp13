package model.ants;

import model.Carryable;
import model.datastructures.Position;
import model.tasks.EatTask;
import model.tasks.Task;

/** Abstract class for ants that can perform tasks. E.g. WorkerAnt, QueenAnt, (TODO: SoldierAnt)*/
public class TaskPerformerAnt extends Ant{
    protected Task currentTask;
    // "Inventory" that can hold 1 object.
    private Carryable carriedObject = null;

    /**
     * Checks if the ant is available to take on a new task.
     * @param task : The task to check.
     * @return True if the ant is available for the task, false otherwise.
     */
    public boolean isAvailableForTask(Task task) {
        return true; // Simplified for now, TODO: implement logic based on ant state, status, etc.
    }

    public void assignTask(Task task) {
        this.currentTask = task;
    }

    @Override
    public void update() {
        if(getHunger() < 30 && !(currentTask instanceof EatTask)){ //30 placeholder for now
            mediator.reportHungry(this);
        }
        if (currentTask != null) {
            currentTask.execute(this);
        }

        // If carrying something, place it at current position before moving
        // After super.update() moves the ant, the item will be one step behind
        // TODO: Check for Carrying status!
        if (carriedObject != null) {
            carriedObject.moveTo(new Position(getX(), getY()));
        }
        
        super.update();  // Handles movement, behavior, and hunger tick
    }

    public void attemptCarry(Carryable carryable) {
        if (this.position.isAdjacentTo(carryable.getPosition())){
            this.carriedObject = carryable;
        }
    }

    public Carryable getCarriedObject() {
        return this.carriedObject;
    }
    
    /**
     * Check if this ant is currently carrying something.
     */
    public boolean isCarrying() {
        return carriedObject != null;
    }
    
    /**
     * Drop the carried object at the ant's current position.
     */
    public void dropCarriedObject() {
        if (carriedObject != null) {
            carriedObject.moveTo(new Position(getX(), getY()));
            carriedObject = null;
        }
    }
}
