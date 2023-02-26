import java.util.Collections;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=738 lang=java
 *
 * [738] 单调递增的数字
 */

// @lc code=start
class Solution {
    public int monotoneIncreasingDigits(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        if (n == 0) {
            return 0;
        }
        while (n > 0) {
            list.add(n % 10);
            n /= 10;
        }
        Collections.reverse(list);
        int[] arr = list.stream().mapToInt(a -> a).toArray();
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                continue;
            }
            // arr[i] > arr[i + 1]
            arr[i]--;
            int j = i;
            while (j >= 1 && arr[j - 1] > arr[j]) {
                arr[j] = 9;
                arr[j - 1]--;
                j--;
            }
            for (j = i + 1; j < len; j++) {
                arr[j] = 9;
            }
        }
        int num = 0;
        for (int i = 0; i < len; i++) {
            num *= 10;
            num += arr[i];
        }
        return num;
    }
}
// @lc code=end

