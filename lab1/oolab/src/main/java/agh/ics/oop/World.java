package agh.ics.oop;

public class World {

    public static void main(String[] args) {
        int counter = 0;
        String[] move = new String[]{"f","l","b","r","g","l","h","f"};
        Direction[] directions = new Direction[move.length];
        for (String argument : move){
            Direction direction = switch (argument) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "l" -> Direction.LEFT;
                case "r" -> Direction.RIGHT;
                default -> Direction.DEFAULT;
            };
            directions[counter] = direction;
            counter ++;
        }
        System.out.println("System wystartował");
        run(directions);
        System.out.println("System zakończył działanie");
    }
    public static void run(Direction[] arguments){
        for (Direction argument : arguments){
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu";
                case LEFT -> "Zwierzak skręca w prawo";
                case RIGHT -> "Zwierzak skręca w lewo";
                default -> null;
            };
            if (message != null){
                System.out.println(message);
            }
        }
    }
}