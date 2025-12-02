package View;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class GameInterface {
    private List<Node> nodes;

    private Button exitButton;
    private Button speedButton;
    private Button pauseButton;
    private Button foodButton;
    private Button poisonButton;

    public GameInterface(){
        nodes = new ArrayList<>();

        exitButton = new Button("Exit");
        exitButton.setLayoutY(0);
        exitButton.setLayoutX(0);
        exitButton.setFocusTraversable(false);
        nodes.add(exitButton);

        pauseButton = new Button("Pause");
        pauseButton.setLayoutX(300);
        pauseButton.setPrefWidth(100);
        pauseButton.setFocusTraversable(false);
        nodes.add(pauseButton);

        speedButton = new Button("x3");
        speedButton.setLayoutX(400);
        speedButton.setFocusTraversable(false);
        nodes.add(speedButton);

        foodButton = new Button("Apple");
        foodButton.setLayoutX(500);
        foodButton.setFocusTraversable(false);
        nodes.add(foodButton);

        poisonButton = new Button("Poison");
        poisonButton.setLayoutX(600);
        poisonButton.setFocusTraversable(false);
        nodes.add(poisonButton);
    }

    public Button getPauseButton(){
        return  pauseButton;
    }
    public Button getExitButton(){
        return exitButton;
    }
    public Button getSpeedButton(){
        return speedButton;
    }
    public List<Node> getNodes(){
        return nodes;
    }
    public Button getFoodButton(){
        return foodButton;
    }
    public Button getPoisonButton(){
        return poisonButton;
    }
}
