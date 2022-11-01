package agh.ics.oop;

public class SimulationEngine implements IEngine{
    private final MoveDirection[] directions;
    private final IWorldMap map;
    private int animals_count = 0;
    private final Animal[] animals;
    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.animals = new Animal[positions.length];
        for (int i = 0;i<positions.length;i++) {
            boolean check;
            Animal animal = new Animal(this.map, positions[i]);
            check = this.map.place(animal);
            if (check){
                this.animals[i] = animal;
                animals_count += 1;
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
