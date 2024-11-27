package agh.ics.oop.model;

import agh.ics.oop.model.util.IncorrectPositionException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class WorldMapTest {

    @Test
    public void placeOnGrass() throws IncorrectPositionException {
        WorldMap map   = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(2,2));



        Assertions.assertTrue(map.place(animal1));
        Throwable exception = assertThrows(IncorrectPositionException.class, () -> map.place(animal2));
        assertEquals("Position(2,2)is not correct", exception.getMessage());
    }
    @Test
    public void moveOnGrass(){
        WorldMap map   = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,2));

        map.move(animal1 ,MoveDirection.FORWARD);

        assertEquals(animal1.getPosition(),new Vector2d(2,3));
    }
    @Test
    public void positionOccuppiedOnGrass() throws IncorrectPositionException {
        WorldMap map   = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,2));

        map.place(animal1);

        Assertions.assertTrue(map.isOccupied(new Vector2d(2,2)));
        Assertions.assertFalse(map.isOccupied(new Vector2d(4,2)));
    }

    @Test
    public void objectOnGrass() throws IncorrectPositionException {
        WorldMap map   = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,2));

        map.place(animal1);
        assertEquals(map.objectAt(new Vector2d(2,2)),animal1);
        assertEquals(map.objectAt(new Vector2d(4,2)),null);
    }

    @Test
    public void getEmementsMap() throws IncorrectPositionException {
        WorldMap map   = new RectangularMap(5,5);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(2,3));
        List<WorldElement> elements = new ArrayList<>();

        elements.add(animal1);
        elements.add(animal2);
        map.place(animal1);
        map.place(animal2);

        Assertions.assertTrue(elements.containsAll(map.getElements()) && map.getElements().containsAll(elements));
    }
}
