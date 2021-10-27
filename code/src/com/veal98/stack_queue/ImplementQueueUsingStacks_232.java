package com.veal98.stack_queue;

import java.util.Stack;

public class ImplementQueueUsingStacks_232 {

    class MyQueue {

        private Stack<Integer> stackA;
        private Stack<Integer> stackB;

        public MyQueue() {
            stackA = new Stack<>();
            stackB = new Stack<>();
        }

        public void push(int x) {
            // 直接入栈 A
            stackA.push(x);
        }

        public int pop() {
            peek();
            return stackB.pop();
        }

        /**
         * 获取栈顶元素
         */
        public int peek() {
            // 先将 A 中的元素从栈顶逐一 push 到栈 B 中
            if (stackB.empty()) { // 这一步判断需要注意！
                while (!stackA.isEmpty()) {
                    stackB.push(stackA.pop());
                }
            }
            // 然后获取 B 栈顶元素即可
            return stackB.peek();
        }

        public boolean empty() {
            return stackA.isEmpty() && stackB.isEmpty();
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

}
