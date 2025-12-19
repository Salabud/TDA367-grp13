package model;

import model.world.Tile;

import java.util.List;

public interface ModelPresentor {
    List<Entity>[][] getEntityGrid();

    List<Entity> getEntityList();

    Tile[][] getTileGrid();

    List<Tile> getTiles();
}
