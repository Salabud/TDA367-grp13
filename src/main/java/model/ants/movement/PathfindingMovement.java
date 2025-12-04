// Does not take in mind of collision if something has been added after choosing a path.

package model.ants.movement;

import javafx.geometry.Pos;
import model.ants.Ant;
import model.ants.TaskPerformerAnt;
import model.datastructures.Position;
import model.algorithms.Pathfinding;
import model.world.Tile;

/**
 * Implements a movement strategy where the ant follows a precomputed path to a goal using A* pathfinding.
 */
public class PathfindingMovement implements AntMovement{
    int currentStep = 0;
    private Position[] pathToGoal;
    private Position goal;
    int finalStep;

    public PathfindingMovement(Position start, Position goal, Tile[][] tileGrid){
        this.pathToGoal = Pathfinding.Astar(start, goal, tileGrid);
        this.goal = goal;
        this.finalStep = this.pathToGoal.length;
    }

    public void move(Ant ant){
        if (currentStep >= finalStep) {
            // Path complete or no path found
            ant.setMovement(new NoMovement());
            return;
        }
        ant.setPosition(pathToGoal[currentStep]);
        currentStep++;
    }

    public void move(TaskPerformerAnt ant){
        if (ant.getInventory() == null){
            if (currentStep >= finalStep) {
                // Path complete or no path found
                ant.setMovement(new NoMovement());
                return;
            }
            ant.setPosition(pathToGoal[currentStep]);
            currentStep++;
        }
        if(ant.getInventory() != null){
            if (currentStep > finalStep) {
                // Path complete or no path found
                ant.setMovement(new NoMovement());
                return;
            }
            if (currentStep == finalStep){
                ant.setMovement(new NoMovement());
                ant.getInventory().setPosition(goal);
                return;
            }
            // Ignore warning, I have the if statement here for readability
            if (currentStep < finalStep){
                ant.setPosition(pathToGoal[currentStep]);
                ant.getInventory().setPosition(pathToGoal[currentStep + 1]);
                currentStep++;
            }
        }

    }
}
