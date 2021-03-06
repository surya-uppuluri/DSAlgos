package surya.practice.geeks.linkedList.leetCode;

import surya.practice.geeks.linkedList.ListNode;

import java.util.HashSet;
//@formatter:off
/**
 * ----------PROBLEM STATEMENT-----------
 *LC160. Intersection of Two Linked Lists
 Write a program to find the node at which the intersection of two singly linked lists begins.

 For example, the following two linked lists:

 begin to intersect at node c1.



 Example 1:

 Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 Output: Reference of the node with value = 8
 Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.



 Example 2:

 Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 Output: Reference of the node with value = 2
 Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.



 Example 3:

 Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 Output: null
 Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 Explanation: The two lists do not intersect, so return null.



 Notes:

 If the two linked lists have no intersection at all, return null.
 The linked lists must retain their original structure after the function returns.
 You may assume there are no cycles anywhere in the entire linked structure.
 Your code should preferably run in O(n) time and use only O(1) memory.
  */
//@formatter:on

/**
 * Way1- Naive
 * ----------
 * ALGORITHM
 * ----------
 * 1. Store all nodes of A in hashset
 * 2. Find them while traversing B.
 * =========================
 * Space Complexity - O(m)
 * Time Complexity - O(m)+O(n)
 * =========================
 * m = size of list1, n = size of list2
 * Verdict: VERY SLOW and uses extra space which shouldn't be so.
 * Runtime: 7 ms, faster than 26.61% of Java online submissions for Intersection of Two Linked Lists.
 * Memory Usage: 44.7 MB, less than 5.71% of Java online submissions for Intersection of Two Linked Lists.
 */


public class IntersectionFinder {

    public ListNode getIntersectionNodeNaive(ListNode headA, ListNode headB) {
        HashSet<ListNode> res = new HashSet();
        while (headA != null) {
            res.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (res.contains(headB)) return headB;
            else headB = headB.next;
        }
        return null;
    }

    /**
     * Way2- Efficient using differences in length
     * ----------
     * ALGORITHM
     * ----------
     * 1. Find differences in the lengths of the lists.
     * 2. Traverse the larger list about the length of the difference.
     * 3. Start comparing henceforth.
     * =========================
     * Time Complexity - O(n)+O(n)+O(n-m) = O(n)
     * Space Complexity - O(1)
     * =========================
     * VERDICT: FAST!
     * Runtime: 1 ms, faster than 99.05% of Java online submissions for Intersection of Two Linked Lists.
     * Memory Usage: 42.1 MB, less than 5.71% of Java online submissions for Intersection of Two Linked Lists.
     */

    public ListNode getIntersectionNodeEfficient(ListNode headA, ListNode headB) {
        ListNode ha = headA, hb = headB;
        int lenA = 0, lenB = 0;
        while (headA != null) {
            headA = headA.next;
            lenA++;
        }

        while (headB != null) {
            headB = headB.next;
            lenB++;
        }

        int diff = Math.abs(lenA - lenB);
        if (lenA > lenB)
            for (lenA = 0; lenA < diff; lenA++)
                ha = ha.next;
        else if (lenB > lenA)
            for (lenB = 0; lenB < diff; lenB++)
                hb = hb.next;

        while (ha != null && hb != null) {
            if (ha == hb) return ha;
            else {
                ha = ha.next;
                hb = hb.next;
            }
        }

        return null;
    }
}
