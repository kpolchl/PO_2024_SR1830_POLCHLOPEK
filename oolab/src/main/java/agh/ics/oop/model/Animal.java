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

    public Vector2d getCoordinate() {
        return coordinate;
    }

    public String toString(){
        return "(" +coordinate.toString() + ", " + direction.toString() + ")";
    }

    private boolean isAt(Vector2d position) {
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
        Vector2d temp = switch (direction){
            case NORTH -> new Vector2d(0, move == MoveDirection.FORWARD ? 1:-1);
            case EAST -> new Vector2d(move == MoveDirection.FORWARD ? 1:-1, 0);
            case SOUTH -> new Vector2d(0, move == MoveDirection.FORWARD ? -1:1);
            case WEST -> new Vector2d(move == MoveDirection.FORWARD ? -1:1, 0);
        };
        if (checkMapBorder(this.coordinate.add(temp))){
            this.coordinate = this.coordinate.add(temp);
        }
        else{
            //do notihing
        }

    }
    private boolean checkMapBorder (Vector2d position){
        if (position.getX() >=5 || position.getY() >=5 ){
            return false;
        }
        else{
            return true;
        }
    }
    public void move(MoveDirection direction){
        switch(direction){
            case RIGHT  -> swichDir(this.direction);
            case LEFT -> swichDir(this.direction);
            case FORWARD -> goOne(this.direction,this.coordinate,MoveDirection.FORWARD);
            case BACKWARD -> goOne(this.direction, this.coordinate, MoveDirection.BACKWARD);
        }
    }
}