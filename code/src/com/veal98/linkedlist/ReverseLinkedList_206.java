package com.veal98.linkedlist;

import com.veal98.bean.ListNode;

public class ReverseLinkedList_206 {

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 新链表的虚拟头节点
        ListNode newHead = new ListNode(0);
        newHead.next = null;

        // 直接用 head 指针遍历原链表, successor 记录当前 head 指向节点的后继节点
        ListNode successor = null;

        while (head != null) {
            successor = head.next;

            // 不断的从原来那个单链表的头部摘下节点头插到新链表
            head.next = newHead.next;
            newHead.next = head;

            // 进入一个节点
            head = successor;
        }

        return newHead.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        ListNode pre = null;
        // 保存 cur 的后继节点
        ListNode successor;

        while (cur != null) {
            // 保存 cur 的后继节点
            successor = cur.next;

            // 更改 next 指针
            cur.next = pre;

            // 进入下一个节点
            pre = cur;
            cur = successor;
        }

        // 返回反转后链表的头节点
        return pre;
    }
}
