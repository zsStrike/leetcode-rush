import java.util.Arrays;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=902 lang=java
 *
 * [902] 最大为 N 的数字组合
 */

// @lc code=start
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String[] num = String.valueOf(n).split("");
        int count = 0;
        int tmp = digits.length;
        for (int i = 1; i < num.length; i++) {
            count += tmp;
            tmp *= digits.length;
        }
        return atMostNGivenDigitSet(digits, num, 0) + count;
    }
    int atMostNGivenDigitSet(String[] digits, String[] num, int idx) {
        if (map.containsKey(idx)) {
            return map.get(idx);
        }
        int numLen = num.length;
        int count = 0;
        if (idx == numLen - 1) {
            for (String d : digits) {
                if (d.compareTo(num[idx]) <= 0) {
                    count++;
                }
            }
        } else {
            for (String d : digits) {
                if (d.compareTo(num[idx]) < 0) {
                    count += Math.pow(digits.length, numLen - idx - 1);
                } else if (d.compareTo(num[idx]) == 0) {
                    count += atMostNGivenDigitSet(digits, num, idx + 1);
                }
            }
        }
        map.put(idx, count);
        return count;
    }
}
// @lc code=end

