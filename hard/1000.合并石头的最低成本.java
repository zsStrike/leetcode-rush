import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=1000 lang=java
 *
 * [1000] 合并石头的最低成本
 * k = 2 时 个数不限     1 + n
 * k = 3 时 1, 3, 5, 7  1 + 2n
 * k = 4 时 1, 4, 7,    1 + 3n
 *  => 1 + (k - 1) n = size
 */

// @lc code=start
class Solution {
    public int mergeStones(int[] stones, int k) {
        int n = stones.length;
        if ((n - 1) % (k - 1) != 0) return -1;
        List<Integer> list = Arrays.stream(stones).boxed().collect(Collectors.toList());
        int total = 0;
        while (list.size() >= k) {
            int size = list.size();
            int min = Integer.MAX_VALUE;
            int left = 0, right = 0;
            int start = -1;
            int sum = 0;
            while (right < size) {
                sum += list.get(right);
                right++;
                if (right - left > k) {
                    sum -= list.get(left);
                    left++;
                }                
                if (right - left == k && min > sum && left % (k - 1) == 0) {
                    min = sum;
                    start = left;
                }                
            }
            // System.out.println(min + " " + start);
            total += min;
            List<Integer> newlist = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (i < start || i >= start + k) {
                    newlist.add(list.get(i));
                } else if (i == start) {
                    newlist.add(min);
                }
            }
            list = newlist;
            // System.out.println(list);
        }
        if (list.size() > 1) return -1;
        return total;
    }
}
// @lc code=end

