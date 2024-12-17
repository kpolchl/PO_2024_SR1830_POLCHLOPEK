package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;

import java.util.UUID;

public class RectangularMap extends AbstractWorldMap {
    private final UUID ID;
    public RectangularMap(int width, int height) {
        this.MINCORD = new Vector2d(0,0);
        this.MAXCORD = new Vector2d(width-1,height-1);
        this.ID = UUID.randomUUID();

    }


    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(MINCORD, MAXCORD);
    }

    @Override
    public UUID getId() {
        return ID;
    }

}
