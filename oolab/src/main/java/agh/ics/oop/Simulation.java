package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private List<Animal> animalList;
    private List<MoveDirection> moves;

    public Simulation(List<Vector2d> coordinates , List<MoveDirection> moves){
        this.animalList = new ArrayList<>();
        this.moves = moves;
        for (Vector2d coords : coordinates) {
            animalList.add(new Animal(coords));
        }
    }
    public void run(){
        int i =0;
        int N = animalList.size();
        for (MoveDirection move : moves) {
            animalList.get(i).move(move);
            System.out.println("Zwierze"+ i +" "+ ":" +" "+ animalList.get(i).getCoordinate());
            i = (i + 1) % N;
        }
    }
}

