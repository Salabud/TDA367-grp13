package com.example.antsimulator;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Arrays;
import java.util.Objects;

public class GameCanvas extends Canvas {
    World world;
    int cellSize = 10;
    int gridStrokeSize = 1;
    GraphicsContext gc = getGraphicsContext2D();

    public GameCanvas(World world,double width, double height) {
        super(width, height);
        this.world = world;
    }

    public void renderBG() {
        gc.setFill(Color.rgb(102,51,0));
        gc.fillRect(0, 0, getWidth(), getHeight());

        // Draw grid lines
        gc.setStroke(Color.rgb(51,25,0));
        gc.setLineWidth(gridStrokeSize);

        for (double x = 0; x < getWidth(); x += cellSize) {
            gc.strokeLine(x, 0, x, getHeight()); // vertical lines
        }

        for (double y = 0; y < getHeight(); y += cellSize) {
            gc.strokeLine(0, y, getWidth(), y); // horizontal lines
        }
        for (Entity entity : world.getEntities()) {
            double cellX = entity.getX() * 10;
            double cellY = entity.getY() * 10;
            if (entity.getType().equals("Wall")) {
                gc.setFill(Color.rgb(153,76,0));
                if (entity.getY() == 12) gc.setFill(Color.rgb(128,255,0));
                double padding = gridStrokeSize;
                double rectSize = cellSize - 2 * padding;
                gc.fillRect(cellX + 0.5, cellY + 0.5, cellSize - 1, cellSize - 1);
            }
        }
    }

    public void render() {
        gc.clearRect(0,0,1000,1000);
        // Draw your objects here
        for (Entity entity : world.getEntities()){
            double cellX = entity.getX()*10;
            double cellY = entity.getY()*10;
            if (entity.getType().equals("Food")) {
                gc.setFill(Color.RED);
                double circleSize = (cellSize*0.8);
                double offset = (cellSize-circleSize) / 2;
                gc.fillOval(cellX+offset,cellY+offset,circleSize,circleSize);
            }
            else if (entity.getType().equals("Ant")){
                gc.setFill(Color.ORANGE);
                double circleSize = (cellSize*0.8);
                double offset = (cellSize-circleSize) / 2;
                //System.out.println("cellX: " + cellX + ", cellY: " + cellY + ", circleSize: " + circleSize + ", offset: " + offset);
                gc.fillOval(cellX+offset,cellY+offset,circleSize,circleSize);
            } else if (entity.getType().equals("Larva")) {
                gc.setFill(Color.WHITE);
                double circleSize = (cellSize*0.8);
                double offset = (cellSize-circleSize) / 2;
                gc.fillOval(cellX+offset,cellY+offset,circleSize,circleSize);
            }


        }

    }

    public void renderUI() {
        gc.setFill(Color.rgb(51,204,255));
        gc.fillRect(0,0,1000,120);
        Image uiImage = new Image(getClass().getResourceAsStream("/UI.png"));
        gc.drawImage(uiImage, -100, 765, 1000*1.2, 340*1.2);



    }
}