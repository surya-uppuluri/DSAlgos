package surya.practice.geeks.linkedList.leetCode;

import org.junit.jupiter.api.Test;
import surya.practice.geeks.linkedList.ListNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static surya.practice.geeks.leetCodeUtils.LinkedListUtils.listNodeToString;
import static surya.practice.geeks.leetCodeUtils.LinkedListUtils.stringToListNode;

class IntersectionFinderTest {

    @Test
    void getIntersectionNode() {

        ListNode listA = stringToListNode("[4,1,8,4,5]");
        ListNode listB = stringToListNode("[5,0,1,8,4,5]");
        int intersectVal = 8;
        modifyListsToFormChain(listA, listB, intersectVal);
        ListNode ret = new IntersectionFinder().getIntersectionNodeNaive(listA, listB);
        String out = listNodeToString(ret);
        assertEquals(String.valueOf(intersectVal), out.replaceAll("\\[", "").split(",")[0]);

    }

    //myCustomMethod
    private void modifyListsToFormChain(ListNode listA, ListNode listB, int intersectVal) {

        ListNode interNode = listA;
        ListNode temp = listA;
        while (temp.val != intersectVal)
            temp = temp.next;
        interNode = temp;

        temp = listB;

        while ((temp.next.val != intersectVal))
            temp = temp.next;
        temp.next = interNode;
    }

    @Test
    void getIntersectionNodeEfficient() {

        ListNode listA = stringToListNode("[4,1,8,4,5]");
        ListNode listB = stringToListNode("[5,0,1,8,4,5]");
        int intersectVal = 8;
        modifyListsToFormChain(listA, listB, intersectVal);
        ListNode ret = new IntersectionFinder().getIntersectionNodeEfficient(listA, listB);
        String out = listNodeToString(ret);
        assertEquals(String.valueOf(intersectVal), out.replaceAll("\\[", "").split(",")[0]);
    }
}