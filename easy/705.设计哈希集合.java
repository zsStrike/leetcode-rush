/*
 * @lc app=leetcode.cn id=705 lang=java
 *
 * [705] 设计哈希集合
 */

// @lc code=start
class MyHashSet {

    static int N = 1000_001;
    boolean[] number;

    public MyHashSet() {
        number = new boolean[N];
    }
    
    public void add(int key) {
        number[key] = true;
    }
    
    public void remove(int key) {
        number[key] = false;
    }
    
    public boolean contains(int key) {
        return number[key];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
// @lc code=end

