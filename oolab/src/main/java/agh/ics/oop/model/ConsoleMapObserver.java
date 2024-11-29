package agh.ics.oop.model;

import java.util.Observer;

public class ConsoleMapObserver implements MapChangeListener {
    private int changeCount = 0;

    @Override
    public void mapChanged(WorldMap worldMap, String message) {
        String logchange = "Change %s %s \n ID %s";
        System.out.println(String.format(logchange, changeCount++, message, worldMap.getId()));
        System.out.println(worldMap);
    }
}
