package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class MapDirectionTest {
    @Test
    public void _next(){
        System.out.println("----Test metody next----");
        MapDirection[] directions = new MapDirection[]{MapDirection.EAST,MapDirection.SOUTH,MapDirection.WEST,MapDirection.NORTH};
        MapDirection direct = MapDirection.NORTH;
        for (int i = 0; i < 4; i++) {
            direct = direct.next();
            Assertions.assertEquals(direct,directions[i]);
        }

    }
    @Test
    public void _previous(){
        System.out.println("----Test metody previous----");
        MapDirection[] directions = new MapDirection[]{MapDirection.WEST,MapDirection.SOUTH,MapDirection.EAST,MapDirection.NORTH};
        MapDirection direct = MapDirection.NORTH;
        for (int i = 0; i < 4; i++) {
            direct = direct.previous();
            Assertions.assertEquals(direct,directions[i]);
        }

    }
}
