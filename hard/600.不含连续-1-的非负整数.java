import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=600 lang=java
 *
 * [600] 不含连续1的非负整数
 */

// @lc code=start
class Solution {
    HashMap<String, Integer> map;
    public int findIntegers(int n) {
        map = new HashMap<>();
        char[] cs = Integer.toBinaryString(n).toCharArray();
        return helper(cs, 0, true, '0');
    }
    int helper(char[] cs, int idx, boolean isLimit, char pre) {
        String key = idx + " " + isLimit + " " + pre;
        if (map.containsKey(key)) return map.get(key);
        int len = cs.length;
        if (idx == len) return 1;
        char cur = cs[idx];
        int ans = 0;
        char min = '0';
        char max = isLimit ? cur : '1';
        for (char i = min; i <= max; i++) {
            if (pre == '1' && i == '1') break;
            ans += helper(cs, idx + 1, isLimit && i == max, i);
        }
        map.put(key, ans);
        return ans;
    }
}
// @lc code=end

