package agh.ics.oop.model;

import java.util.HashMap;
import java.util.Map;

public class LinearMap implements WorldMap<String,Integer> {
    private Map<Integer, String> stringPositions;
    private Integer position;
    private String name;

    public LinearMap(Integer position, String name) {
        this.position = position;
        this.name = name;
        this.stringPositions = new HashMap<>();

    }

    @Override
    public String toString() {
        return stringPositions.toString();
    }

    @Override
    public boolean place(String object) {
        stringPositions.put(stringPositions.size(), object);
        return true;
    }

    @Override
    public void move(String object, MoveDirection direction) {
        int stringkey =-1;
        for(Integer key : stringPositions.keySet()) {
            if (stringPositions.get(key).equals(object)){
                stringkey = key;
                break;
            }
        }
        if(direction==MoveDirection.LEFT || direction==MoveDirection.BACKWARD) {
            if( canMoveTo(stringkey-1)){
                stringPositions.put(stringkey-1, object);
                stringPositions.remove(stringkey , object);
                String string = stringPositions.get(stringkey-1);
                stringPositions.put(stringkey, string);
                stringPositions.remove(stringkey-1 , string);

            }
            else{
                if( canMoveTo(stringkey-1)){
                    stringPositions.put(stringkey-1, object);
                    stringPositions.remove(stringkey , object);
                    String string = stringPositions.get(stringkey-1);
                    stringPositions.put(stringkey, string);
                    stringPositions.remove(stringkey-1 , string);
                }
            }
    }   }

    @Override
    public boolean isOccupied(Integer position) {
        return stringPositions.containsKey(position);
    }

    @Override
    public String objectAt(Integer position) {
        return stringPositions.get(position);
    }

    @Override
    public boolean canMoveTo(Integer position) {
        return position>=0 && position< stringPositions.size();
    }
}
