package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.Math.abs;
import static java.lang.Math.ceilDivExact;

public class RectangularMap implements WorldMap<Animal,Vector2d> {
    private Map<Vector2d, Animal> animalPositions;
    private final int width;
    private final int height;
    private final Vector2d MAXCORD;
    private final Vector2d MINCORD;
    private final MapVisualizer visualizer;

    public RectangularMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.animalPositions = new HashMap<>(this.width * this.height);
        this.MINCORD = new Vector2d(0,0);
        this.MAXCORD = new Vector2d(this.width-1,this.height-1);
        this.visualizer = new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(MINCORD) && position.precedes(MAXCORD) && !isOccupied(position);
    }

    @Override
    public String toString() {
        return visualizer.draw(MINCORD, MAXCORD);
    }

    @Override
    public boolean place(Animal animal ) {
        if (canMoveTo(animal.getCoordinate())){
            animalPositions.put(animal.getCoordinate(), animal);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction){
        Vector2d previousPosition = animal.getCoordinate();
        animal.move(direction ,this::canMoveTo);
        animalPositions.remove(previousPosition);
        animalPositions.put(animal.getCoordinate(), animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animalPositions.containsKey(position);
    }

    @Override
    public Animal objectAt(Vector2d position) {
        return animalPositions.get(position);
    }

}
