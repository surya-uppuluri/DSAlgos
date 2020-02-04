package surya.practice.geeks.linkedList.leetCode;

import surya.practice.geeks.linkedList.ListNode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//@formatter:off

/**
 * ------------------
 * PROBLEM STATEMENT
 * ------------------
 * LC1290. Convert Binary Number in a Linked List to Integer
 * Easy
 *
 * 145
 *
 * 14
 *
 * Add to List
 *
 * Share
 * Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */
//@formatter:on

class BinaryToDecimal {
    //@formatter:off

    /**
     * ----------
     * ALGORITHM
     * ----------
     * 1. Reverse the list first.
     * 2. Multiply accordingly in increasing manner of power
     * =========================
     * Space Complexity - O(1)
     * Time Complexity - O(n)
     * =========================
     * Verdict:Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
     * Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
     */
    //@formatter:on
    public int getDecimalValue(ListNode head) {
        head = reverseLL(head);
        ListNode mover = head;
        int i = 0, res = 0;
        while (mover != null) {
            res += (mover.val) * (Math.pow(2, i));
            mover = mover.next;
            i++;
        }
        return res;
    }

    //@formatter:off

    /**
     * ----------
     * ALGORITHM
     * ----------
     * Straight forward.*
     * =========================
     * Space Complexity - O(1)
     * Time Complexity - O(n)
     * =========================
     * Verdict:
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.
     * Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Convert Binary Number in a Linked List to Integer.* /
     */
        //@formatter:on
    public int getDecimalValueUsingLength(ListNode head) {

        int len = 0, res = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        temp = head;
        while (len > 0) {
            res += Math.pow(2, len - 1) * (temp.val);
            temp = temp.next;
            len--;
        }
        return res;
    }

    public ListNode reverseLL(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode ptr = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ptr;
        }

        head = prev;

        return head;
    }
}

public class BinaryToDecimalDriver {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static ListNode stringToListNode(String input) {
        int[] nodeValues = stringToIntegerArray(input);

        // Now convert that list into linked list
        ListNode dummyRoot = new ListNode(0);
        ListNode ptr = dummyRoot;
        for (int item : nodeValues) {
            ptr.next = new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            ListNode head = stringToListNode(line);

            int ret = new BinaryToDecimal().getDecimalValue(head);

            String out = String.valueOf(ret);

            System.out.print(out);


            int ret1 = new BinaryToDecimal().getDecimalValueUsingLength(head);

            String out1 = String.valueOf(ret);

            System.out.print(out1);
        }
    }
}