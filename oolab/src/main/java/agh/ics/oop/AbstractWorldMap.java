package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

abstract class AbstractWorldMap implements IWorldMap {
    protected List<Animal> animals = new ArrayList<>();
    protected List<Grass> grasses = new ArrayList<>();
    protected final MapVisualizer Visualize = new MapVisualizer(this);
    @Override
    public String toString() {
        return this.Visualize.draw(new Vector2d(0,0),new Vector2d(10,10));
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
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.isAt(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (Animal animal : this.animals) {
            if (animal.isAt(position)) {
                return animal;
            }
        }
        return null;
    }
    public List<Animal> getArray(){
        return animals;
    }
}
