import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU 缓存
 */

// @lc code=start
class LRUCache {

    class ListNode {
        ListNode pre, next;
        int key;
        int val;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    ListNode head, tail;
    HashMap<Integer, ListNode> map;
    int capacity;
    int size;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
        head = new ListNode(-1, -1);
        tail = new ListNode(-1, -1);
        head.next = tail;
        tail.next = head;
        size = 0;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        // move the node to head
        removeNode(map.get(key));
        addNode(map.get(key));
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.get(key).val = value;
            removeNode(map.get(key));
            addNode(map.get(key));
        } else {
            ListNode node = new ListNode(key, value);
            addNode(node);
            map.put(key, node);
            size++;
        }

        if (size > capacity) {
            map.remove(tail.pre.key);
            removeNode(tail.pre);
            size--;
        }
    }
    void removeNode(ListNode node) {
        ListNode pre = node.pre, next = node.next;
        pre.next = next;
        next.pre = pre;
    }
    void addNode(ListNode node) {
        ListNode pre = head, next = head.next;
        node.pre = pre;
        node.next = next;
        pre.next = node;
        next.pre = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
// @lc code=end

