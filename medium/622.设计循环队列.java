/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {

    int[] queue;
    int front, rear;

    public MyCircularQueue(int k) {
        queue = new int[k + 1];
        front = rear = 0;
    }
    
    public boolean enQueue(int value) {
        if (!isFull()) {
            queue[rear] = value;
            rear = (rear + 1) % queue.length;
            return true;
        }
        return false;
    }
    
    public boolean deQueue() {
        if (!isEmpty()) {
            front = (front + 1) % queue.length;
            return true;
        }
        return false;
    }
    
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }
    
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return queue[(rear - 1 + queue.length) % queue.length];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return (rear + 1) % queue.length == front;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end

