package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import java.util.List;
import java.net.NoRouteToHostException;

public class World {
    public static void main(String[] args) {

        // Animal manipulation
        Animal Monkey = new Animal();
        System.out.println(Monkey);
        Monkey.move(MoveDirection.FORWARD);
        Monkey.move(MoveDirection.FORWARD);
        Monkey.move(MoveDirection.FORWARD);
        Monkey.move(MoveDirection.FORWARD);
        Monkey.move(MoveDirection.FORWARD);
        Monkey.move(MoveDirection.FORWARD);
        System.out.println(Monkey);
        List<MoveDirection> directions = OptionsParser.parse(args);
        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
        Simulation simulation = new Simulation(positions, directions);
        simulation.run();


    }
}
