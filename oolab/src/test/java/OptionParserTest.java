import agh.ics.oop.OptionsParser;
import agh.ics.oop.model.MoveDirection;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class OptionParserTest {
    @Test
    public void testparse() {
        MoveDirection[] directions = new MoveDirection[]{MoveDirection.FORWARD, MoveDirection.BACKWARD, MoveDirection.LEFT, MoveDirection.RIGHT};
        MoveDirection[] emptyDirections = new MoveDirection[]{};
        String[] unparsedDirections = {"f","b","l","r"};
        String[] unparsedDirectionsWithErr = {"f","fasc","b","l","dssa","r","sds"};
        String[] allErr = {"fasc","dssa","sds"};
        String[] emptyconvert = {};

        //all good parse
        assertArrayEquals(directions , OptionsParser.parse(unparsedDirections));
        // mixed parse
        assertArrayEquals(directions , OptionsParser.parse(unparsedDirectionsWithErr));
        // all wrong parse
        assertArrayEquals(emptyDirections , OptionsParser.parse(allErr));
        // empty convert
        assertArrayEquals(emptyDirections , OptionsParser.parse(emptyconvert));

    }
}
