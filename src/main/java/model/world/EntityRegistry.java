package model.world;

import model.entity.Entity;

import java.util.List;

/**
 * Interface for managing a registry of entities within the world.
 */
public interface EntityRegistry {
    List<Entity> getEntityList();
    List<Entity>[][] getEntityGrid();
    void addEntity(Entity entity);
    void removeEntity(Entity entity);
    private void rinseFlaggedEntities(List<Entity> entityList){};
    void updateEntityGrid();
}
