package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Vector2dTest {
    @Test
    public void _equals(){
        System.out.println("----Test metody equals----");
        Vector2d vec1 = new Vector2d(1,1);
        Vector2d vec2 = new Vector2d(1,1);
        Vector2d vec3 = new Vector2d(2,7);
        MapDirection dire = MapDirection.NORTH;
        Assertions.assertTrue(vec1.equals(vec1));
        Assertions.assertFalse(vec1.equals(dire));
        Assertions.assertTrue(vec1.equals(vec2));
        Assertions.assertFalse(vec1.equals(vec3));
    }
    @Test
    public void _toString() {
        System.out.println("----Test metody toString----");
        Vector2d vec1 = new Vector2d(1,1);
        String name = vec1.toString();
        Assertions.assertEquals(name,"(1,1)");
    }
    @Test
    public void _precedes(){
        System.out.println("----Test metody precedes----");
        Vector2d vec1 = new Vector2d(1,1);
        Vector2d vec2 = new Vector2d(2,2);
        Vector2d vec3 = new Vector2d(1,3);
        Assertions.assertTrue(vec1.precedes(vec2));
        Assertions.assertTrue(vec1.precedes(vec3));
        Assertions.assertFalse(vec3.precedes(vec2));
        Assertions.assertFalse(vec2.precedes(vec3));
    }
    @Test
    public void _follows(){
        System.out.println("----Test metody follows----");
        Vector2d vec1 = new Vector2d(7,7);
        Vector2d vec2 = new Vector2d(2,5);
        Vector2d vec3 = new Vector2d(4,1);
        Assertions.assertTrue(vec1.follows(vec2));
        Assertions.assertTrue(vec1.follows(vec3));
        Assertions.assertFalse(vec3.follows(vec2));
        Assertions.assertFalse(vec2.follows(vec3));
    }
    @Test
    public void _upperRight(){
        System.out.println("----Test metody upperRight----");
        Vector2d vec1 = new Vector2d(1,7);
        Vector2d vec2 = new Vector2d(4,5);
        Vector2d vec_combined = vec1.upperRight(vec2);
        Assertions.assertEquals(vec_combined.x , 4);
        Assertions.assertEquals(vec_combined.y , 7);
    }
    @Test
    public void _lowerLeft(){
        System.out.println("----Test metody lowerLeft----");
        Vector2d vec1 = new Vector2d(1,7);
        Vector2d vec2 = new Vector2d(4,5);
        Vector2d vec_combined = vec1.lowerLeft(vec2);
        Assertions.assertEquals(vec_combined.x , 1);
        Assertions.assertEquals(vec_combined.y , 5);
    }
    @Test
    public void _add(){
        System.out.println("----Test metody add----");
        Vector2d vec1 = new Vector2d(1,7);
        Vector2d vec2 = new Vector2d(4,5);
        Vector2d vec_combined = vec1.add(vec2);
        Assertions.assertEquals(vec_combined.x , 5);
        Assertions.assertEquals(vec_combined.y , 12);
    }
    @Test
    public void _subtract(){
        System.out.println("----Test metody subtract----");
        Vector2d vec1 = new Vector2d(1,7);
        Vector2d vec2 = new Vector2d(4,5);
        Vector2d vec_combined = vec1.subtract(vec2);
        Assertions.assertEquals(vec_combined.x , -3);
        Assertions.assertEquals(vec_combined.y , 2);
    }
    @Test
    public void _opposite(){
        System.out.println("----Test metody opposite----");
        Vector2d vec1 = new Vector2d(3,7);
        Vector2d vec_combined = vec1.opposite();
        Assertions.assertEquals(vec_combined.x , 7);
        Assertions.assertEquals(vec_combined.y , 3);
    }
}
