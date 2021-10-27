package com.veal98.linkedlist;

import com.veal98.bean.ListNode;

import java.util.Map;

public class IntersectionOfTwoLinkedLists_160 {

    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        // 计算两个链表的长度
        int lenA = 0;
        int lenB = 0;
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }

        // 如果到最后一个节点了他俩仍然不是同一个节点，就说明这两个链表不相交
        if (curA != curB) {
            return null;
        }

        // 长链表先走完长出来的那部分
        ListNode longer = headA;
        ListNode shorter = headB;
        if (lenA < lenB) {
            longer = headB;
            shorter = headA;
        }
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            longer = longer.next;
        }

        // 然后再一同遍历两个链表，直到找到某个相同节点
        while (longer != null && shorter != null) {
            if (longer == shorter) {
                return longer;
            }
            longer = longer.next;
            shorter = shorter.next;
        }

        return null;
    }

}
