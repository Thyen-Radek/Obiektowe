package agh.ics.oop;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private final int animals_count;
    private final Animal[] animals;
    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.animals_count = positions.length;
        this.animals = new Animal[this.animals_count];
        for (int i = 0;i<this.animals_count;i++) {
            Animal animal = new Animal(this.map, positions[i]);
            this.animals[i] = animal;
            this.map.place(animal);
        }
    }
    @Override
    public void run() {
        for (int i=0;i<this.directions.length;i++){
            this.animals[i%this.animals_count].move(this.directions[i]);
        }
    }
}
