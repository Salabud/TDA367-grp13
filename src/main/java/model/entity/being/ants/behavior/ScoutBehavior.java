package model.entity.being.ants.behavior;

import model.entity.Entity;
import model.entity.being.ants.Ant;
import model.colony.events.FoodDiscoveredEvent;
import model.entity.item.Item;
import model.world.MaterialType;
import model.world.WorldContext;

import java.util.List;

/**
 * Behavior for observing surroundings and reporting discoveries.
 * Scans a square area around the ant and reports any unknown food via events.
 * Uses the ColonyEvent pattern to notify listeners about discovered food.
 */
public class ScoutBehavior implements AntBehavior {

    //TODO: Introduce Scoutable interface (for items and beings)
    private static final int DEFAULT_DETECTION_SIZE = 5;
    private final int detectionSize;

    public ScoutBehavior() {
        this(DEFAULT_DETECTION_SIZE);
    }
    
    public ScoutBehavior(int detectionSize) {
        this.detectionSize = detectionSize;
    }

    @Override
    public void perform(Ant ant) {
        WorldContext surroundings = ant.getSurroundings();
        
        if (surroundings == null) {
            return;
        }
        
        int antX = ant.getX();
        int antY = ant.getY();
        List<Entity>[][] entityGrid = surroundings.getEntityGrid();
        int gridSize = entityGrid.length;
        
        for (int dx = -detectionSize; dx <= detectionSize; dx++) {
            for (int dy = -detectionSize; dy <= detectionSize; dy++) {
                int checkX = antX + dx;
                int checkY = antY + dy;
                
                if (checkX < 0 || checkX >= gridSize || checkY < 0 || checkY >= gridSize) {
                    continue;
                }
                
                List<Entity> entitiesAtPosition = entityGrid[checkX][checkY];
                if (entitiesAtPosition == null) {
                    continue;
                }
                
                for (Entity entity : entitiesAtPosition) {
                    if (entity instanceof Item item && 
                        item.getMaterialType() == MaterialType.FOOD &&
                        !item.isScouted()) {
                        // Mark as scouted to prevent duplicate reports
                        item.setScouted(true);
                        // Broadcast discovery event to colony via the event pattern
                        ant.broadcastEvent(new FoodDiscoveredEvent(item, ant));
                    } //TODO: Also report corpses/larva that are not in the nursery.
                }
            }
        }
    }

    @Override
    public boolean isComplete() {
        return false;
    }
}
