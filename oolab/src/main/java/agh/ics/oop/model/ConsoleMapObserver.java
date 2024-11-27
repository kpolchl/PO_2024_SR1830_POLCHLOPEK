package agh.ics.oop.model;

import java.util.Observer;

public class ConsoleMapObserver implements MapChangeListener {
    private int changeCount = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.println(message);
        System.out.println(worldMap);
        changeCount++;
        System.out.println("Map changed "+changeCount);

    }
}
