package com.veal98.linkedlist;

import com.veal98.bean.ListNode;

public class ReverseLinkedListII_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right <= left) {
            return head;
        }

        // 新建一个虚拟头节点
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 找到 left 的前驱节点
        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i ++) {
            pre = pre.next;
        }

        // 第 left 个节点
        ListNode leftNode = pre.next;

        // 第一个要进行头插的节点
        ListNode cur = leftNode.next;
        // 记录其后继节点，防止断链
        ListNode successor;

        for (int i = 0; i < right - left; i ++) {
            successor = cur.next;

            // 头插到 pre 的后面，leftNode 的前面
            cur.next = pre.next;
            pre.next = cur;

            // 处理下一个节点
            cur = successor;
        }

        // 防止出现环
        leftNode.next = cur;

        return dummy.next;
    }
}
