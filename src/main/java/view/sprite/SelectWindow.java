package view.sprite;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import model.Being;
import model.Entity;
import model.ants.Ant;

public class SelectWindow{
    private Entity entity;
    private GraphicsContext gc;
    private int x;
    private int y;
    private int width;
    private int height;

    public SelectWindow(GraphicsContext gc){
        x = 640;
        y = 600;
        width = 160;
        height = 200;
        this.gc = gc;


    }
    public void paint(Entity entity){
        this.entity = entity;
        gc.setFill(Color.WHITE);
        gc.fillRect(x,y,width,height);
        gc.setFill(Color.BLACK);
        switch (entity.getType()){
            case BEING -> {
                Being being = (Being) entity;
                switch (being.getBeingType()){
                    case ANT -> {
                        Ant ant = (Ant) being;
                        gc.fillText("Hunger: " + ant.getHunger(), x+10,y+30);
                    }
                }
            }
        }
    }
}
