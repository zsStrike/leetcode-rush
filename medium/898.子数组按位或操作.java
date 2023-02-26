import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=898 lang=java
 *
 * [898] 子数组按位或操作
 */

// @lc code=start
class Solution {
    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        int n = arr.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            max |= arr[i];
        }
        for (int i = 0; i < n; i++) {
            int tmp = 0;
            for (int j = i; j < n; j++) {
                tmp |= arr[j];
                set.add(tmp);
                if (tmp == max) {
                    break;
                }
            }
        }
        return set.size();
    }
}
// @lc code=end

