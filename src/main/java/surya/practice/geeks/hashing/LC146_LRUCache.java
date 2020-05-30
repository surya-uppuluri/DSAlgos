package surya.practice.geeks.hashing;

import java.util.LinkedHashMap;
import java.util.Map;

class LC146_LRUCache {

  LinkedHashMap<Integer, Integer> elements;

  public LC146_LRUCache(int capacity) {
    this.elements = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
      protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
      }
    };
  }

  public int get(int key) {
    return elements.getOrDefault(key, -1);
  }

  public void put(int key, int value) {
    elements.put(key, value);
  }
}