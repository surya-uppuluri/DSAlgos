package surya.practice.geeks.hashing;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class LC_146LRUCache_DLL_HMTest {

  LC_146LRUCache_DLL_HM cache = new LC_146LRUCache_DLL_HM(2);

  @Test
  void get() {
    cache.put(1, 1);
    cache.put(2, 2);
    assertEquals(1, cache.get(1));       // returns 1
    cache.put(3, 3);    // evicts key 2
    assertEquals(-1, cache.get(2));     // returns -1 (not found)
    cache.put(4, 4);    // evicts key 1
    assertEquals(-1, cache.get(1));       // returns -1 (not found)
    assertEquals(3, cache.get(3));        // returns 3
    assertEquals(4, cache.get(4));         // returns 4
  }

}