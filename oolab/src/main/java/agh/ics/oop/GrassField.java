package agh.ics.oop;
import java.lang.Math;
public class GrassField implements IWorldMap {
    int height;
    int width;
    int grass_count;
    private final Grass[] grasses;
    private int animal_count;
    private final Animal[] animals;
    private final MapVisualizer Visualize = new MapVisualizer(this);
    public GrassField(int grass){
        this.grass_count = grass;
        this.height = (int)Math.sqrt(grass_count*10);
        this.width = (int)Math.sqrt(grass_count*10);
        this.animals = new Animal[(this.width+1)*(this.height+1)];
        this.grasses = new Grass[grass_count];
        for (int i = 0; i < grass_count; i++){
            int randx = (int)(Math.random()*(this.width+1));
            int randy = (int)(Math.random()*(this.height+1));
            this.grasses[i] = new Grass(new Vector2d(randx,randy));
        }
    }

    @Override
    public String toString() {
        Vector2d vectorR = new Vector2d(0,0);
        Vector2d vectorL = new Vector2d(0,0);
        for (int i = 0; i < this.grass_count; i++){
            vectorR = vectorR.upperRight(this.grasses[i].getPosition());
            vectorL = vectorL.lowerLeft(this.grasses[i].getPosition());
        }
        for (int i = 0; i < this.animal_count; i++){
            vectorR = vectorR.upperRight(this.animals[i].getPosition());
            vectorL = vectorL.lowerLeft(this.animals[i].getPosition());
        }
        return this.Visualize.draw(vectorL,vectorR);

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        for (int i = 0;i < this.animal_count; i++){
            if(this.animals[i].isAt(position)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean place(Animal animal) {
        for (int i = 0;i < this.animal_count; i++){
            if(this.animals[i].isAt(animal.getPosition())){
                return false;
            }
        }
        this.animals[this.animal_count] = animal;
        this.animal_count += 1;
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (int i = 0;i < this.animal_count; i++){
            if(this.animals[i].isAt(position)){
                return true;
            }
        }
        for (int i = 0;i < this.grass_count; i++){
            if(this.grasses[i].getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (int i = 0;i < this.animal_count; i++){
            if(this.animals[i].isAt(position)){
                return this.animals[i];
            }
        }
        for (int i = 0;i < this.grass_count; i++){
            if(this.grasses[i].getPosition().equals(position)){
                return this.grasses[i];
            }
        }
        return null;
    }
}
