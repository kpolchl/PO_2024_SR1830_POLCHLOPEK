package agh.ics.oop.presenter;

import agh.ics.oop.OptionsParser;
import agh.ics.oop.Simulation;
import agh.ics.oop.model.*;
import agh.ics.oop.model.util.Boundary;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

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

    @FXML
    private GridPane mapGrid;


    private WorldMap worldMap;
    private static Vector2d WIDTH;
    private static Vector2d HEIGHT;

    public void setWorldMap(WorldMap map) {
        this.worldMap = map;
        Boundary newBounds = map.getCurrentBounds();
        WIDTH = newBounds.BOTTOM_LEFT();
        HEIGHT = newBounds.TOP_RIGHT();
    }

    public void drawMap() {
        mapGrid.add();

    }

    @Override
    public void mapChanged(WorldMap worldMap, String message) {

        Platform.runLater(() -> {
            drawMap();
            changeData.setText(message);
        });
    }

    private void clearGrid() {
        mapGrid.getChildren().retainAll(mapGrid.getChildren().get(0)); // hack to retain visible grid lines
        mapGrid.getColumnConstraints().clear();
        mapGrid.getRowConstraints().clear();
    }

    public void onSimulationStartClicked(ActionEvent actionEvent) {
        try {
            String userInput = input.getText();
            List<MoveDirection> directions = OptionsParser.parse(userInput.split(" "));
            AbstractWorldMap recWorld = new RectangularMap(5, 5);
            List<Vector2d> positions = List.of(new Vector2d(1, 1), new Vector2d(1, 2));

            Simulation recSimulation = new Simulation(positions, directions, recWorld);
            SimulationEngine simulationEngine = new SimulationEngine(List.of(recSimulation));
            recWorld.addObserver(this); //add observer
            this.setWorldMap(recWorld);
            simulationEngine.runSync(); // run simulations


        } catch (IllegalArgumentException e) {
            changeData.setText("Invalid input: " + e.getMessage());
        }
    }
}
