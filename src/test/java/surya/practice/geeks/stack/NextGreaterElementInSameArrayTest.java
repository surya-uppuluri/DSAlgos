package surya.practice.geeks.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class NextGreaterElementInSameArrayTest {

  @Test
  void nextGreaterElement() {
    NextGreaterElementInSameArray greaterElementInSameArray = new NextGreaterElementInSameArray();
    int[] res = greaterElementInSameArray.nextGreaterElement(new int[]{5, 8, 1, 9, 3});
    assertEquals("[8, 9, 9, -1, -1]", Arrays.toString(res));
  }
}