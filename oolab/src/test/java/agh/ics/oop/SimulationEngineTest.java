package agh.ics.oop;

import agh.ics.oop.gui.App;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
public class SimulationEngineTest {
    private final Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
    private final Vector2d[] positions2 = { new Vector2d(2,2), new Vector2d(3,4),new Vector2d(4,2) };
    App renderer = null;
    @Test
    void _run1(){
        String[] move1 = new String[]{"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions1 = new OptionsParser().parse(move1);
        AbstractWorldMap map = new RectangularMap(10, 5);
        IEngine engine = new SimulationEngine(directions1, map, positions,renderer);
        engine.run();
        Assertions.assertTrue(map.isOccupied(new Vector2d(3,5)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(2,0)));
    }
    @Test
    void _run2(){
        String[] move2 = new String[]{"f","b","r","r","f","f","b","l","f","f","f","l","b","f"};
        MoveDirection[] directions2 = new OptionsParser().parse(move2);
        AbstractWorldMap map = new RectangularMap(10, 5);
        IEngine engine = new SimulationEngine(directions2, map, positions,renderer);
        engine.run();
        Assertions.assertTrue(map.isOccupied(new Vector2d(2,3)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(3,4)));
    }
    @Test
    void _run3(){
        String[] move3 = new String[]{"f","l","r","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions3 = new OptionsParser().parse(move3);
        AbstractWorldMap map = new RectangularMap(10, 5);
        IEngine engine = new SimulationEngine(directions3, map, positions2,renderer);
        engine.run();
        Assertions.assertTrue(map.isOccupied(new Vector2d(2,5)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(0,4)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(10,2)));
    }
}
