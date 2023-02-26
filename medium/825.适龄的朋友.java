import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=825 lang=java
 *
 * [825] 适龄的朋友
 */

// @lc code=start
class Solution {
    public int numFriendRequests(int[] ages) {
        int n = ages.length;
        Arrays.sort(ages);
        int x = 0;
        int y = 0;
        int count = 0;
        // [6, 6, 15, 26, 30, 35, 39, 46, 60, 71, 73, 100, 106, 110, 112]
        
        System.out.println(Arrays.toString(ages));
        for (int i = 0; i < n; i++) {
            int right  = i + 1;
            while (right < n && ages[right] <= ages[i]) {
                right++;
            }
            for (int j = right - 1; j >= 0; j--) {
                if (j == i) {
                    continue;
                }
                if (ages[j] * 2 <= ages[i] + 14) {
                    break;
                }
                count++;
            }
            // System.out.println(ages[i] + " " + (right - left - 2));
        }
        return count;
    }
}
// @lc code=end

