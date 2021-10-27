package com.veal98.linkedlist;

import com.veal98.bean.ListNode;

public class SwapNodesInPairs_24 {

    public static void main(String[] args) {

    }

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 添加一个虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // cur 是两两相邻节点中第一个节点的前驱节点
        ListNode cur = dummy;
        while (cur != null && cur.next != null && cur.next.next != null) {
            // 两两相邻的第一个节点
            ListNode first = cur.next;
            // 两两相邻的第二个节点C
            ListNode second = cur.next.next;
            ListNode successor = second.next;

            cur.next = second;
            second.next = first;
            first.next = successor;

            // cur 向右移动两位，进入下一轮交换
            cur = cur.next.next;
        }

        return dummy.next;

    }
}
