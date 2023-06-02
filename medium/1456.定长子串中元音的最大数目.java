import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start
class Solution {
    public int maxVowels(String s, int k) {
        char[] cs = s.toCharArray();
        String set = "aeiou";
        int left = 0, right = 0, n = cs.length;
        int count = 0;
        int max = 0;
        while (right < n) {
            if (set.indexOf(cs[right]) != -1) {
                count++;
            }
            while (right - left + 1 > k) {
                if (set.indexOf(cs[left]) != -1) {
                    count--;
                }
                left++;
            }
            max = Math.max(max, count);
            right++;
        }
        return max;
    }
}
// @lc code=end

