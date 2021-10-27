package com.veal98.linkedlist;

import com.veal98.bean.ListNode;

public class RemoveLinkedListElements_203 {

    public static void main(String[] args) {

    }

    public static ListNode removeElements(ListNode head, int val) {
        // 添加一个头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;

        while (cur != null) {
            if (cur.val == val) {
                // 删除 cur 节点
                pre.next = cur.next;
            } else {
                pre = cur;
            }

            cur = cur.next;
        }

        return dummy.next;
    }
}
