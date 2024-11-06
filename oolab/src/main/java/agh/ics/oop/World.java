package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;
import java.net.NoRouteToHostException;

public class World {
    public static void main(String[] args) {
        Animal animal = new Animal();
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(5,4));
        WorldMap world = new RectangularMap(5,5);
        Simulation simulation = new Simulation(positions, directions, world );
        simulation.run();


    }
}
