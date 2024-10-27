package agh.ics.oop.model;

import agh.ics.oop.OptionsParser;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OptionParserTest {
    @Test
    public void testparse() {
        List<MoveDirection> directions = List.of(MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT);
        List<MoveDirection> emptyDirections = new LinkedList<>();
        String[] unparsedDirections = {"f","b","l","r"};
        String[] unparsedDirectionsWithErr = {"f","fasc","b","l","dssa","r","sds"};
        String[] allErr = {"fasc","dssa","sds"};
        String[] emptyconvert = {};

        //all good parse
        assertEquals(directions , OptionsParser.parse(unparsedDirections));
        // mixed parse
        assertEquals(directions , OptionsParser.parse(unparsedDirectionsWithErr));
        // all wrong parse
        assertEquals(emptyDirections , OptionsParser.parse(allErr));
        // empty convert
        assertEquals(emptyDirections , OptionsParser.parse(emptyconvert));

    }
}
