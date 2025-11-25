package View;

import Model.Entity;
import Model.EntityType;
import Model.World.World;
import javafx.scene.Node;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class WorldCanvas extends Canvas {

    private GraphicsContext gc;
    private int cellsize;
    private int gridStrokeSize;

    public WorldCanvas(World world, int width, int height) {
        gc = getGraphicsContext2D();
    }

    public void render() {
        gc.clearRect(0, 0, getWidth(), getHeight());


    }
}
