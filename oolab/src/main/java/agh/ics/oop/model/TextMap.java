package agh.ics.oop.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextMap implements WorldNumberPositionMap<String> {
    private Map<String, Number> stringPositions;

    public TextMap() {
        this.stringPositions = new HashMap<>();
    }

    @Override
    public String toString() {
        List<Map.Entry<String, Number>> entries = new ArrayList<>(stringPositions.entrySet());
        entries.sort((e1, e2) -> Double.compare(e2.getValue().doubleValue(), e1.getValue().doubleValue()));

        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < entries.size(); i++) {
            result.append(entries.get(i).getKey());
            if (i < entries.size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");

        return result.toString();
    }

    @Override
    public boolean place(String object) {
        stringPositions.put(object, stringPositions.size());
        return true;
    }

    @Override
    public void move(String object, MoveDirection direction) {
        Number previousPosition = stringPositions.get(object);
        if (previousPosition == null) return;

        double newPosition = previousPosition.doubleValue() +
                ((direction == MoveDirection.LEFT || direction == MoveDirection.BACKWARD) ? -1 : 1);

        if (canMoveTo(newPosition)) {
            String otherObject = objectAt(newPosition);
            stringPositions.put(object, newPosition);
            if (otherObject != null) {
                stringPositions.put(otherObject, previousPosition);
            }
        }
    }

    @Override
    public boolean isOccupied(Number position) {
        return stringPositions.containsValue(position);
    }

    @Override
    public String objectAt(Number position) {
        for (Map.Entry<String, Number> entry : stringPositions.entrySet()) {
            if (entry.getValue().equals(position)) {
                return entry.getKey();
            }
        }
        return null;
    }

    @Override
    public boolean canMoveTo(Number position) {
        double pos = position.doubleValue();
        return pos >= 0 && pos < stringPositions.size();
    }
}
