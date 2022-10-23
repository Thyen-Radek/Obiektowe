package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {
    private final OptionsParser parser = new OptionsParser();
    private final String[] array_1 = new String[]{"r","f","blsdik","f","b","dloool","l","forward","b"};
    @Test
    void _parse(){
        MoveDirection[] moves_1 = parser.parse(array_1);
        int k = 0;
        for (String s : array_1) {
            MoveDirection move = switch (s) {
                case "r", "right" -> MoveDirection.RIGHT;
                case "l", "left" -> MoveDirection.LEFT;
                case "b", "backward" -> MoveDirection.BACKWARD;
                case "f", "forward" -> MoveDirection.FORWARD;
                default -> null;
            };
            if (move != null) {
                Assertions.assertEquals(move, moves_1[k]);
            } else {
                k -= 1;
            }
            k += 1;
        }
//
    }
}
