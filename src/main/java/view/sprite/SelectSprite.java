package view.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import view.MetaDataRegistry;

public class SelectSprite extends Sprite{

    public SelectSprite(double width, double height, Color color, GraphicsContext gc) {
        super(width, height, color, gc);
    }

    public SelectSprite(double size, Color color, GraphicsContext gc) {
        super(size, color, gc);
    }

    @Override
    public void paint(int x, int y) {
        double centerOffsetX = (MetaDataRegistry.getInstance().getCellSize()-width*MetaDataRegistry.getInstance().getCellSize())/2;
        double centerOffsetY = (MetaDataRegistry.getInstance().getCellSize()-height*MetaDataRegistry.getInstance().getCellSize())/2;
        double cellSize = MetaDataRegistry.getInstance().getCellSize();
        gc.setFill(color);
        gc.fillRect(x+centerOffsetX-1,y+centerOffsetY-1,width * cellSize,2);
        gc.fillRect(x+centerOffsetX-1,y+centerOffsetY-1,2,height * cellSize);
        gc.fillRect(x+centerOffsetX-1,(y+centerOffsetY+height * cellSize)-1,width * cellSize+2,2);
        gc.fillRect((x+centerOffsetX+width * cellSize)-1,y+centerOffsetY-1,2,height * cellSize);

    }
}
