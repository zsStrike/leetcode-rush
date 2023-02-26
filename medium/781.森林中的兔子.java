import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=781 lang=java
 *
 * [781] 森林中的兔子
 */

// @lc code=start
class Solution {
    // [3, 3] 4
    // [3, 3, 3] 4
    // [3, 3, 3, 3] 4
    // [3, 3, 3, 3, 3]  4 + 4 = 8
    public int numRabbits(int[] answers) {
        Arrays.sort(answers);
        int left = 0, n = answers.length;
        int count = 0;
        while (left < n) {
            int right = left;
            while (right < n && answers[right] == answers[left] && right - left <= answers[left]) {
                right++;
            }
            count += answers[left] + 1;
            left = right;
        }
        return count;
    }
}
// @lc code=end

