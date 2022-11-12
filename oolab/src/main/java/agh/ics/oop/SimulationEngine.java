package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine {
    private final MoveDirection[] directions;
    private final IWorldMap map_animals;
    public SimulationEngine(MoveDirection[] directions, AbstractWorldMap map_animals, Vector2d[] positions){
        this.directions = directions;
        this.map_animals = map_animals;
        for (Vector2d position : positions) {
            Animal animal = new Animal(this.map_animals, position);
            animal.addObserver(map_animals);
            this.map_animals.place(animal);
        }
    }
    @Override
    public void run() {
        List<Animal> animals = this.map_animals.getArray();
        for (int i=0;i<this.directions.length;i++){
            animals.get(i%animals.size()).move(this.directions[i]);
        }
    }
}
