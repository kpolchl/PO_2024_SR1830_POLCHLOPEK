package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;
import agh.ics.oop.model.WorldMap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Simulation<T,P> {
    private List<T> objectslList;
    private List<MoveDirection> moves;
    private WorldMap map;

    public Simulation(List<T> objects , List<MoveDirection> moves , WorldMap world) {
        this.objectslList = objects;
        this.moves = moves;
        this.map = world;
        for (T obj : objectslList) {
            world.place(obj);
        }
    }

    public List<T> getObjectlList() {
        return this.objectslList;
    }

    public List<MoveDirection> getMoves() {
        return this.moves;
    }



    public void run(){
        System.out.println(map);
        int i =0;
        int N = objectslList.size();
        for (MoveDirection action : moves) {
            map.move(objectslList.get(i), action);
            System.out.println(map);
            i = (i + 1) % N;
        }
    }
}

