package agh.ics.oop;

import agh.ics.oop.model.*;
import agh.ics.oop.model.util.IncorrectPositionException;

import java.util.ArrayList;
import java.util.List;

public class Simulation{
    private List<Animal> animalList;
    private List<MoveDirection> moves;
    private WorldMap map;

    public Simulation(List<Vector2d> coordinates , List<MoveDirection> moves , WorldMap world) {
        this.animalList = new ArrayList<>();
        this.moves = moves;
        this.map = world;
        for (Vector2d coords : coordinates) {
            Animal animal = new Animal(coords);

                animalList.add(animal);
            try {
                world.place(animal);
            } catch (IncorrectPositionException e) {
                e.printStackTrace();
            }

        }
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public List<MoveDirection> getMoves() {
        return moves;
    }

    public void run() throws InterruptedException {
        int i =0;
        int N = animalList.size();
        for (MoveDirection action : moves) {
            map.move(animalList.get(i), action);
            Thread.sleep(500);
            i = (i + 1) % N;
        }
    }
}

