package com.veal98.double_points;

import com.veal98.bean.ListNode;

public class RemoveDuplicatesFromListII_82 {

    public static void main(String[] args) {

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 添加一个头节点，方便处理
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            // 遇到重复出现的节点
            if (cur.next != null && cur.val == cur.next.val) {
                // 循环遍历到该重复节点的末尾
                while (cur != null && cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                // 删除中间这一段重复节点
                pre.next = cur.next;
            } else {
                pre = cur;
            }

            cur = cur.next;
        }

        return dummy.next;
    }


}
