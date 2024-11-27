package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;
import agh.ics.oop.model.util.IncorrectPositionException;
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
    public List<MapChangeListener> observers = new ArrayList<>();


    protected void mapChange(String message) {
        for (MapChangeListener listener : observers) {
            listener.mapChanged(this, message);
        }
    }
    public void addObserver(ConsoleMapObserver observer) {
        observers.add(observer);
    }
    public void removeObserver(ConsoleMapObserver observer) {
        observers.remove(observer);
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(MINCORD) && position.precedes(MAXCORD) && !(objectAt(position) instanceof Animal);
    }

    @Override
    public boolean place(Animal animal) throws IncorrectPositionException {
        if (canMoveTo(animal.getPosition())){
            animalMap.put(animal.getPosition(), animal);
            mapChange("Animal placed on "+animal.getPosition());

            return true;
        }
        throw new IncorrectPositionException(animal.getPosition());
    }

    @Override
    public void move(Animal animal, MoveDirection direction){
        Vector2d previousPosition = animal.getPosition();
        animal.move(direction ,this::canMoveTo);
        animalMap.remove(previousPosition);
        animalMap.put(animal.getPosition(), animal);
        mapChange("Animal moves from "+previousPosition+" to "+animal.getPosition());
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
    public abstract Boundary getCurrentBounds();

    @Override
    public String toString() {
        Boundary newBounds = getCurrentBounds();
        return visualizer.draw(newBounds.BOTTOM_LEFT() , newBounds.TOP_RIGHT());
    }
}
