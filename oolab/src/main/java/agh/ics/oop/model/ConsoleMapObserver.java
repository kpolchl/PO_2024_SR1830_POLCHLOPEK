package agh.ics.oop.model;

import java.util.Observer;

public class ConsoleMapObserver implements MapChangeListener {
    private int changeCount = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        String log = "Change %s %s \n ID %s";
        System.out.println(String.format(log, changeCount++, message, worldMap.getId()));
        System.out.println(worldMap);
    }
}
