package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();
    protected List<Grass> grasses = new ArrayList<>();
    protected List<IMapElement> mapElements = new ArrayList<>();
    protected final MapVisualizer visualize = new MapVisualizer(this);
    @Override
    public String toString() {
        return this.visualize.draw(new Vector2d(0,0),new Vector2d(10,10));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.isAt(position)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        for (Animal value : this.animals) {
            if (value.isAt(animal.getPosition())) {
                return false;
            }
        }
        this.animals.add(animal);
        this.mapElements.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (int i = this.mapElements.size(); i-- > 0; ) {
            if(this.mapElements.get(i).isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (int i = this.mapElements.size(); i-- > 0; ) {
            if(this.mapElements.get(i).isAt(position)){
                return this.mapElements.get(i);
            }
        }
        return null;
    }
    public List<Animal> getArray(){
        return this.animals;
    }
}
