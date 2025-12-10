package view.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import view.MetaDataRegistry;

public class DiamondSprite extends Sprite{
    public DiamondSprite(double width, double height, Color color, GraphicsContext gc) {
        super(width, height, color, gc);
    }

    public DiamondSprite(double size, Color color, GraphicsContext gc) {
        super(size, color, gc);
    }

    @Override
    public void paint(int x, int y){
        double cx = x-2 + width * MetaDataRegistry.getInstance().getZoom() / 2.0;  // center X
        double cy = y-2 + height * MetaDataRegistry.getInstance().getZoom() / 2.0;  // center Y
        double rx  = width * MetaDataRegistry.getInstance().getZoom() / 2.0;         // radius to a x point
        double ry  = height  * MetaDataRegistry.getInstance().getZoom()/ 2.0;         // radius to a x point

        double[] xPointsOutline = {
                cx,
                cx + rx+2,
                cx,
                cx - rx-2
        };

        double[] yPointsOutline = {
                cy - ry-2,
                cy,
                cy + ry+2,
                cy
        };
        gc.setFill(Color.BLACK);
        gc.fillPolygon(xPointsOutline,yPointsOutline,4);

        double[] xPoints = {
                cx,
                cx + rx,
                cx,
                cx - rx
        };

        double[] yPoints = {
                cy - ry,
                cy,
                cy + ry,
                cy
        };
        gc.setFill(color);
        gc.fillPolygon(xPoints,yPoints,4);
    }
}
