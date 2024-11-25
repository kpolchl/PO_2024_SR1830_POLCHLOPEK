package agh.ics.oop.model;

import agh.ics.oop.World;
import agh.ics.oop.model.util.MapVisualizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    public int numberOfGrass;
    private final Map<Vector2d , Grass> grassMap;


    public GrassField(int numberOfGrass) {
        this.grassMap = new HashMap<>();
//        Random rand = new Random();
//        this.n = numberOfGrass;
//        int i=0;
//        while (i < this.n) {
//            int randx = rand.nextInt((int) sqrt(n*10));
//            int randy = rand.nextInt((int) sqrt(n*10));
//            if (!grassMap.containsKey(new Vector2d(randx,randy))) {
//                grassMap.put(new Vector2d(randx, randy), new Grass(new Vector2d(randx, randy)));
//                i++;
//            }

//        }
        RandomPositionGenerator randomPositionGenerator = new RandomPositionGenerator((int) sqrt(numberOfGrass*10), (int) sqrt(numberOfGrass*10), numberOfGrass);
        for(Vector2d grassPosition : randomPositionGenerator) {
            grassMap.put(grassPosition, new Grass(grassPosition));
        }
    }
    @Override
    public String toString(){
        Vector2d maxmap = (Vector2d) animalMap.keySet().toArray()[0];
        Vector2d minmap = (Vector2d) animalMap.keySet().toArray()[0];
        for(Vector2d v : animalMap.keySet()){
            maxmap = maxmap.upperRight(v);
            minmap = minmap.lowerLeft(v);

        }
        for(Vector2d v : grassMap.keySet()){
            maxmap = maxmap.upperRight(v);
            minmap = minmap.lowerLeft(v);
        }
        return visualizer.draw(minmap, maxmap);
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        return animalMap.containsKey(position) || grassMap.containsKey(position);
    }

    @Override
    public WorldElement objectAt(Vector2d position) {
        if (animalMap.containsKey(position)) {
            return animalMap.get(position);
        } else if (grassMap.containsKey(position)) {
            return grassMap.get(position);
        }
        return null;
    }
    public List<WorldElement> getElements(){
        List<WorldElement> object = super.getElements();
        for(Grass g : grassMap.values()){
            object.add(g);
        }
        return object;
    }





}
