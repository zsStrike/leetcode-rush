import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=166 lang=java
 *
 * [166] 分数到小数
 */

// @lc code=start
class Solution {
    public String fractionToDecimal(int num, int den) {
        long numerator = num;
        long denominator = den;
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 && denominator > 0 ||
            numerator > 0 && denominator < 0) {
                sb.append('-');
                System.out.println("======");
            }
        numerator = numerator > 0 ? numerator : -numerator;
        denominator = denominator > 0 ? denominator : -denominator;
        if (numerator % denominator == 0) {
            sb.append(numerator / denominator);
            return sb.toString();
        }
        if (numerator > denominator) {
            sb.append(numerator / denominator);
            numerator %= denominator;
        } else {
            sb.append('0');
        }
        sb.append('.');
        HashMap<Long, Integer> set = new HashMap<>();
        numerator *= 10;
        int idxs = 0;
        while (!set.containsKey(numerator)) {
            // System.out.println(numerator);
            set.put(numerator, idxs);
            if (numerator >= denominator) {
                sb.append(numerator / denominator);
                numerator %= denominator;
            } else {
                sb.append(0);
            }
            if (numerator == 0) {
                return sb.toString();
            }
            idxs++;
            numerator *= 10;
        }
        // int idx = sb.indexOf("" + (numerator / denominator), sb.indexOf(".") + map.get());
        sb.insert(set.get(numerator) + sb.indexOf(".") + 1, '(');
        sb.append(')');
        return sb.toString();
    }
}
// @lc code=end

