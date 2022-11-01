package agh.ics.oop;

import java.util.Map;

public class Animal {
    private final IWorldMap map;
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position;
    public Animal(IWorldMap map,Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }
    @Override
    public String toString() {
        return switch(direction){
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
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
                if(this.map.canMoveTo(temp)){
                    this.position = temp;
                }
            }
            case BACKWARD -> {
                Vector2d temp = pos.add(dir.toUnitVector().opposite());
                if(this.map.canMoveTo(temp)){
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
