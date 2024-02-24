package com.nvgrig.coding.add2numbers;

import java.util.ArrayList;
import java.util.List;

public class Add2Numbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean needToAddOne = false;
        ListNode currentL1 = l1;
        ListNode currentL2 = l2;
        List<ListNode> resultList = new ArrayList<>();
        int l3size = 0;
        while (currentL1 != null || currentL2 != null) {
            int l1val = currentL1 == null ? 0 : currentL1.val;
            int l2val = currentL2 == null ? 0 : currentL2.val;
            int sum = l1val + l2val;
            ListNode currentL3 = null;
            if (sum > 8) {
                int l3val = sum + (needToAddOne ? 1 : 0);
                if (l3val > 9) {
                    l3val = l3val % 10;
                    needToAddOne = true;
                }
                currentL3 = new ListNode(l3val, null);
            } else {
                int l3val = sum + (needToAddOne ? 1 : 0);
                currentL3 = new ListNode(l3val, null);
                needToAddOne = false;
            }
            currentL1 = currentL1 == null ? null : currentL1.next;
            currentL2 = currentL2 == null ? null : currentL2.next;
            if (l3size == 0) {
                resultList.add(currentL3);
            } else {
                ListNode previousL3 = resultList.get(l3size - 1);
                previousL3.next = currentL3;
                resultList.add(currentL3);
            }
            if (currentL1 == null && currentL2 == null && needToAddOne) {
                ListNode lastNode = new ListNode(1);
                ListNode previousL3 = resultList.get(l3size);
                previousL3.next = lastNode;
                resultList.add(lastNode);
            }
            l3size++;
        }
        return resultList.get(0);
    }

}