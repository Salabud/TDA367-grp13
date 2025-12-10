package view;

import model.ModelPresentor;
import model.ants.Ant;
import model.Being;
import model.Entity;
import model.EntityType;
import model.world.Item;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import view.sprite.*;

import java.util.List;

/**
 * Canvas for rendering entities in the simulation.
 */
public class EntityCanvas extends Canvas {
    private final GraphicsContext gc = getGraphicsContext2D();
    private int cellsize;
    private final Sprite workerAnt;
    private final Sprite larva;
    private final Sprite food;
    private final Sprite queen;
    private final Sprite dirt;
    private final Sprite poison;
    private final Sprite selectionSprite;
    private int selectedEntityId = -1;
    private SelectWindow selectWindow;
    private final MetaDataRegistry metaData = MetaDataRegistry.getInstance();


    public EntityCanvas(){
        this.cellsize = (int)(metaData.getCellSize()* metaData.getZoom());
        setWidth(metaData.getResolutionY());
        setHeight(metaData.getResolutionX());

        // Being sprites
        this.workerAnt = new CircleSprite(1, Color.rgb(250, 149, 0), gc);
        this.larva = new CircleSprite(1, Color.WHITE, gc);
        this.queen = new CircleSprite(1, Color.YELLOW, gc);

        // Item Sprites
        //this.itemOutline = new DiamondSprite(cellsize+6, Color.BLACK, gc);
        this.food = new DiamondSprite(cellsize+2, Color.GREEN, gc);
        this.dirt = new DiamondSprite(cellsize+2, Color.rgb(50,41,47), gc);
        this.poison = new DiamondSprite(cellsize+2, Color.PURPLE, gc);

        // Other sprites
        this.selectionSprite = new SelectSprite(1.4, Color.WHITE, gc);
        this.selectWindow = new SelectWindow(metaData.getResolutionY()- metaData.getSquareOffset()-160, metaData.getResolutionX()-200, gc);
    }

    /**
     * Renders the entities onto the canvas.
     */
    public void render(ModelPresentor modelPresentor) {
        List<Entity> entities = modelPresentor.getEntityList();
        gc.clearRect(0, 0, getWidth(), getHeight());
        Entity selectedEntity = null;

        for (Entity entity : entities) {
            int posX = (int) ((entity.getX()*cellsize + metaData.getSquareOffset()) + metaData.getCameraX());
            int posY = (int) ((entity.getY()*cellsize + metaData.getSquareOffset()) + metaData.getCameraY());
            switch (entity.getType()) {
                case BEING:
                    Being being = (Being) entity;
                    switch(being.getBeingType()){
                        case ANT:
                            Ant ant = (Ant) being;
                            switch(ant.getAntType()){
                                case WORKER_ANT:
                                    workerAnt.paint(posX, posY);
                                    break;
                                case LARVA:
                                    larva.paint(posX, posY);
                                    break;
                                case QUEEN:
                                    queen.paint(posX, posY);
                                    break;
                            }
                    }
                    break;
                case EntityType.ITEM:
                    Item item = (Item) entity;
                    switch (item.getMaterialType()){
                        case DIRT -> dirt.paint(posX,posY);
                        case FOOD -> food.paint(posX,posY);
                        case POISON -> poison.paint(posX,posY);
                    }
                    break;

            }

            if (entity.getEntityId() == selectedEntityId){
                selectedEntity = entity;
                selectWindow.paint(selectedEntity);
            }
        }
        if (selectedEntity != null){
            selectionSprite.paint((int) (selectedEntity.getX()*cellsize + metaData.getCameraX()), (int) (selectedEntity.getY()*cellsize + metaData.getCameraY()));
        }
    }

    public void setSelectedEntity(int selectedEntityId) {
        this.selectedEntityId = selectedEntityId;
    }

    public void updateCellsize() {
        this.cellsize = (int) metaData.getCellSize();
    }
}
