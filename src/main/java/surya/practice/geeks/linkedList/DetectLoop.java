package surya.practice.geeks.linkedList;

public class DetectLoop {

    //@formatter:off

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
        Node head = singleLinkedList.getHead();
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

        }
        return false;
    }

}
