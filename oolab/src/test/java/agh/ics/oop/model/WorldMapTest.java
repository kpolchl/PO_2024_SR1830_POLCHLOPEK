package agh.ics.oop.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.w3c.dom.css.ElementCSSInlineStyle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class WorldMapTest {

    @Test
    public void placeOnGrass(){
        WorldMap map   = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,2));
        Animal animal2 = new Animal(new Vector2d(2,2));


        Assertions.assertTrue(map.place(animal1));
        Assertions.assertFalse(map.place(animal2));

    }
    @Test
    public void moveOnGrass(){
        WorldMap map   = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,2));

        map.move(animal1 ,MoveDirection.FORWARD);

        Assertions.assertEquals(animal1.getPosition(),new Vector2d(2,3));
    }
    @Test
    public void positionOccuppiedOnGrass(){
        WorldMap map   = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,2));

        map.place(animal1);

        Assertions.assertTrue(map.isOccupied(new Vector2d(2,2)));
        Assertions.assertFalse(map.isOccupied(new Vector2d(4,2)));
    }

    @Test
    public void objectOnGrass(){
        WorldMap map   = new GrassField(10);
        Animal animal1 = new Animal(new Vector2d(2,2));

        map.place(animal1);
        Assertions.assertEquals(map.objectAt(new Vector2d(2,2)),animal1);
        Assertions.assertEquals(map.objectAt(new Vector2d(4,2)),null);
    }

    @Test
    public void getEmementsMap(){
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
