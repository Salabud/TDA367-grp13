package Model.World;

import java.util.ArrayList;
import java.util.List;

import Model.Ants.AntFactory;
import Model.Colony.AntColony;
import Model.Colony.ColonyMediator;
import Model.Colony.ColonyTaskBoard;
import Model.Entity;

public class World {
    private List<Entity>[][] entityGrid;
    private List<Entity> entities;
    private List<Tile>[] tileGrid;
    

    public World(){
        int gridSize = 100; //Temporary demo size
        this.entityGrid = new List[gridSize][gridSize];
        this.tileGrid = new List[gridSize];
        this.entities = new ArrayList<>();
        for (int x=0; x<entityGrid.length; x++) {
            for (int y=0; y < entityGrid[x].length; y++) {
                entityGrid[x][y] = new ArrayList<>();
            }
        }

        //Hardcoded starting world
        ColonyMediator mediator = new ColonyMediator();
        ColonyTaskBoard taskBoard = new ColonyTaskBoard();
        AntColony colony = new AntColony(mediator, taskBoard);
        
        AntFactory factory = AntFactory.getInstance();
        factory.createWorkerAnt(this, colony, 0, 50, 50, mediator);
    }

    public void addEntity(Entity entity){
        entityGrid[entity.getX()][entity.getY()].add(entity);
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entityGrid[entity.getX()][entity.getY()].remove(entity);
        entities.remove(entity);
    }

    public Item breakTile(Tile tile){
        return null; //TODO
    }

    public void addTile(Tile tile){
        //TODO
    }

    public List<Entity> getEntities(){
        return this.entities;
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
}

