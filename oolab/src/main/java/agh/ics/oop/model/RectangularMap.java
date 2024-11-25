package agh.ics.oop.model;

public class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height) {
        this.MINCORD = new Vector2d(0,0);
        this.MAXCORD = new Vector2d(width-1,height-1);

    }

    @Override
    public String toString() {
        return visualizer.draw(MINCORD, MAXCORD);
    }


}
