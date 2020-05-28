package surya.practice.geeks.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC1047_RemoveAllAdjacentDuplicatesInStringTest {

  LC1047_RemoveAllAdjacentDuplicatesInString adjacentDuplicatesInString = new LC1047_RemoveAllAdjacentDuplicatesInString();

  @Test
  void removeDuplicates() {
    String resp = adjacentDuplicatesInString.removeDuplicatesUsingStack("abbaca");
    assertEquals("ca", resp);
  }

  @Test
  void removeDuplicatesWithStringManipulation() {
    String resp = adjacentDuplicatesInString.removeDuplicatesWithStringManipulation("abbaca");
    assertEquals("ca", resp);
  }
}