package surya.practice.geeks.linkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


public class PairWiseSwap {

    //@formatter:off
                    /**
                    * ----------
                    * ALGORITHM
                    * ----------
                    * 1. A simple swap of data in adjacent elements followed by moving the curr pointer by 2 nodes
                     * 2. Can also be done using mod logic and one node move instead of 2 nodes, but inefficient.
                    * =========================
                    * Space Complexity - O(1)
                    * Time Complexity - O(n)
                    * =========================
                     * Verdict: Efficient but not recommended when data is not a simple type i.e., data can be a huge object.
                     * Swapping such huge object could be inefficient in memory perspective.
                     * We can try changing pointer links instead.
                    */
                    //@formatter:on
                    public ListNode swapPairs(ListNode head) {
                        ListNode curr = head;
                        while (curr != null && curr.next != null) {
                            int temp = curr.val;
                            curr.val = curr.next.val;
                            curr.next.val = temp;
                            curr = curr.next.next;
                        }
                        return head;
                    }

    //TODO - REVISE again, very tricky to not go on a cyclic loop
    public ListNode swapPairsWithLinkChanges(ListNode head) {
        ListNode curr = head.next.next;
        ListNode prev = head;
        head = head.next;
        head.next = prev;

        while (curr != null && curr.next != null) {

            prev.next = curr.next;
            prev = curr;
            ListNode next = curr.next.next;
            curr.next.next = curr;
            curr = next;

        }
        prev.next = curr;
        return head;
    }
}