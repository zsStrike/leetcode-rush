import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collector;

/*
 * @lc app=leetcode.cn id=902 lang=java
 *
 * [902] 最大为 N 的数字组合
 */

// @lc code=start
class Solution {
    HashMap<String, Integer> map = new HashMap<>();
    public int atMostNGivenDigitSet(String[] digits, int n) {
        map = new HashMap<>();
        char[] cs = String.valueOf(n).toCharArray();
        char[] ds = String.join("", digits).toCharArray();
        return atMostNGivenDigitSet(cs, 0, true, ds, false);
    }
    int atMostNGivenDigitSet(char[] cs, int idx, boolean isLimit, char[] digits, boolean isNum) {
        String key = Arrays.toString(cs) + " " + idx + " " + isLimit + " " + isNum;
        if (map.containsKey(key)) return map.get(key);
        int len = cs.length;
        if (len == idx) return isNum ? 1 : 0;
        char cur = cs[idx];
        char min = '0';
        char max = isLimit ? cur : '9';
        int ans = 0;
        if (isNum == false) {
            ans += atMostNGivenDigitSet(cs, idx + 1, false, digits, isNum);
        }
        for (char d : digits) {
            if (min <= d && max >= d) {
                ans += atMostNGivenDigitSet(cs, idx + 1, isLimit && d == max, digits, true);
            }
        }
        map.put(key, ans);
        return ans;
    }
}
// @lc code=end

