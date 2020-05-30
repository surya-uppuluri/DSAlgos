package surya.practice.geeks.sorting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class CollectionsSortingTest {

  @Test
  public void hashMapSorting() {
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    hashMap.put(1, 5);
    hashMap.put(2, 1);
    hashMap.put(10, 0);
    hashMap.put(3, -1);
    Map<Integer, Integer> result = hashMap.entrySet().stream().sorted(Entry.comparingByValue())
        .limit(2).collect(Collectors.toMap(
            Entry::getKey, Entry::getValue));
    List<Integer> positionIndices = hashMap.entrySet().stream().sorted(Entry.comparingByValue())
        .limit(2).map(e -> e.getKey()).collect(Collectors.toList());
    System.out.println(result.toString());
    System.out.println(positionIndices);
  }
}
