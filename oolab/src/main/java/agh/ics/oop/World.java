package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;
import java.net.NoRouteToHostException;

public class World {
    public static void main(String[] args) {
        Animal animal = new Animal();
        List<MoveDirection> directions = null;
        try {
            directions = OptionsParser.parse(args);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        List<Vector2d> positions = List.of(new Vector2d(1, 1), new Vector2d(1, 2));
        AbstractWorldMap world = new GrassField(10);
        world.addObserver(new ConsoleMapObserver());
        Simulation simulation = new Simulation(positions, directions, world);
        simulation.run();


    }
}
