import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=869 lang=java
 *
 * [869] 重新排序得到 2 的幂
 */

// @lc code=start
class Solution {
    
    static HashSet<String> set = new HashSet<>();
    static {
        long j = 1;
        for (int i = 0; i < 35; i++) {
            long k = j << i;
            if (String.valueOf(k).length() > 10) {
                break;
            }
            set.add(genKey(k));
        }
    }

    static String genKey(long n) {
        String num = String.valueOf(n);
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : num.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (char i = '0'; i <= '9'; i++) {
            if (map.containsKey(i)) {
                sb.append(i);
                sb.append(map.get(i));
                sb.append(" ");
            }
        }
        return sb.toString();
    }
    
    public boolean reorderedPowerOf2(int n) {
        String key = genKey(n);
        if (set.contains(key)) {
            return true;
        }
        return false;
    }
}
// @lc code=end

