package agh.ics.oop;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] directions;
    private final IWorldMap map_animals;
    private int animals_count = 0;
    private final Animal[] animals;
    public SimulationEngine(MoveDirection[] directions, IWorldMap map_animals, Vector2d[] positions){
        this.directions = directions;
        this.map_animals = map_animals;
        this.animals = new Animal[positions.length];
        for (int i = 0;i<positions.length;i++) {
            boolean check;
            Animal animal = new Animal(this.map_animals, positions[i]);
            check = this.map_animals.place(animal);
            if (check){
                this.animals[this.animals_count] = animal;
                this.animals_count += 1;
            }
        }
    }
    @Override
    public void run() {
        for (int i=0;i<this.directions.length;i++){
            this.animals[i%this.animals_count].move(this.directions[i]);
        }
    }
}
