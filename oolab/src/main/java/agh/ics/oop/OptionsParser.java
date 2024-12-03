package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OptionsParser {
    public static List<MoveDirection> parse (String[] args ){
        List<MoveDirection> instructions = new LinkedList<>();
        //linked lista bo szybciej się do niej dodaje 
        for (String arg : args) {
            switch (arg) {
                case "f" -> instructions.add(MoveDirection.FORWARD);
                case "b" -> instructions.add(MoveDirection.BACKWARD);
                case "l" -> instructions.add(MoveDirection.LEFT);
                case "r" -> instructions.add(MoveDirection.RIGHT);
                default -> throw new IllegalArgumentException(arg + "must be either f, b, l, r");
                }
            }
        return instructions;
    }
}
