package com.veal98.double_points;

import com.veal98.bean.ListNode;

public class RemoveNthNode_19 {

    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 添加一个头节点，方便处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // 快指针先走 n+1 步
        for (int i = 0; i < n + 1; i++) {
            fast = fast.next;
        }

        // 然后快慢指针同时一次走一步
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // 删除第 n 个节点
        slow.next = slow.next.next;

        return dummy.next;
    }
}
