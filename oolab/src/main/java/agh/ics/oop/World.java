package agh.ics.oop;
import java.util.Arrays;
public class World {

    public static void main(String[] args) {
        System.out.println("System wystartował");
        OptionsParser parsing = new OptionsParser();
        String[] move = new String[]{"f","f","b","r","g","f","h","f","f"};
        Animal animal = new Animal();
        System.out.println("Startowa pozycja");
        System.out.println(animal);
        MoveDirection[] send = parsing.parse(move);
//        animal.move(MoveDirection.RIGHT);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.FORWARD);
//        animal.move(MoveDirection.FORWARD);
//        System.out.println(animal);
        run(send,animal);
        System.out.println("System zakończył działanie");
    }
    public static void run(MoveDirection[] arguments,Animal animal){
        for (MoveDirection argument : arguments){
            String message = switch (argument) {
                case FORWARD -> "Zwierzak idzie do przodu";
                case BACKWARD -> "Zwierzak idzie do tyłu" ;
                case RIGHT -> "Zwierzak skręca w prawo" ;
                case LEFT -> "Zwierzak skręca w lewo";
            };
            animal.move(argument);
            System.out.println(message);
            System.out.println(animal);
        }
    }
}