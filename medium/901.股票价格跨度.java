import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=901 lang=java
 *
 * [901] 股票价格跨度
 */

// @lc code=start
class StockSpanner {

    ArrayList<Integer> nums;
    ArrayList<Integer> dp;
    public StockSpanner() {
        nums = new ArrayList<>();
        dp = new ArrayList<>();
    }
    
    public int next(int price) {
        // if (nums.size() == 0) {
        //     nums[i]
        // }
        int ret = 1;
        int pos = nums.size() - 1;
        while (pos >= 0 && nums.get(pos) <= price) {
            ret += dp.get(pos);
            pos -= dp.get(pos);
        }
        nums.add(price);
        dp.add(ret);
        return ret;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
// @lc code=end

