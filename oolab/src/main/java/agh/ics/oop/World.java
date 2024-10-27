package agh.ics.oop;

import agh.ics.oop.model.Animal;
import agh.ics.oop.model.MapDirection;
import agh.ics.oop.model.MoveDirection;
import agh.ics.oop.model.Vector2d;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(args);
        System.out.println("system zakończył zadanie");

        // vector manipulation
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        //Map direction manipulation
        MapDirection dir = MapDirection.NORTH;
        System.out.println(dir.next());
        MapDirection dir2 = MapDirection.EAST;
        System.out.println(dir2.previous());

        // Animal manipulation
        Animal Monkey = new Animal();
        System.out.println(Monkey);


    }
    static void run(String[] args){
        MoveDirection[] ParsedDirections = OptionsParser.parse(args);

        for(MoveDirection command : ParsedDirections){
            switch (command) {
                case FORWARD -> System.out.println("Jaszczur idzie w przodu");
                case BACKWARD -> System.out.println("Jaszczur idzie do tyłu");
                case RIGHT -> System.out.println("Jaszczur skręca w prawo");
                case LEFT -> System.out.println("Jaszczur skręca w lewo");
                default -> {
                }

            }

        }
    }

}
