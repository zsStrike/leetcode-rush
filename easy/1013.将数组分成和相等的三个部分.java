import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1013 lang=java
 *
 * [1013] 将数组分成和相等的三个部分
 */

// @lc code=start
class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        if (sum % 3 != 0) {
            return false;
        }
        int len = arr.length;
        int[] sums = new int[len];
        sums[0] = arr[0];
        for (int i = 1; i < len; i++) {
            sums[i] = sums[i - 1] + arr[i];
        }
        for (int i = 0; i < len; i++) {
            if (sums[i] == sum / 3) {
                for (int j = len - 2; j > i; j--) {
                    if (sums[len - 1] - sums[j] == sum / 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
// @lc code=end

