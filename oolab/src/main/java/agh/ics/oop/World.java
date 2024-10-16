package agh.ics.oop;

import agh.ics.oop.model.MoveDirection;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(args);
        System.out.println("system zakończył zadanie");
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
