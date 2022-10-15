package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    String str = "test";
    Vector2d[] v = new Vector2d[]{
            new Vector2d(1,2),
            new Vector2d(3,5),
            new Vector2d(-3,1),
            new Vector2d(1,2)
    };
    @Test
    void _equals(){
        System.out.println("----Test metody equals----");
        Assertions.assertTrue(v[0].equals(v[0]));
        Assertions.assertFalse(v[0].equals(str));
        Assertions.assertFalse(v[0].equals(v[1]));
        Assertions.assertFalse(v[0].equals(v[2]));
        Assertions.assertTrue(v[0].equals(v[3]));
    }
    @Test
    void _toString() {
        System.out.println("----Test metody toString----");
        for (Vector2d vector2d : v) {
            Assertions.assertEquals(vector2d.toString(), "(" + vector2d.x + "," + vector2d.y + ")");
        }

    }
    @Test
    void _precedes(){
        System.out.println("----Test metody precedes----");
        for(int i = 0; i < v.length-1; i++) {
            if (v[i].x <= v[i+1].x && v[i].y <= v[i+1].y) {
                Assertions.assertTrue(v[i].precedes(v[i+1]));
            }
            else{
                Assertions.assertFalse(v[i].precedes(v[i+1]));
            }
        }
    }
    @Test
    void _follows(){
        System.out.println("----Test metody follows----");
        for(int i = 0; i < v.length-1; i++) {
            if (v[i].x >= v[i+1].x && v[i].y >= v[i+1].y) {
                Assertions.assertTrue(v[i].follows(v[i+1]));
            }
            else{
                Assertions.assertFalse(v[i].follows(v[i+1]));
            }
        }
    }
    @Test
    void _upperRight(){
        System.out.println("----Test metody upperRight----");
        int x,y;
        for(int i = 0; i < v.length-1; i++) {
            x = Math.max(v[i].x,v[i+1].x);
            y = Math.max(v[i].y,v[i+1].y);
            Assertions.assertEquals(v[i].upperRight(v[i+1]),new Vector2d(x,y));
        }
    }
    @Test
    void _lowerLeft(){
        System.out.println("----Test metody lowerLeft----");
        int x,y;
        for(int i = 0; i < v.length-1; i++) {
            x = Math.min(v[i].x,v[i+1].x);
            y = Math.min(v[i].y,v[i+1].y);
            Assertions.assertEquals(v[i].lowerLeft(v[i+1]),new Vector2d(x,y));
        }
    }
    @Test
    void _add(){
        System.out.println("----Test metody add----");
        int x,y;
        for(int i = 0; i < v.length-1; i++) {
            x = v[i].x + v[i+1].x;
            y = v[i].y + v[i+1].y;
            Assertions.assertEquals(v[i].add(v[i+1]),new Vector2d(x,y));
        }
    }
    @Test
    void _subtract(){
        System.out.println("----Test metody subtract----");
        int x,y;
        for(int i = 0; i < v.length-1; i++) {
            x = v[i].x - v[i+1].x;
            y = v[i].y - v[i+1].y;
            Assertions.assertEquals(v[i].subtract(v[i+1]),new Vector2d(x,y));
        }
    }
    @Test
    void _opposite(){
        System.out.println("----Test metody opposite----");
        int x,y;
        for(int i = 0; i < v.length-1; i++) {
            x = -v[i].x;
            y = -v[i].y;
            Assertions.assertEquals(v[i].opposite(),new Vector2d(x,y));
        }
    }
}
