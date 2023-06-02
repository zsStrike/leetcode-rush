import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=2386 lang=java
 *
 * [2386] 找出数组的第 K 大和
 */

// @lc code=start
class Solution {
    // n 取值范围是 10^5，不能两层循环
    // k 最大值为 2000
    // 正数个数 m 
    // 最大值所有正数和0之和
    // 加上最小负数或者删除最小的非负数 得到第二大的值
    public long kSum(int[] nums, int k) {
        List<Integer> pos = Arrays.stream(nums).filter(a -> a >= 0).boxed().collect(Collectors.toList());
        List<Integer> neg = Arrays.stream(nums).filter(a -> a < 0).boxed().collect(Collectors.toList());
        PriorityQueue<long[]> queue = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        long max = pos.stream().mapToInt(a -> a).sum();
        queue.offer(new long[]{max, -1});
        while (!queue.isEmpty() && k > 0) {
            
        }
    }
}
// @lc code=end

