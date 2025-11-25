package View;

import Model.Entity;
import Model.EntityType;
import Model.World.World;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class WorldCanvas extends Canvas{

    private GraphicsContext gc;
    private int cellsize;
    private int gridStrokeSize;
    private World world;
    private SpriteFactory sprites;


    public WorldCanvas(World world, int width, int height) {
        super(width, height);
        gc = getGraphicsContext2D();
        cellsize = 10;
        gridStrokeSize = 1;
        this.world = world;
    }

    public void renderEntities(){
     for (Entity entity : world.getEntities()){
         switch (entity.getType()) {
             case EntityType.WORKER_ANT:
                 gc.setFill(sprites.workerAnt.getColor());
                 gc.fillOval(entity.getX(), entity.getY(), sprites.workerAnt.getWidth(), sprites.workerAnt.getHeight());
                 break;
             case EntityType.LARVA:
                 gc.setFill(sprites.Larva.getColor());
                 gc.fillOval(entity.getX(), entity.getY(), sprites.Larva.getWidth(), sprites.Larva.getHeight());
                 break;
             case EntityType.QUEEN:
                 gc.setFill(sprites.Queen.getColor());
                 gc.fillOval(entity.getX(), entity.getY(), sprites.Queen.getWidth(), sprites.Queen.getHeight());
                 break;
             case EntityType.FOOD:
                 gc.setFill(sprites.Food.getColor());
                 gc.fillOval(entity.getX(), entity.getY(), sprites.Food.getWidth(), sprites.Food.getHeight());
                 break;

         }
     }
    }

    public void render() {
        gc.clearRect(0,0,getWidth(), getHeight());
        renderEntities();

    }

}
