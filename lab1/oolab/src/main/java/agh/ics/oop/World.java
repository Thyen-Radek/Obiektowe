package agh.ics.oop;

public class World {

    public static void main(String[] args) {
        int counter = 0;
        String[] move = new String[]{"f","l","b","r"};
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
        int counter = 0;
//        System.out.println("Idzie w przód");
//        System.out.println(arguments.length);
        for (Direction argument : arguments){
            counter ++;
//            if (counter != arguments.length){
//                argument += ",";
//            }
            String message = switch (argument) {
                case FORWARD -> "Do przodu";
                case BACKWARD -> "Do tyłu";
                case LEFT -> "W lewo";
                case RIGHT -> "W prawo";
                default -> "Nieznana komenda";
            };
            System.out.println(message);

        }
    }

}