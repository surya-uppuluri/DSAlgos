package surya.practice.geeks.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

class LC937_KClosestPointsToOrigin {

  /**
   * Runtime: 46 ms, faster than 19.90% of Java online submissions for K Closest Points to Origin.
   * Memory Usage: 48.2 MB, less than 100.00% of Java online submissions for K Closest Points to Origin.
   * Next challenges:
   * @param points
   * @param K
   * @return
   */
  public int[][] kClosestWithMap(int[][] points, int K) {
    HashMap<Integer, Integer> map = new HashMap<>();
    int dist = 0;
    for (int i = 0; i < points.length; i++) {
      dist = points[i][0] * points[i][0] + points[i][1] * points[i][1];
      map.put(i, dist);
    }
    List<Integer> positionIndices = map.entrySet().stream().sorted(Entry.comparingByValue())
        .limit(K).map(Entry::getKey).collect(Collectors.toList());
    int[][] res = new int[K][2];
    for (int i = 0; i < positionIndices.size(); i++) {
      res[i][0] = points[positionIndices.get(i)][0];
      res[i][1] = points[positionIndices.get(i)][1];
    }
    return res;
  }

  /**
   * Runtime: 25 ms, faster than 59.59% of Java online submissions for K Closest Points to Origin.
   * Memory Usage: 47.6 MB, less than 100.00% of Java online submissions for K Closest Points to
   * Origin. Next challenges:
   *
   * @param points
   * @param K
   * @return
   */
  public int[][] kClosestWithArrays(int[][] points, int K) {
    int[][] res = new int[K][2];
    if (points.length == 0) {
      return res;
    }
    Arrays.sort(points, Comparator.comparingInt(a -> (a[0] * a[0] + a[1] * a[1])));
    System.arraycopy(points, 0, res, 0, K);
    return res;
  }
}