package surya.practice.geeks.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class LC496NextGreaterElementTest {

  LC496_NextGreaterElement LC496NextGreaterElement = new LC496_NextGreaterElement();

  @Test
  void nextGreaterElementWithHashMap1() {
    int[] res = LC496NextGreaterElement
        .nextGreaterElementWithHashMap(new int[]{1, 3, 5, 2, 4}, new int[]
            {5, 4, 3, 2, 1
            });

    assertEquals("[-1, -1, -1, -1, -1]", Arrays.toString(res));

  }

  @Test
  void nextGreaterElementWithHashMap2() {
    int[] res = LC496NextGreaterElement
        .nextGreaterElementWithHashMap(new int[]{4, 1, 2}, new int[]
            {1, 3, 4, 2
            });

    assertEquals("[-1, 3, -1]", Arrays.toString(res));

  }

  @Test
  void nextGreaterElementWithStack1() {
    int[] res = LC496NextGreaterElement
        .nextGreaterElementWithStack(new int[]{1, 3, 5, 2, 4}, new int[]
            {5, 4, 3, 2, 1
            });

    assertEquals("[-1, -1, -1, -1, -1]", Arrays.toString(res));

  }

  @Test
  void nextGreaterElementWithStack2() {
    int[] res = LC496NextGreaterElement
        .nextGreaterElementWithStack(new int[]{4, 1, 2}, new int[]
            {1, 3, 4, 2
            });

    assertEquals("[-1, 3, -1]", Arrays.toString(res));

  }
}