package com.example.antsimulator;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Model extends Application {
    private int tickrate;

    @Override
    public void start(Stage stage) throws IOException {
        tickrate = 100;

        Group root = new Group();
        Scene scene = new Scene(root, 1000, 1000);

        SimulationHandler simulationHandler = new SimulationHandler(new World());

        GameCanvas canvas = new GameCanvas(simulationHandler.getWorld(),1000, 1000);


        stage.setTitle("Ant Simulator");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setOnCloseRequest(event -> {
            Platform.exit(); // stops JavaFX
            System.exit(0); // forces JVM exit
        });
        GameCanvas bg = new GameCanvas(simulationHandler.getWorld(), 1000,1000);
        GameCanvas ui = new GameCanvas(simulationHandler.getWorld(), 1000,1000);
        root.getChildren().add(bg);
        root.getChildren().add(canvas);
        root.getChildren().add(ui);



        Thread gameThread = new Thread() {
            @Override
            public void run() {
                try {
                    bg.renderBG();
                    ui.renderUI();
                    while(true){
                        simulationHandler.getWorld().tick();
                        canvas.render();
                        Thread.sleep(tickrate);

                    }
                } catch (InterruptedException v) {
                    System.out.println(v);
                }
            }
        };
        gameThread.start();

        stage.show();
    }

    public static void main(String[] args){
        Application.launch(args);
    }
}
