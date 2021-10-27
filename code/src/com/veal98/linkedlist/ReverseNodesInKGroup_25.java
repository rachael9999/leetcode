package com.veal98.linkedlist;

import com.veal98.bean.ListNode;

public class ReverseNodesInKGroup_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        // 找到第 k + 1 个节点(作为进入第一段递归调用的末尾节点)
        ListNode tail = head;
        for (int i = 0; i < k; i ++) {
            if (tail == null) {
                // 链表个数不足 k 个
                return head;
            }
            tail = tail.next;
        }

        // 先反转前 k 个 [head, tail), 得到的头节点就是最终链表的头节点
        ListNode newHead = reverse(head, tail);
        // 递归调用反转后续的链表
        reverseKGroup(tail, k);

        return newHead;
    }

    // 原地反转从 head 到 tail（不包含 tail） 的链表
    private ListNode reverse(ListNode head, ListNode tail) {
        ListNode cur = head;
        // 注意这里的 pre 初始化为 tail, 因为我们反转 [head, tail) 后，不能使链表断开
        ListNode pre = tail;
        // 保存 cur = 后继节点
        ListNode successor;

        while (cur != tail) {
            successor = cur.next;

            // 更改 next 指向
            cur.next = pre;

            // 进入下一个节点
            pre = cur;
            cur = successor;
        }

        // 返回反转后链表的头节点
        return pre;
    }
}
