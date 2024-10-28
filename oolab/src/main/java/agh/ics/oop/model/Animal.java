package agh.ics.oop.model;

import java.util.Objects;

public class Animal {
    private MapDirection direction;
    private Vector2d coordinate;

    public Animal() {
        this.direction = MapDirection.NORTH;
        this.coordinate = new Vector2d(2, 2);
    }
    public Animal(Vector2d coordinate) {
        this.direction = MapDirection.NORTH;
        if (coordinate.getX() >4 || coordinate.getX() <-4 || coordinate.getY() >4 || coordinate.getY() <-4) {
            throw new IllegalArgumentException("Animal outside map");
        }
        else{
            this.coordinate = coordinate;
        }
    }

    public Vector2d getCoordinate() {
        return coordinate;
    }

    public MapDirection getDirection() {
        return direction;
    }

    public String toString(){
        return "(" +coordinate.toString() + ", " + direction.toString() + ")";
    }

    private boolean isAt(Vector2d position) {
        return this.coordinate.equals(position);
    }

    private void turnRight(MapDirection direction){
       switch(direction){
           case NORTH -> this.direction = MapDirection.EAST;
           case EAST -> this.direction = MapDirection.SOUTH;
           case SOUTH -> this.direction = MapDirection.WEST;
           case WEST -> this.direction = MapDirection.NORTH;
       }
    }
    private void turnLeft(MapDirection direction){
        switch(direction){
            case NORTH -> this.direction = MapDirection.WEST;
            case EAST -> this.direction = MapDirection.NORTH;
            case SOUTH -> this.direction = MapDirection.EAST;
            case WEST -> this.direction = MapDirection.SOUTH;

        }
    }
    private boolean checkMapBorder (Vector2d position){
        if (position.getX() >4 || position.getX() <-4 || position.getY() >4 || position.getY() <-4 ){
            return false;
        }
        else{
            return true;
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
    public void move(MoveDirection direction){
        switch(direction){
            case RIGHT  -> turnRight(this.direction);
            case LEFT -> turnLeft(this.direction);
            case FORWARD -> goOne(this.direction,this.coordinate,MoveDirection.FORWARD);
            case BACKWARD -> goOne(this.direction, this.coordinate, MoveDirection.BACKWARD);
        }
    }
}