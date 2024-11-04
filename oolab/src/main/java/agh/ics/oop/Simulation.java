package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Simulation<T,P> {
    private List<T> objectlList;
    private List<MoveDirection> moves;
    private WorldMap map;
    private Function<P, T> objectCreator;

    public Simulation(List<P> coordinates , List<MoveDirection> moves , WorldMap world , Function<P, T> objectCreator) {
        this.objectlList = new ArrayList<>();
        this.moves = moves;
        this.map = world;
        for (P coords : coordinates) {
            T object = objectCreator.apply(coords);
            objectlList.add(object);
            world.place(object);
        }
    }

    public List<T> getObjectlList() {
        return this.objectlList;
    }

    public List<MoveDirection> getMoves() {
        return this.moves;
    }

    public void run(){
        System.out.println(map);
        int i =0;
        int N = objectlList.size();
        for (MoveDirection action : moves) {
            map.move(objectlList.get(i), action);
            System.out.println(map);
            i = (i + 1) % N;
        }
    }
}

