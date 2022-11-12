package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    protected List<Animal> animals = new ArrayList<>();
    protected final MapVisualizer visualize = new MapVisualizer(this);
    protected Map<Vector2d, Animal> animals_map = new HashMap<>();
    protected Map<Vector2d, Grass> grasses_map = new HashMap<>();
    @Override
    public String toString() {
        return this.visualize.draw(new Vector2d(0,0),new Vector2d(10,10));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return this.animals_map.get(position) == null;
    }

    @Override
    public boolean place(Animal animal) {
        if(this.animals_map.get(animal.getPosition()) != null){
            return false;
        }
        this.animals.add(animal);
        this.animals_map.put(animal.getPosition(),animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        return this.animals_map.get(position) != null || this.grasses_map.get(position) != null;
    }

    @Override
    public Object objectAt(Vector2d position) {
        if(this.animals_map.get(position) != null){
            return this.animals_map.get(position);
        }
        if(this.grasses_map.get(position) != null){
            return this.grasses_map.get(position);
        }
        return null;
    }
    public List<Animal> getArray(){
        return this.animals;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal animal = this.animals_map.get(oldPosition);
        this.animals_map.remove(oldPosition);
        this.animals_map.put(newPosition,animal);
    }
}
