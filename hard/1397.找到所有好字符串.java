import java.beans.EventHandler;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1397 lang=java
 *
 * [1397] 找到所有好字符串
 */

// @lc code=start
class Solution {
    long MOD = (long) (1e9 + 7);
    HashMap<String, Long> map;
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        map = new HashMap<>();
        return (int)findGoodStrings(s1.toCharArray(), s2.toCharArray(), 0, true, true, new StringBuilder(), evil);
    }
    int maxPreSuf(String evil, String data) {
        int min = Math.min(evil.length(), data.length());
        while (!data.substring(data.length() - min).equals(evil.substring(0, min))) {
            min--;
        }
        return min;
    }
    long findGoodStrings(char[] cs1, char[] cs2, int idx, boolean lowLimit, boolean highLimit, StringBuilder pre, String evil) {
        int preSuf = maxPreSuf(evil, pre.toString());
        String key = idx + " " + lowLimit + " " + highLimit + " " + preSuf + " ";
        if (map.containsKey(key)) return map.get(key);
        int len = cs1.length;
        if (len == idx) return 1;
        char min = 'a', max = 'z';
        if (lowLimit) {
            min = cs1[idx];
        }
        if (highLimit) {
            max = cs2[idx];
        }
        long ans = 0;
        for (char c = min; c <= max; c++) {
            pre.append(c);
            if (pre.indexOf(evil) == -1) {
                ans += findGoodStrings(cs1, cs2, idx + 1, lowLimit && c == min, highLimit && c == max, pre, evil);
                ans %= MOD;
            }
            pre.deleteCharAt(pre.length() - 1);
        }
        map.put(key, ans);
        return ans;
    }
}
// @lc code=end

