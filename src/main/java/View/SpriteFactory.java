package View;

import Model.EntityType;
import javafx.scene.paint.Color;

public class SpriteFactory {
    double cellsize;
    public final Sprite workerAnt;
    public final Sprite Larva;
    public final Sprite Food;
    public final Sprite Queen;
    public SpriteFactory(double cellsize){
        this.cellsize = cellsize;
        workerAnt = new Sprite(cellsize*0.8, cellsize*0.8, Color.ORANGE);
        Larva = new Sprite(cellsize*0.8, cellsize*0.8, Color.WHITE);
        Food = new Sprite(cellsize*0.8, cellsize*0.8, Color.RED);
        Queen = new Sprite(cellsize*0.8, cellsize*0.8, Color.YELLOW);


    }
}
