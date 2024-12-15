package agh.ics.oop;

import agh.ics.oop.model.*;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.List;
import java.net.NoRouteToHostException;

public class World {
    public static void main(String[] args) throws InterruptedException {
        Animal animal = new Animal();
        List<MoveDirection> directions = null;
        try {
            directions = OptionsParser.parse(args);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        List<Vector2d> positions = List.of(new Vector2d(1, 1), new Vector2d(1, 2));
        AbstractWorldMap recWorld = new GrassField(10);
        AbstractWorldMap grassWorld = new RectangularMap(5,5);
//        recWorld.addObserver(new ConsoleMapObserver());
//        grassWorld.addObserver(new ConsoleMapObserver());

        Simulation recSimulation = new Simulation(positions, directions, grassWorld);
        Simulation grassSimulation = new Simulation(positions, directions, recWorld);

//        SimulationEngine simEng = new SimulationEngine(List.of(recSimulation, grassSimulation ));
//        for( int i =0 ;i<1000; i++){
//            simEng.runAsyncInThreadPool();
//        }


        Application.launch(SimulationApp.class, args);

        System.out.println("system zakończył zadanie");


    }
}
