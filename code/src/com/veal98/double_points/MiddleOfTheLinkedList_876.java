package com.veal98.double_points;

import com.veal98.bean.ListNode;

public class MiddleOfTheLinkedList_876 {

    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
