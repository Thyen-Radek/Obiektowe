package agh.ics.oop;
import java.util.Arrays;
public class World {

    public static void main(String[] args) {
        System.out.println("System wystartował");
        String[] move = new String[]{"f","l","b","r","g","l","h","f"};
        Direction[] send = getArray(move);
        run(send);
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        System.out.println("System zakończył działanie");
    }
    public static Direction[] getArray(String[] array){
        int counter = 0;
        Direction[] directions = new Direction[array.length];
        for (String argument : array){
            switch (argument) {
                case "f" -> {
                    directions[counter] = Direction.FORWARD;
                    counter++;
                }
                case "b" -> {
                    directions[counter] = Direction.BACKWARD;
                    counter++;
                }
                case "l" -> {
                    directions[counter] = Direction.LEFT;
                    counter++;
                }
                case "r" -> {
                    directions[counter] = Direction.RIGHT;
                    counter++;
                }
            }
        }
        return Arrays.copyOfRange(directions, 0, counter);
    }
    public static void run(Direction[] arguments){
        for (Direction argument : arguments){
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak skręca w prawo";
                case RIGHT -> "Zwierzak skręca w lewo";
            };
            System.out.println(message);
        }
    }
}