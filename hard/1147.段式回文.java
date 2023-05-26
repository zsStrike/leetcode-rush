import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1147 lang=java
 *
 * [1147] 段式回文
 */

// @lc code=start
class Solution {
    HashMap<Integer, Integer> memo = new HashMap<>();
    public int longestDecomposition(String text) {
        char[] cs = text.toCharArray();
        return longestDecomposition(cs, 0, cs.length - 1);
    }
    int longestDecomposition(char[] cs, int start, int end) {
        if (start > end) return 0;
        if (start == end) return 1;
        int key = start * 10000 + end;
        if (memo.containsKey(key)) return memo.get(key);
        int max = 1;
        for (int i = start; i <= start + (end - start) / 2; i++) {
            if (cs[i] == cs[end] && helper(cs, start, i, end)) {
                int len = i - start + 1;
                max = Math.max(max, longestDecomposition(cs, i + 1, end - len) + 2);
                break;
            }
        }
        memo.put(key, max);
        return max;
    }
    boolean helper(char[] cs, int start, int i, int end) {
        for (int j = i; j >= start; j--) {
            if (cs[j] != cs[end]) {
                return false;
            }
            end--;
        }
        return true;
    }
}
// @lc code=end

