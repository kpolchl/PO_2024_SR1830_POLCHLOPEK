package agh.ics.oop;

import agh.ics.oop.model.*;

import java.util.List;
import java.net.NoRouteToHostException;
import java.util.Vector;

public class World {
    public static void main(String[] args) {
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Animal> positions = List.of(new Animal(new Vector2d(2,2)), new Animal(new Vector2d(3,2)));
        WorldMap world = new TextMap();
        List<Integer> cord = List.of(0, 1, 2, 3);
        List<String> entries = List.of("a", "b", "c");
        Simulation<String ,Integer> simulation = new Simulation<String,Integer>(entries,directions,world);
        simulation.run();

    }
}
