package surya.practice.geeks.linkedList.leetCode;

import org.junit.jupiter.api.Test;
import surya.practice.geeks.linkedList.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static surya.practice.geeks.leetCodeUtils.LinkedListUtils.listNodeToString;
import static surya.practice.geeks.leetCodeUtils.LinkedListUtils.stringToListNode;

class MergeListsTest {

    @Test
    void mergeTwoSortedListsIteratively() {
        ListNode listA = stringToListNode("[1,2,3,4,5]");
        ListNode listB = stringToListNode("[2,4,6,11,19,54]");
        MergeLists mergeLists = new MergeLists();
        ListNode listNode = mergeLists.mergeTwoSortedListsIteratively(listA, listB);
        String out = listNodeToString(listNode);
        assertEquals("[1, 2, 2, 3, 4, 4, 5, 6, 11, 19, 54]", out);
    }

    @Test
    void mergeTwoSortedListsRecursively() {
        ListNode listA = stringToListNode("[1,2,3,4,5]");
        ListNode listB = stringToListNode("[2,4,6,11,19,54]");
        MergeLists mergeLists = new MergeLists();
        ListNode listNode = mergeLists.mergeTwoSortedListsRecursively(listA, listB);
        String out = listNodeToString(listNode);
        assertEquals("[1, 2, 2, 3, 4, 4, 5, 6, 11, 19, 54]", out);
    }

}