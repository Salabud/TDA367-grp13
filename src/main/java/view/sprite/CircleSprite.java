package view.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import view.MetaDataRegistry;

public class CircleSprite extends Sprite{

    public CircleSprite(double width, double height, Color color, GraphicsContext gc) {
        super(width, height, color, gc);
    }

    public CircleSprite(double size, Color color, GraphicsContext gc) {
        super(size, color, gc);
    }

    @Override
    public void paint(int x, int y){
        double centerOffsetX = (MetaDataRegistry.getInstance().getCellSize()-width*MetaDataRegistry.getInstance().getCellSize())/2;
        double centerOffsetY = (MetaDataRegistry.getInstance().getCellSize()-height*MetaDataRegistry.getInstance().getCellSize())/2;
        double cellSize = MetaDataRegistry.getInstance().getCellSize();

        gc.setFill(Color.BLACK);
        gc.fillOval(x+centerOffsetX-2,y+centerOffsetY-2, width*cellSize+4, height*cellSize+4);
        gc.setFill(color);
        gc.fillOval(x+centerOffsetX,y+centerOffsetY, width*cellSize, height*cellSize);
    }
}
