package agh.ics.oop;
import java.lang.Math;
public class GrassField extends AbstractWorldMap {
    private final int rangex;
    private final int rangey;

    public GrassField(int grass){
        this.rangex = (int)Math.sqrt(grass*10);
        this.rangey = (int)Math.sqrt(grass*10);
        for (int i = 0; i < grass; i++){
            int randx = (int)(Math.random()*(this.rangex+1));
            int randy = (int)(Math.random()*(this.rangey+1));
            Grass trawka = new Grass(new Vector2d(randx,randy));
            this.grasses.add(trawka);
            this.mapElements.add(trawka);
        }
    }
    @Override
    public String toString() {
        Vector2d vectorR = new Vector2d(0,0);
        Vector2d vectorL = new Vector2d(0,0);
        for (IMapElement element : this.mapElements) {
            vectorR = vectorR.upperRight(element.getPosition());
            vectorL = vectorL.lowerLeft(element.getPosition());
        }
        return this.visualize.draw(vectorL,vectorR);
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
        return super.isOccupied(position);
    }

    @Override
    public Object objectAt(Vector2d position) {
        return super.objectAt(position);
    }
}
