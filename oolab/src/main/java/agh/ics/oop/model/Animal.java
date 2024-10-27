package agh.ics.oop.model;

public class Animal {
    private MapDirection direction;
    private Vector2d coordinate;

    public Animal() {
        this.direction = MapDirection.NORTH;
        this.coordinate = new Vector2d(2, 2);
    }
    public Animal(Vector2d coordinate) {
        this.direction = MapDirection.NORTH;
        this.coordinate = coordinate;
    }
    public String toString(){
        return "(" +coordinate.toString() + ", " + direction.toString() + ")";
    }
    private boolean isAt(Vector2d position)
    {
        return this.coordinate.equals(position);
    }
    private void swichDir(MapDirection direction){
        if (direction.equals(MapDirection.NORTH)) {
            this.direction = MapDirection.EAST;
        } else{
            this.direction = MapDirection.NORTH;
        }
    }
    private void goOne(MapDirection direction , Vector2d position ,MoveDirection move){
        switch(direction){
            case NORTH -> this.coordinate.add(new Vector2d(0,1));
            case EAST -> this.coordinate.add(new Vector2d(1,0));
            case SOUTH -> this.coordinate.add(new Vector2d(0,-1));
            case WEST -> this.coordinate.add(new Vector2d(-1,0));
        }

    }
//    public void move(MoveDirection direction){
//        switch(direction){
//            case RIGHT  -> swichDir(this.direction);
//            case LEFT -> swichDir(this.direction);
//            case FORWARD ->
//            case BACKWARD -> goOne(this.direction, this.coordinate);
//        }
//    }
}