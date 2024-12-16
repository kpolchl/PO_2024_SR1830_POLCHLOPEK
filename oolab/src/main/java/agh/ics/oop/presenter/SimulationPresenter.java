package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;

public class SimulationPresenter implements MapChangeListener {

    @FXML
    private Label infoLabel;

    @FXML
    private Label changeData;

    @FXML
    private Button start;

    @FXML
    private TextField input;

    private WorldMap worldMap;

    public void setWorldMap(WorldMap map) {
        this.worldMap = map;
    }

    public void drawMap() {
        infoLabel.setText(this.worldMap.toString());
    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        changeData.setText(message);
        drawMap();
    }

    public void onSimulationStartClicked(ActionEvent actionEvent) {
        try {
            String userInput = input.getText();
            List<MoveDirection> directions = OptionsParser.parse(userInput.split(" "));
            AbstractWorldMap recWorld = new RectangularMap(5, 5);
            List<Vector2d> positions = List.of(new Vector2d(1, 1), new Vector2d(1, 2));

            Simulation recSimulation = new Simulation(positions, directions, recWorld);
            recWorld.addObserver(this);
            this.setWorldMap(recWorld);
            recSimulation.run();
            drawMap();
        } catch (IllegalArgumentException e) {
            changeData.setText("Invalid input: " + e.getMessage());
        }
    }
}
