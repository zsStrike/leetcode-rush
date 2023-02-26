import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=830 lang=java
 *
 * [830] 较大分组的位置
 */

// @lc code=start
class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> list = new LinkedList<>();
        int left = 0;
        while (left < s.length()) {
            int right = left;
            while (right < s.length() && s.charAt(right) == s.charAt(left)) {
                right++;
            }
            if (right - left >= 3) {
                list.add(Arrays.asList(left, right - 1));
            }
            left = right;
        }
        return list;
    }
}
// @lc code=end

