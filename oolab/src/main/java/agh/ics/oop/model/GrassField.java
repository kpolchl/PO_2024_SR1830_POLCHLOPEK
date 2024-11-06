package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class GrassField implements WorldMap {
    private Map<Vector2d, WorldElement> map;
    private int numberOfGrass;

    public GrassField(int numberOfGrass) {
        this.map = new HashMap<>();
        this.numberOfGrass = numberOfGrass;
        for (int i = 0; i < numberOfGrass; i++) {
            map.put(new Vector2d(1,1),new Grass(new Vector2d(1,1)));


        }

    }

    @Override
    public boolean place(Animal animal) {
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return false;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return false;
    }

    @Override
    public void move(Animal animal, MoveDirection direction) {

    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
