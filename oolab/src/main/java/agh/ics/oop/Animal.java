package agh.ics.oop;

public class Animal extends AbstractWorldMapElement {
    private final IWorldMap map;
    private MapDirection direction = MapDirection.NORTH;
    public Animal(IWorldMap map,Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }
    @Override
    public String toString() {
        return switch(this.direction){
            case NORTH -> "N";
            case SOUTH -> "S";
            case EAST -> "E";
            case WEST -> "W";
        };
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
        return this.direction;
    }
}
