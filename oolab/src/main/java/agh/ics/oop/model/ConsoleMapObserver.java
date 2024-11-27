package agh.ics.oop.model;

import java.util.Observer;

public class ConsoleMapObserver implements MapChangeListener {
    private int changeCount = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        System.out.println(message); // todo fix to make if formated string
        System.out.println(worldMap);
        System.out.println(worldMap.getId());
        changeCount++;
        System.out.println("Map changed "+changeCount);

    }
}
