package agh.ics.oop.model;

import agh.ics.oop.model.util.MapVisualizer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractWorldMap implements WorldMap {
    protected Map<Vector2d, Animal> animalMap = new HashMap<>();
    protected  Vector2d MAXCORD = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected  Vector2d MINCORD = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    protected final MapVisualizer visualizer = new MapVisualizer(this);

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(MINCORD) && position.precedes(MAXCORD) && !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) {
        if (canMoveTo(animal.getPosition())){
            animalMap.put(animal.getPosition(), animal);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void move(Animal animal, MoveDirection direction){
        Vector2d previousPosition = animal.getPosition();
        animal.move(direction ,this::canMoveTo);
        animalMap.remove(previousPosition);
        animalMap.put(animal.getPosition(), animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return animalMap.containsKey(position);
    }
    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animalMap.get(position) != null) return animalMap.get(position);
        return null;
    }
    public List<WorldElement> getElements () {
        return new ArrayList<>(animalMap.values());
    }
}
