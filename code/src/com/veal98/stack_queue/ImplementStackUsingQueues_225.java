package com.veal98.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues_225 {

    class MyStack {

        private Queue<Integer> queue;
        // 栈顶元素(队尾元素)
        private int top_em;

        public MyStack() {
            queue = new LinkedList<>();
            top_em = 0;
        }

        public void push(int x) {
            queue.offer(x);
            // 更新栈顶元素
            top_em = x;
        }

        public int pop() {
            // 把新栈顶元素之前的元素全部出队再入队
            int size = queue.size();
            while (size > 2) {
                queue.offer(queue.poll());
                size --;
            }
            // 记录新栈顶元素
            top_em = queue.peek();
            // 继续把新栈顶添加到队尾
            queue.offer(queue.poll());
            // 这样，原来的队尾元素就变成了队首元素了（栈顶）
            return queue.poll();
        }

        public int top() {
            return top_em;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    /**
     * Your MyStack object will be instantiated and called as such:
     * MyStack obj = new MyStack();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.top();
     * boolean param_4 = obj.empty();
     */
}
