package com.veal98.linkedlist;

public class DesignLinkedList_707 {

    public static void main(String[] args) {

    }

    class MyLinkedList {

        // 链表元素个数
        private int size;
        // 虚拟头节点
        private ListNode dummy;

        public MyLinkedList() {
            size = 0;
            dummy = new ListNode(0);
        }

        /**
         * 获取链表中下标为 index 的节点的值。如果索引无效，则返回-1。
         */
        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            ListNode cur = dummy;
            // 添加了一个虚拟头节点，所以查找下标 index+1 的节点
            for (int i = 0; i <= index; i ++) {
                cur = cur.next;
            }

            return cur.val;
        }

        /**
         * 在链表的第一个元素之前添加一个值为 val 的节点。插入后，新节点将成为链表的第一个节点。
         */
        public void addAtHead(int val) {
            addAtIndex(0, val);
        }

        public void addAtTail(int val) {
            addAtIndex(size, val);
        }

        /**
         * 在链表中的第 index 个节点之前添加值为 val  的节点
         * 如果 index 等于链表的长度，则该节点将附加到链表的末尾
         * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点
         */
        public void addAtIndex(int index, int val) {
            if (index > size) {
                return ;
            }

            if (index < 0) {
                index = 0;
            }

            size ++;

            // 找到要插入节点的前驱
            ListNode pre = dummy;
            for (int i = 0; i < index; i ++) {
                pre = pre.next;
            }

            // 待插入节点
            ListNode newNode = new ListNode(val);
            newNode.next = pre.next;
            pre.next = newNode;
        }

        /**
         * 如果索引 index 有效，则删除链表中的第 index 个节点
         */
        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return ;
            }

            size --;

            // 找到要删除节点的前驱
            ListNode pre = dummy;
            for (int i = 0; i < index; i ++) {
                pre = pre.next;
            }

            // 待删除节点
            ListNode delNode = pre.next;
            pre.next = delNode.next;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            this.val = x;
            this.next = null;
        }
    }

    /**
     * Your MyLinkedList object will be instantiated and called as such:
     * MyLinkedList obj = new MyLinkedList();
     * int param_1 = obj.get(index);
     * obj.addAtHead(val);
     * obj.addAtTail(val);
     * obj.addAtIndex(index,val);
     * obj.deleteAtIndex(index);
     */
}
