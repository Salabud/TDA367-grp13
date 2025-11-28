package Model.World;

import java.util.ArrayList;
import java.util.List;

import Model.Entity;

public class World {
    private List<Entity> allEntities;
    private List<Entity>[][] entityGrid;
    private Tile[][] tileGrid;
    private final int gridSize;    

    public World(){
        this.gridSize = 100; //TODO: Temporary demo size
        this.entityGrid = new List[gridSize][gridSize];
        for (int x = 0; x < gridSize; x++) {
            for (int y = 0; y < gridSize; y++) {
                entityGrid[x][y] = new ArrayList<>();
            }
        }
        this.tileGrid = new Tile[gridSize][gridSize];
        this.allEntities = new ArrayList<>();
    }

    public void addEntity(Entity entity){
        int x = entity.getX();
        int y = entity.getY();
        if (inBounds(x, y)) {
            entityGrid[x][y].add(entity);
            allEntities.add(entity);
        }
    }

    public void removeEntity(Entity entity) {
        int x = entity.getX();
        int y = entity.getY();
        if (inBounds(x, y)) {
            entityGrid[x][y].remove(entity);
            allEntities.remove(entity);
        }
    }

    public Item killEntity(Entity entity){
        removeEntity(entity);
        return new Item(null, MaterialType.CORPSE);
    }

    public Item breakTile(Tile tile){
        int x = tile.getX();
        int y = tile.getY();
        if (inBounds(x, y) && tileGrid[x][y] == tile) {
            tileGrid[x][y] = null;
            return new Item(null, tile.getMaterialType());
        }
        return null;
    }

    public void addTile(Tile tile){
        int x = tile.getX();
        int y = tile.getY();
        if (inBounds(x, y) && tileGrid[x][y] == null) {
            tileGrid[x][y] = tile;
        }
    }

    public List<Entity> getEntities(){
        return allEntities;
    }

    public Tile getTile(int x, int y) {
        if (inBounds(x, y)) {
            return tileGrid[x][y];
        }
        return null;
    }

    private boolean inBounds(int x, int y) {
        boolean withinGrid = x >= 0 && x < gridSize && y >= 0 && y < gridSize;
        return withinGrid;
    }

    public void tick(){
        for (int x=0; x<entityGrid.length; x++){
            for (int y=0; y<entityGrid[x].length; y++){
                for (Entity entity : entityGrid[x][y]){
                    entity.update();
                }
            }
        }
    }
// public static void main(String[] args) {

//     World world = new World();

//     Entity e = new Entity();
//     world.addEntity(e);

//     System.out.println(world.getEntities());                // Test 1
//     System.out.println(world.entityGrid[10][10]);           // Test 2
//     System.out.println(world.entityGrid[0][0]);             // Test 3
//     }
}
