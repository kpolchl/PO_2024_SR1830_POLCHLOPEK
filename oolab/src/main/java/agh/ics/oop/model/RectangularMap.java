package agh.ics.oop.model;

import agh.ics.oop.model.util.Boundary;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height) {
        this.MINCORD = new Vector2d(0,0);
        this.MAXCORD = new Vector2d(width-1,height-1);

    }

    @Override
    public Boundary getCurrentBounds() {
        return new Boundary(MINCORD, MAXCORD);
    }

}
