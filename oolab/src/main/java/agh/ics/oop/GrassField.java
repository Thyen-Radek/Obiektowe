package agh.ics.oop;
import java.lang.Math;
public class GrassField extends AbstractWorldMap {
    private final int rangex;
    private final int rangey;
//    private final MapVisualizer Visualize = new MapVisualizer(this);
    public GrassField(int grass){
        this.rangex = (int)Math.sqrt(grass*10);
        this.rangey = (int)Math.sqrt(grass*10);
        for (int i = 0; i < grass; i++){
            int randx = (int)(Math.random()*(this.rangex+1));
            int randy = (int)(Math.random()*(this.rangey+1));
            this.grasses.add(new Grass(new Vector2d(randx,randy)));
        }
    }
    @Override
    public String toString() {
        Vector2d vectorR = new Vector2d(0,0);
        Vector2d vectorL = new Vector2d(0,0);
        for (Grass grass : this.grasses) {
            vectorR = vectorR.upperRight(grass.getPosition());
            vectorL = vectorL.lowerLeft(grass.getPosition());
        }
        for (Animal animal : this.animals) {
            vectorR = vectorR.upperRight(animal.getPosition());
            vectorL = vectorL.lowerLeft(animal.getPosition());
        }
        return this.Visualize.draw(vectorL,vectorR);

    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return super.canMoveTo(position);
    }

    @Override
    public boolean place(Animal animal) {
        return super.place(animal);
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        boolean occup = super.isOccupied(position);
        if(occup){
            return occup;
        }
        for (Grass grass : this.grasses) {
            if (grass.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object =  super.objectAt(position);
        if(object != null){
            return object;
        }
        for (Grass grass : this.grasses) {
            if (grass.getPosition().equals(position)) {
                return grass;
            }
        }
        return null;
    }
}
