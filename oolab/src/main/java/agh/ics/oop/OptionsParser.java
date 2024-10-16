package agh.ics.oop;
import agh.ics.oop.model.MoveDirection;
import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse (String[] args ){
        List<MoveDirection> instructions = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f" -> instructions.add(MoveDirection.FORWARD);
                case "b" -> instructions.add(MoveDirection.BACKWARD);
                case "l" -> instructions.add(MoveDirection.LEFT);
                case "r" -> instructions.add(MoveDirection.RIGHT);
                default -> { //do nothing if different arg
                }
            }

        }
        return instructions.toArray(new MoveDirection[instructions.size()]);
    }
}
