package surya.practice.geeks.stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementInSameArray {

  public int[] nextGreaterElement(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    HashMap<Integer, Integer> hashMap = new HashMap<>();
    for (int value : arr) {
      while (!stack.isEmpty() && value > stack.peek()) {
        hashMap.put(stack.pop(), value);
      }
      stack.push(value);
    }

    for (int i = 0; i < arr.length; i++) {
      arr[i] = hashMap.getOrDefault(arr[i], -1);
    }

    return arr;


  }
}
