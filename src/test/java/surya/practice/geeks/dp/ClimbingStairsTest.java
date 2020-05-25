package surya.practice.geeks.dp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClimbingStairsTest {
    ClimbingStairs climbingStairs;

    @BeforeEach
    void createStairsObj() {
        climbingStairs = new ClimbingStairs();
    }

    @Test
    void stairs() {
        assertEquals(1836311903, climbingStairs.stairsRecursion(45));
    }

    @Test
    void stairsDp() {
        assertEquals(1836311903, climbingStairs.stairsRecursion(45));
    }
}