package com.veal98.linkedlist;

import com.veal98.bean.ListNode;

public class PartitionList_86 {

    public static void main(String[] args) {

    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        // 存储小于 x 链表的虚拟头节点
        ListNode smallHead = new ListNode(0);
        ListNode l1 = smallHead;
        // 存储大于等于 x 链表的虚拟头节点
        ListNode bigHead = new ListNode(0);
        ListNode l2 = bigHead;

        // 遍历原链表
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                l1.next = cur;
                l1 = l1.next;
            } else {
                l2.next = cur;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        // 合并两个链表
        l1.next = bigHead.next;
        // 防止出现环
        l2.next = null;

        return smallHead.next;
    }
}
