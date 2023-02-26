/*
 * @lc app=leetcode.cn id=933 lang=java
 *
 * [933] 最近的请求次数
 */

// @lc code=start
class RecentCounter {
    PriorityQueue<Integer> pq;
    public RecentCounter() {
        pq = new PriorityQueue<>((a,b)-> a-b);
    }
    
    public int ping(int t) {
        if(!pq.isEmpty()){
            int min = t-3000;
			//recursively pop elements from top of MinHeap till top element is greater than t-3000
            while(!pq.isEmpty() && pq.peek() < min){
                pq.poll();
            }
        }
        pq.offer(t);
        return pq.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
// @lc code=end

