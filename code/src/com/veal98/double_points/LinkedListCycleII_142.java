package com.veal98.double_points;

import com.veal98.bean.ListNode;

public class LinkedListCycleII_142 {

    public static void main(String[] args) {

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode ptr = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                while (ptr != fast) {
                    ptr = ptr.next;
                    fast = fast.next;
                }
                return ptr;
            }
        }

        return null;
    }


}
