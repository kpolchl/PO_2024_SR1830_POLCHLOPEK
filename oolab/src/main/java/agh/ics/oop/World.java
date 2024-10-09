package agh.ics.oop;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        run(args);
        System.out.println("system zakończył zadanie");
    }
    static void run(String[] args){
        for(String command : args){
            switch (command) {
                case "f" -> System.out.println("Jaszczur idzie w przodu");
                case "b" -> System.out.println("Jaszczur idzie do tyłu");
                case "r" -> System.out.println("Jaszczur skręca w prawo");
                case "l" -> System.out.println("Jaszczur skręca w prawo");
            }

        }
    }
}
