/*
 * @lc app=leetcode.cn id=873 lang=java
 *
 * [873] 最长的斐波那契子序列的长度
 */

// @lc code=start
class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashSet<Integer> set =  new HashSet<>();
        int len = arr.length;
        set.add(arr[0]);
        set.add(arr[1]);
        int max = 0;
        for (int i = 2; i < len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int next = arr[i], cur = arr[j];
                int count = 2;
                while (next - cur < cur && set.contains(next - cur)) {
                    System.out.println(next + " " + cur + " " + count);
                    int tmp = next - cur;
                    next = cur;
                    cur = tmp;
                    count++;
                }
                if (count > 2) {
                    max = Math.max(max, count);
                }
            }
            set.add(arr[i]);
        }
        return max;
    }
}
// @lc code=end

