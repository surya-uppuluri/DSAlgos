package surya.practice.geeks.arrays;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class NextLargerElementUsingStackAndMap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            long a[] = new long[n];

            String s[] = br.readLine().split(" ");

            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(s[i]);
            }

            findNextLargerElement(a, n);
        }
    }
	
	        /*Algorithm:
	         **1)While the stack is not empty and the current_element_array
	         is greater than the top_element_of _stack(Basically stack should
	         be sorted ,otherwise pop). Keep popping the 
	         top_element_of _stack.Here,current_array_element is the next
	         greatest element of the top_element_of _stack.
	         2)When popping store this in HashMap as such a 
	         pair: (x, next greatest element of x).
	         **3)Now push current_array_element to the stack.
	         4)Now iterate through the array and get the next greatest element 
	         of i , if the next greatest doesn't exist then get it as -1 by default. */

    static void findNextLargerElement(long a[], int n) {
        Stack<Long> stk = new Stack<>();
        HashMap<Long, Long> map = new HashMap<>();   //map -> (x , next greatest element of x)

        for (int i = 0; i < n; i++) {
            while (!stk.isEmpty() && a[i] > stk.peek()) map.put(stk.pop(), a[i]);

            stk.push(a[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(map.getOrDefault(a[i], (long) -1) + " ");
        }
        System.out.println();
    }
}