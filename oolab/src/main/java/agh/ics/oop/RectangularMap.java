package agh.ics.oop;

public class RectangularMap implements IWorldMap {
    private final int width;
    private final int height;
    private final Animal[] animals;
    private int animal_count = 0;
    private final MapVisualizer Visualize = new MapVisualizer(this);
    public RectangularMap(int width,int height){
        this.width = width;
        this.height = height;
        this.animals = new Animal[(width+1)*(height+1)];
    }

    @Override
    public String toString() {
        return this.Visualize.draw(new Vector2d(0,0),new Vector2d(this.width,this.height));
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if(position.x <= this.width && position.y <= this.height && position.x >= 0 && position.y >= 0) {
            for (int i = 0;i < this.animal_count; i++){
                if(this.animals[i].isAt(position)){
                    return false;
                }
            }
            return true;
        }
        return false;
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
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for (int i = 0;i < this.animal_count; i++){
            if(this.animals[i].isAt(position)){
                return this.animals[i];
            }
        }
        return null;
    }
}
