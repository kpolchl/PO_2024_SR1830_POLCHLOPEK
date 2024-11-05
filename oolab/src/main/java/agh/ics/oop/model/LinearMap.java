package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class LinearMap implements WorldMap<String, Integer> {
    private Map<String, Integer> stringPositions;

    public LinearMap() {
        this.stringPositions = new HashMap<>();
    }

    @Override
    public String toString() {
        return stringPositions.toString();
    }

    @Override
    public boolean place(String object) {
        stringPositions.put(object, stringPositions.size());
        return true;
    }

    @Override
    public void move(String object, MoveDirection direction) {
        Integer previousPosition = stringPositions.get(object);

        int newPosition = (direction == MoveDirection.LEFT || direction == MoveDirection.BACKWARD)
                ? previousPosition - 1 : previousPosition + 1;

        if (canMoveTo(newPosition)) {
            String otherObject = objectAt(newPosition);
            stringPositions.put(object, newPosition);
            stringPositions.remove(object, previousPosition);
            stringPositions.put(otherObject, previousPosition);
            stringPositions.remove(otherObject, newPosition);
        }
    }
    @Override
    public boolean isOccupied(Integer position) {
        return stringPositions.containsValue(position);
    }

    @Override
    public String objectAt(Integer position) {
        for (Map.Entry<String, Integer> entry : stringPositions.entrySet()) {
            if (entry.getValue().equals(position)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Integer position) {
        return position >= 0 && !stringPositions.containsValue(position);
    }
}