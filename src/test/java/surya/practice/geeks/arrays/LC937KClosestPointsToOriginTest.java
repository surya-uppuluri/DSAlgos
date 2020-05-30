package surya.practice.geeks.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LC937KClosestPointsToOriginTest {
  LC937_KClosestPointsToOrigin pointsToOrigin = new LC937_KClosestPointsToOrigin();

  @Test
  void kClosestWithMap() {
    int[][] ints = pointsToOrigin.kClosestWithMap(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
    assertEquals("[[3, 3], [-2, 4]]", Arrays.deepToString(ints));
  }


  @Test
  void kClosestWithArrays() {
    int[][] ints = pointsToOrigin.kClosestWithArrays(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
    assertEquals("[[3, 3], [-2, 4]]", Arrays.deepToString(ints));
  }
}