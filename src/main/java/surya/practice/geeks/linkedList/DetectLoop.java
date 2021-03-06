package surya.practice.geeks.linkedList;

import java.util.HashSet;

public class DetectLoop {

    //@formatter:off
        //TODO - Have to fix this
    /**
     * ----------
     * ALGORITHM
     * ----------
     * 1.
     * 2.
     * =========================
     * Space Complexity - O()
     * Time Complexity - O()
     * =========================
     * Verdict:
     */
    //@formatter:on
    public boolean hasLoopNaive(SingleLinkedList singleLinkedList) {
     /*   Node head = singleLinkedList.getHead();
        if (head == null) return false;
        Node outerNode = head;
        for (int i = 0; i < singleLinkedList.getLength(); i++) {
            Node tempHead = head;
            Node innerNode = tempHead;

            for (int j = 0; j < i - 1; j++) {
                if (innerNode == outerNode)
                    return true;
                innerNode = innerNode.next;
            }
            outerNode = outerNode.next;

        }*/
        return false;
    }
    //@formatter:off
                /**
                * ----------
                * ALGORITHM
                * ----------
                * 1. Change the Node data structure to have an extra variable called visited.
                * =========================
                * Space Complexity - O(n)
                * Time Complexity - O(n)
                * =========================
                */
                //@formatter:on
                public boolean hasLoop_extraVariable(SingleLinkedList singleLinkedList) {

                    Node curr = singleLinkedList.getHead();
                    while (curr.next != null) {
                        if (curr.visited) return true;
                        curr.visited = true;
                        curr = curr.next;
                    }
                    return false;
                }

    //@formatter:off
                    /**
                    * ----------
                    * ALGORITHM
                    * ----------
                    * 1. Check if a Node has already been traversed using a hashset.
                    * =========================
                    * Space Complexity - O(n)
                    * Time Complexity - O(n)
                    * =========================
                     * Verdict: SLOW!
                     * Runtime: 3 ms, faster than 22.76% of Java online submissions for Linked List Cycle.
                     * Memory Usage: 41.5 MB, less than 5.71% of Java online submissions for Linked List Cycle.
                    */
                    //@formatter:on
                    public boolean hasLoop_hashing(SingleLinkedList singleLinkedList) {
                        Node head = singleLinkedList.getHead();
                        HashSet set = new HashSet();
                        while (head != null) {
                            if (!set.contains(head)) {
                                set.add(head);
                            } else
                                return true;
                            head = head.next;
                        }
                        return false;
                    }

    //@formatter:off
                                    /**
                                    * ----------
                                    * ALGORITHM
                                    * ----------
                                    * Floyd's loop detection algorithm
                                     *
                                     * 1. Use 2 pointers to traverse the loop - Fast one moves ahead of slow by 1 in each iteration.
                                     *      So, after 3 iterations distance between fast and slow will be 3
                                     * 2. If there's a loop, they'll coincide shortly after fast comes back to the loop element.
                                    * =========================
                                    * Space Complexity - O(1)
                                    * Time Complexity - O(n)
                                    * =========================
                                     * Verdict: FAST
                                     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
                                     * Memory Usage: 40.9 MB, less than 5.71% of Java online submissions for Linked List Cycle. //Looks like leetcode has a bug in
                                     * computing memory usage stats
                                    */
                                    //@formatter:on
                                    public boolean hasLoop_Floyd(SingleLinkedList singleLinkedList) {
                                        Node slow = singleLinkedList.getHead();
                                        Node fast = slow;

                                        while (fast != null && fast.next != null) {
                                            fast = fast.next.next;
                                            slow = slow.next;
                                            /**
                                             * Do comparision only after moving because, their initial point is same
                                             */
                                            if (fast == slow)
                                                return true;
                                        }

                                        return false;

                                    }

    //TODO - Logic/Implementation doesn't seem right because elements are meeting at 3, yet not being detected as same
    public Boolean removeLoop(SingleLinkedList singleLinkedList) {

        //Returns true if loop is detected and removed

        Node slow = singleLinkedList.getHead();
        Node fast = singleLinkedList.getHead();

        singleLinkedList.traverse();

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            /**
             * Do comparision only after moving because, their initial position is same
             */
            if (fast == slow)
                break;
        }

        if (slow != fast) return false;

        slow = singleLinkedList.getHead();
        while (slow != fast) {
            System.out.println("slow.data is :" + slow.data);
            System.out.println("fast.data is :" + fast.data);

            slow = slow.next;
            fast = fast.next;

            System.out.println("After move, slow.data is :" + slow.data);
            System.out.println("After move, fast.data is :" + fast.data);
        }

        fast.next.next = null;

        singleLinkedList.printLinkedList();

        return true;
    }
}
