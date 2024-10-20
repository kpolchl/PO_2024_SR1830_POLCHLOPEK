package agh.ics.oop.model;

public class MapDirectionTest {
    @Test
    public void testNext() {
        assertEquals(MapDirection.EAST , MapDirection.NORTH.next());
    }
}
