package com.nvgrig.coding.add2numbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Add2NumbersTest {

    @Test
    void addTwoNumbers() {
        final ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9)))))));
        final ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9))));
        final Add2Numbers add2Numbers = new Add2Numbers();
        final ListNode actual = add2Numbers.addTwoNumbers(l1, l2);
        final ListNode expected = new ListNode(8, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(0, new ListNode(0, new ListNode(0, new ListNode(1))))))));
        ListNode actualCurrentNode = actual;
        ListNode expectedCurrentNode = expected;
        while (actualCurrentNode != null) {
            Assertions.assertEquals(expectedCurrentNode, actualCurrentNode);
            actualCurrentNode = actualCurrentNode.next;
            expectedCurrentNode = expectedCurrentNode.next;
        }
    }
}