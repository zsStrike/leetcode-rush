/*
 * @lc app=leetcode.cn id=900 lang=java
 *
 * [900] RLE 迭代器
 */

// @lc code=start
class RLEIterator {

    int[] encoding;
    int cur;
    
    public RLEIterator(int[] encoding) {
        this.encoding = encoding;
        cur = 0;
    }
    
    public int next(int n) {
        int ret = -1;
        while (cur < encoding.length && n > 0) {
            if (encoding[cur] >= n) {
                encoding[cur] -= n;
                return encoding[cur + 1];
            } else {
                n -= encoding[cur];
                cur += 2;
            }
        }    
        return -1;
    }
}

/**
 * Your RLEIterator object will be instantiated and called as such:
 * RLEIterator obj = new RLEIterator(encoding);
 * int param_1 = obj.next(n);
 */
// @lc code=end

