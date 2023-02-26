import java.util.Random;

/*
 * @lc app=leetcode.cn id=497 lang=java
 *
 * [497] 非重叠矩形中的随机点
 */

// @lc code=start
class Solution {

    int[] counts;
    int[][] rects;
    int sum = 0;
    // counts = [1, 2, 3]
    // 1/6 2/6 3/6
    //     5/6 2/5 5/6 3/5 3/3


    public Solution(int[][] rects) {
        int len = rects.length;
        this.counts = new int[len];
        for (int i = 0; i < len; i++) {
            int width = rects[i][2] - rects[i][0] + 1;
            int height = rects[i][3] - rects[i][1] + 1;
            counts[i] = width * height;
            sum += counts[i];
        }
        this.rects = rects;
    }
    
    public int[] pick() {
        int left = sum;
        Random random = new Random();
        int i = 0;
        for (i = 0; i < counts.length; i++) {
            if (random.nextInt(left) < counts[i]) {
                break;
            }
            left -= counts[i];
        }
        int width = rects[i][2] - rects[i][0] + 1;
        int height = rects[i][3] - rects[i][1] + 1;
        int x = rects[i][0] + random.nextInt(width);
        int y = rects[i][1] + random.nextInt(height);
        return new int[] {x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(rects);
 * int[] param_1 = obj.pick();
 */
// @lc code=end

