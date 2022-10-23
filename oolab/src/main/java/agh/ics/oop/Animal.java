package agh.ics.oop;

import java.util.Map;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);

    @Override
    public String toString() {
        return "Animal{" +
                "direction=" + direction +
                ", position=" + position +
                '}';
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        Vector2d pos = this.position;
        MapDirection dir = this.direction;
        switch (direction){
            case RIGHT -> this.direction = dir.next();
            case LEFT -> this.direction = dir.previous();
            case FORWARD -> {
                Vector2d temp = pos.add(dir.toUnitVector());
                if(temp.x <= 4 && temp.y <= 4 && temp.x >= 0 && temp.y >= 0) {
                    this.position = temp;
                }
            }
            case BACKWARD -> {
                Vector2d temp = pos.add(dir.toUnitVector().opposite());
                if(temp.x <= 4 && temp.y <= 4 && temp.x >= 0 && temp.y >= 0) {
                    this.position = temp;
                }
            }
        }
    }
    public MapDirection getDirection() {
        return direction;
    }
    public Vector2d getPosition() {
        return position;
    }
}
