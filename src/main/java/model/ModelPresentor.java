package model;

import model.world.Tile;
import model.entity.Entity;
import java.util.List;

public interface ModelPresentor {
    public List<Entity>[][] getEntityGrid();

    public List<Entity> getEntityList();

    public Tile[][] getTileGrid();

    public List<Tile> getTiles();
}
