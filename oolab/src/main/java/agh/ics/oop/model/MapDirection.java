package agh.ics.oop.model;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    @Override
    public  String toString(){
        return switch(this){
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
    }
    public MapDirection next(){
        return switch(this){
            case NORTH -> EAST;
            case SOUTH -> WEST;
            case EAST -> SOUTH;
            case WEST -> NORTH;

        };
    }
    public MapDirection previous(){
        return switch(this){
            case NORTH -> WEST;
            case SOUTH -> EAST;
            case EAST -> NORTH;
            case WEST -> SOUTH;
        };
    }
    public Vector2d ToUnitVector(){
        return switch(this){
            case NORTH -> new Vector2d(0,1);
            case EAST -> new Vector2d(1,0);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
        };
    }
}
