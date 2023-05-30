import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=233 lang=java
 *
 * [233] 数字 1 的个数
 */

// @lc code=start
class Solution {
    // 13 12 11 10 1
    HashMap<String, Integer> map = new HashMap<>();
    public int countDigitOne(int n) {
        map = new HashMap<>();
        char[] cs = Integer.toString(n).toCharArray();
        return helper(cs, 0, true, 0);
    }
    // 表示现在填写 idx 位，
    int helper(char[] cs, int idx, boolean isLimit, int preCount) {
        String key = idx + " " + isLimit + " " + preCount;
        if (map.containsKey(key)) return map.get(key);
        int len = cs.length;
        if (idx == len) return preCount;
        char cur = cs[idx];
        char min = '0';
        char max = isLimit ? cur : '9';
        int ans = 0;
        for (char c = min; c <= max; c++) {
            ans += helper(cs, idx + 1, isLimit && c == max, preCount + (c == '1' ? 1 : 0));
        }
        map.put(key, ans);
        return ans;
    }
}
// @lc code=end

