package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.IncorrectPositionException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class SimulationTest {

    @Test
    void checkAnimalOrientation() {
        Animal animal = new Animal();

        assertEquals(animal.getDirection(), MapDirection.NORTH);
    }

    @Test
    void checkAnimalMoveForward() throws IncorrectPositionException {
        WorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal();

        map.place(animal);
        map.move(animal, MoveDirection.FORWARD);

        assertEquals(animal.getPosition(), new Vector2d(2, 3));
        assertEquals(animal.getDirection(), MapDirection.NORTH);
    }

    @Test
    void checkAnimalMoveBackward() throws IncorrectPositionException {
        WorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal();

        map.place(animal);
        map.move(animal, MoveDirection.BACKWARD);

        assertEquals(animal.getPosition(), new Vector2d(2, 1));
        assertEquals(animal.getDirection(), MapDirection.NORTH);
    }

    @Test
    void checkAnimalMoveLeft() throws IncorrectPositionException {
        WorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal();

        map.place(animal);
        map.move(animal, MoveDirection.LEFT);

        assertEquals(animal.getPosition(), new Vector2d(2, 2));
        assertEquals(animal.getDirection(), MapDirection.WEST);
    }

    @Test
    void checkAnimalMoveRight() throws IncorrectPositionException {
        WorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal();

        map.place(animal);
        map.move(animal, MoveDirection.RIGHT);


        assertEquals(animal.getPosition(), new Vector2d(2, 2));
        assertEquals(animal.getDirection(), MapDirection.EAST);
    }

    @Test
    void animalMovesOutsideMap() throws IncorrectPositionException {
        WorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(4, 4));

        map.place(animal);
        map.move(animal, MoveDirection.FORWARD);



        assertEquals(animal.getPosition(), new Vector2d(4, 4));
    }

    @Test
    void cannotMoveToSpaceOccupiedByDiffAnimal() throws IncorrectPositionException {
        WorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));
        Animal monkey = new Animal(new Vector2d(2, 1));

        map.place(animal);
        map.place(monkey);

        map.move(animal, MoveDirection.FORWARD);

        assertEquals(monkey.getPosition(), new Vector2d(2, 1));
    }
    @Test
    void getAnimalAtPosition() throws IncorrectPositionException {
        WorldMap map = new RectangularMap(5, 5);
        Animal animal = new Animal(new Vector2d(2, 2));

        map.place(animal);
        assertEquals(map.objectAt(new Vector2d(2,2)), animal);
        assertEquals(map.objectAt(new Vector2d(2,1)), null);
    }

    @Test
    void fullSimulationCheck(){
        List<MoveDirection> directions = List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT);
        List<Vector2d> positions = List.of(new Vector2d(0,0));
        WorldMap map = new RectangularMap(5, 5);
        Simulation simulation = new Simulation(positions, directions,map);

        try {
            simulation.run();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals(simulation.getAnimalList().getFirst().getPosition(), new Vector2d(0,0));
        assertEquals(simulation.getAnimalList().getFirst().getDirection(), MapDirection.NORTH);
    }
}