package agh.ics.oop;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {
    private final IWorldMap map = new GrassField(10);
    @Test
    void _canMoveTo(){
        this.map.place(new Animal(this.map,new Vector2d(2,3)));
        this.map.place(new Animal(this.map,new Vector2d(7,3)));
        Assertions.assertFalse(this.map.canMoveTo(new Vector2d(2,3)));
        Assertions.assertFalse(this.map.canMoveTo(new Vector2d(7,3)));
        Assertions.assertTrue(this.map.canMoveTo(new Vector2d(10,3)));
        Assertions.assertTrue(this.map.canMoveTo(new Vector2d(-1,3)));
    }
    @Test
    void _place(){
        Assertions.assertTrue(this.map.place(new Animal(this.map,new Vector2d(2,3))));
        IllegalArgumentException arg = Assertions.assertThrows(IllegalArgumentException.class,() -> this.map.place(new Animal(this.map,new Vector2d(2,3))));
        Assertions.assertEquals("Position taken by animal on: (2,3)",arg.getMessage());
        Assertions.assertTrue(this.map.place(new Animal(this.map,new Vector2d(5,5))));
        Assertions.assertTrue(this.map.place(new Animal(this.map,new Vector2d(10,5))));
        Assertions.assertTrue(this.map.place(new Animal(this.map,new Vector2d(11,3))));
    }
    @Test
    void _isOccupied(){
        // Zależy od tego gdzie jest kępka trawy (wartości losowe) ~ nie sprawdzam potencjalnych pustych miejsc
        this.map.place(new Animal(this.map,new Vector2d(2,3)));
        this.map.place(new Animal(this.map,new Vector2d(7,3)));
        Assertions.assertTrue(this.map.isOccupied(new Vector2d(2,3)));
        Assertions.assertTrue(this.map.isOccupied(new Vector2d(7,3)));
        Assertions.assertFalse(this.map.isOccupied(new Vector2d(-1,3)));
    }
    @Test
    void _objectAt(){
        // Zależy od tego gdzie jest kępka trawy (wartości losowe) ~ nie sprawdzam potencjalnych pustych miejsc
        // Dodatkowo nie jestem w stanie sprawdzić gdzie jest trawa, bo pozycje są losowane
        Animal animal1 = new Animal(this.map,new Vector2d(2,3));
        Animal animal2 = new Animal(this.map,new Vector2d(4,5));
        this.map.place(animal1);
        this.map.place(animal2);
        Assertions.assertEquals(animal1,this.map.objectAt(new Vector2d(2,3)));
        Assertions.assertEquals(animal2,this.map.objectAt(new Vector2d(4,5)));
        Assertions.assertNull(this.map.objectAt(new Vector2d(-2,-2)));
    }
}
