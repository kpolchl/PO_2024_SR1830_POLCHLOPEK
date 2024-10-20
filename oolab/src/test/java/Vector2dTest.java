import agh.ics.oop.model.Vector2d;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Vector2dTest {
    @Test
    public void testEquals() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(1,2);
        Vector2d v3 = new Vector2d(1,3);
        //same object equal to himself
        assertTrue(v1.equals(v1));
        // same value vector equal to themselves
        assertTrue(v1.equals(v2));
        // different vectors shouldn't be equal
        assertFalse(v1.equals(v3));
        // shouldn't be equal to false
        assertFalse(v1.equals(null));
    }
    @Test
    public void testtoString(){
        Vector2d v1 = new Vector2d(1,2);
        assertEquals("(1,2)", v1.toString());
    }
    @Test
    public void testprocedes() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);
        //same values procedes itself reflexivity
        assertTrue(v1.precedes(v1));
        // v1 procedes v2
        assertTrue(v1.precedes(v2));
        // v1 don't procede null
        assertFalse(v1.precedes(null));
    }
    @Test
    public void testfollows() {
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);
        //same values follows itself reflexivity
        assertTrue(v1.follows(v1));
        // v2 follows v1
        assertTrue(v2.follows(v1));
        // v1 don't follow v2
        assertFalse(v1.follows(v2));
        // v1 don't follow null
        assertFalse(v2.follows(null));
    }
    @Test
    public void testupperRight() {
        Vector2d v1 = new Vector2d(10,2);
        Vector2d v2 = new Vector2d(3,4);
        assertEquals(v2.upperRight(v1).toString(), "(10,4)");
    }
    @Test
    public void testlowerLeft(){
        Vector2d v1 = new Vector2d(10,2);
        Vector2d v2 = new Vector2d(3,4);
        assertEquals(v2.lowerLeft(v1).toString(), "(3,2)");
    }
    @Test
    public void testadd(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);
        assertEquals(v1.add(v2).toString(), "(4,6)");
    }
    @Test
    public void testsubstract(){
        Vector2d v1 = new Vector2d(1,2);
        Vector2d v2 = new Vector2d(3,4);
        assertEquals(v1.subtract(v2).toString(), "(-2,-2)");
    }
    @Test
    public void testopposite(){
        Vector2d v1 = new Vector2d(1,2);
        assertEquals(v1.opposite().toString(), "(-1,-2)");
    }


}
