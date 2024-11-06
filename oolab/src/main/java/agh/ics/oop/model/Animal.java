package agh.ics.oop.model;

import agh.ics.oop.MoveValidator;

import java.util.Objects;
import java.util.function.Function;

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
        return this.coordinate;
    }

    public MapDirection getDirection() {
        return this.direction;
    }

    public String toString(){
        return  this.direction.toString() ;
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
    private void goOne(MapDirection direction , Vector2d position ,MoveDirection move, Function<Vector2d , Boolean> canMoveTo ){
        Vector2d temp = switch (direction){
            case NORTH -> new Vector2d(0, move == MoveDirection.FORWARD ? 1:-1);
            case EAST -> new Vector2d(move == MoveDirection.FORWARD ? 1:-1, 0);
            case SOUTH -> new Vector2d(0, move == MoveDirection.FORWARD ? -1:1);
            case WEST -> new Vector2d(move == MoveDirection.FORWARD ? -1:1, 0);
        };
        if (canMoveTo.apply(this.coordinate.add(temp))){
            this.coordinate = this.coordinate.add(temp);
        }
        else{
            //do notihing
        }

    }
    public void move(MoveDirection direction , Function<Vector2d , Boolean> canMoveTo){
        switch(direction){
            case RIGHT  -> turnRight(this.direction);
            case LEFT -> turnLeft(this.direction);
            case FORWARD -> goOne(this.direction,this.coordinate,MoveDirection.FORWARD, canMoveTo);
            case BACKWARD -> goOne(this.direction, this.coordinate, MoveDirection.BACKWARD, canMoveTo);
        }
    }
}