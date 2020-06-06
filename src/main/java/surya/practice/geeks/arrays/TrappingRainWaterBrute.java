package surya.practice.geeks.arrays;

class TrappingRainWater {

  /**
   * Runtime: 62 ms, faster than 5.55% of Java online submissions for Trapping Rain Water. Memory
   * Usage: 39.5 MB, less than 24.39% of Java online submissions for Trapping Rain Water.
   *
   * @param height
   * @return
   */
  public int trapBruteForce(int[] height) {

    int max = 0;
        
        /*Algorithm: Brute Force
        1. Traverse through each element in array and
        compute the max(left height) and max(right height)
        2. max+= min(right,left) - currHt
        3. Repeat 1 & 2 until the end
        */

    int width = height.length;

    for (int i = 1; i < width - 1; i++) {
      int l_max = 0;
      int r_max = 0;

      for (int j = i; j >= 0; j--) {
        l_max = Math.max(height[j], l_max);
      }

      for (int j = i; j < width; j++) {
        r_max = Math.max(r_max, height[j]);
      }

      max += Math.min(r_max, l_max) - height[i];
    }

    return max;

  }


  public int trapDP(int[] height) {

    int ans = 0;

    int width = height.length;

    if (width == 0) {
      return 0;
    }

        /*Algo: Dynamic Programming
        Instead of calculating l_max and r_max each time, calculate l_max and r_max up to that position
        and store them*/

    int lma[] = new int[width];
    int rma[] = new int[width];

    lma[0] = height[0];
    rma[width - 1] = height[width - 1];

    //0 is already covered and provides the base for DP
    for (int i = 1; i < width; i++) {
      lma[i] = Math.max(height[i], lma[i - 1]);
    }

    for (int i = width - 2; i >= 0; i--) {
      rma[i] = Math.max(height[i], rma[i + 1]);
    }

    for (int i = 0; i < width; i++) {

      ans += Math.min(lma[i], rma[i]) - height[i];
    }

    return ans;
  }

  public int trap2Pointer(int[] height) {
    //algo - 2 pointer technq

    int ans = 0;

    int left = 0;
    int right = height.length - 1;

    int width = height.length;

    if (width == 0) {
      return 0;
    }

    int lmax = height[0];
    int rmax = height[width - 1];

    while (left <= right) {
      lmax = Math.max(lmax, height[left]);
      rmax = Math.max(rmax, height[right]);

      if (lmax < rmax) {
        ans += lmax - height[left];
        left++;
      } else {
        ans += rmax - height[right];
        right--;
      }
    }

    return ans;
  }

}