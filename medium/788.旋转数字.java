import java.util.Arrays;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=788 lang=java
 *
 * [788] 旋转数字
 */

// @lc code=start
class Solution {
    HashSet<Integer> set1 = new HashSet<>();

    public int rotatedDigits(int n) {
        boolean[] set = new boolean[10];
        HashSet<Integer> diff = new HashSet<>(Arrays.asList(2, 5, 6, 9));
        set[0] = set[1] = set[2] = set[5] = set[6] = set[8] = set[9] = true;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            boolean flag = false;
            int j = i;
            while (j > 0) {
                if (set[j % 10] == false) {
                    flag = false;
                    break;
                }
                if (diff.contains(j % 10)) {
                    flag = true;
                }
                j = j / 10;
            }
            if (flag) count++;
        }
        return count;
    }
}
// @lc code=end

