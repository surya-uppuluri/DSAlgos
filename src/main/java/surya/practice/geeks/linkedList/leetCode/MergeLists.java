package surya.practice.geeks.linkedList.leetCode;

import surya.practice.geeks.linkedList.ListNode;

public class MergeLists {

    /**
     * ----------PROBLEM STATEMENT-----------
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     * Example:
     * Input: 1->2->4, 1->3->4
     * Output: 1->1->2->3->4->4
     ---------------------------------------------
     */

    /**
     * ----------
     * ALGORITHM
     * ----------
     * 1. While both the listNodes are not null, take the smallest and move the corresponding list's node ahead
     * 2. Finally append the remainders of list that's not yet completely traversed.
     * =========================
     * Time Complexity - O(n)
     * Space Complexity - O(n) //dummy list has the size as sum of sizes of the lists.
     * =========================
     */

    public ListNode mergeTwoSortedListsIteratively(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                dummy.next = l2;
                dummy = dummy.next;
                l2 = l2.next;
            } else {
                dummy.next = l1;
                dummy = dummy.next;
                l1 = l1.next;
            }
        }


//No need to iterate here. Just point the next of dummy to remainder of the list
        if (l1 != null) {
            dummy.next = l1;
        }
        if (l2 != null) {
            dummy.next = l2;
        }
        return temp.next;
    }

    /**
     * ----------
     * ALGORITHM
     * ----------
     * 1.
     * =========================
     * Time Complexity - O(n)
     * Space Complexity - O(n) in stack
     * =========================
     */

    public ListNode mergeTwoSortedListsRecursively(ListNode l1, ListNode l2) {
//base case
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoSortedListsRecursively(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoSortedListsRecursively(l1, l2.next);
            return l2;
        }

    }
}
