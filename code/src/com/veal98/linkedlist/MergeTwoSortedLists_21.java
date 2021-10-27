package com.veal98.linkedlist;

import com.veal98.bean.ListNode;

public class MergeTwoSortedLists_21 {

    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 == null ? l2 : l1;
        }

        // 新链表的头节点
        ListNode l3 = new ListNode(0);
        // 尾节点
        ListNode ptr3 = l3;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ptr3.next = l1;
                l1 = l1.next;
            } else {
                ptr3.next = l2;
                l2 = l2.next;
            }
            ptr3 = ptr3.next;
        }

        // 在循环终止的时候， l1 和 l2 至多有一个是非空的
        if (l1 != null) {
            ptr3.next = l1;
        }

        if (l2 != null) {
            ptr3.next = l2;
        }

        return l3.next;
    }
}
