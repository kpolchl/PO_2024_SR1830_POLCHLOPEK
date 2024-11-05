package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;
import java.net.NoRouteToHostException;

public class World {
    public static void main(String[] args) {
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(5,4));
        WorldMap world = new LinearMap();
        List<Integer> cord = List.of(0, 1, 2, 3);
        List<String> entries = List.of("a", "b", "c");
        Simulation<String, Integer> simulation = new Simulation<>(cord, directions, world, (st, map) -> entities.get(pos) );
        simulation.run();

    }
}
