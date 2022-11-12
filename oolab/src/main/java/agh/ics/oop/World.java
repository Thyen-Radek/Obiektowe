package agh.ics.oop;

import java.util.HashMap;
import java.util.Map;

public class World {
    public static void main(String[] args) {
        System.out.println("System wystartował");
        MoveDirection[] directions = new OptionsParser().parse(args);
        AbstractWorldMap map = new GrassField(10);
        AbstractWorldMap map2 = new RectangularMap(10,5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        IEngine engine2 = new SimulationEngine(directions, map2, positions);
        engine.run();
        engine2.run();
        System.out.println(map);
        System.out.println(map2);
        System.out.println("System zakończył działanie");
    }
}