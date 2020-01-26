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
        for (int i = 0; i < singleLinkedList.getLength(); i++) {
            Node outerNode = head.next;
            System.out.println("Outer at: "+ outerNode.data);
            Node tempHead = head;
            for (int j = i; j < singleLinkedList.getLength(); j++) {
                Node innerNode = tempHead.next;
                if (innerNode.next == outerNode)
                    return true;
            }
        }
        return false;
    }

}
