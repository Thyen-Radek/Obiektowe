package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        String[] move = new String[]{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(move);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(1,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        System.out.println(map);
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