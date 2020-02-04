package surya.practice.geeks.linkedList;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static surya.practice.geeks.leetCodeUtils.LinkedListUtils.listNodeToString;
import static surya.practice.geeks.leetCodeUtils.LinkedListUtils.stringToListNode;

class PairWiseSwapTest {

    @Test
    @DisplayName("Swap Pairs using swap of data")
    void swapPairs() {
        ListNode head = stringToListNode("[1,2,3,4]");

        ListNode ret = new PairWiseSwap().swapPairs(head);

        String out = listNodeToString(ret);

        assertEquals("[2, 1, 4, 3]", out);
    }


    @Test
    @DisplayName("Swap Pairs using link changes")
    void swapPairsWithLinkChanges() {
        ListNode head = stringToListNode("[1,2,3,4]");

        ListNode ret = new PairWiseSwap().swapPairsWithLinkChanges(head);

        String out = listNodeToString(ret);

        assertEquals("[2, 1, 4, 3]", out);
    }


}