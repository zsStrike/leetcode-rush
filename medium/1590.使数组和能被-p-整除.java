import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=1590 lang=java
 *
 * [1590] 使数组和能被 P 整除
 */

// @lc code=start
class Solution {
    // p = sum % p
    // p == 0 表示 0 否则 找到 sum[i..j] % p == 0
    // if leftSum[i] + rightSum[j] % p == 0  
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        if (sum % p == 0) {
            return 0;
        }
        int q = sum % p;
        // 找到 sum[i..j] = p * x + q  0 <= x <= sum/p
        // 找到 sum[0..i-1] + sum[j+1..n-1] = p * y , i-1 < j+1
        long leftSum = 0;
        HashMap<Integer, LinkedList<Integer>> lefMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            leftSum += nums[i];
            int key = (int) (leftSum % p);
            lefMap.putIfAbsent(key, new LinkedList<>());
            lefMap.get(key).addFirst(i);
        }
        long rightSum = 0;
        HashMap<Integer, LinkedList<Integer>> rightMap = new HashMap<>();
        for (int i = n - 1; i >= 0; i--) {
            rightSum += nums[i];
            int key = (int) (rightSum % p);
            rightMap.putIfAbsent(key, new LinkedList<>());
            rightMap.get(key).addFirst(i);
        }
        int min = Integer.MAX_VALUE;
        if (lefMap.containsKey(0)) {
            min = Math.min(min, n - 1 - lefMap.get(0).getFirst());
            System.out.println(min);
        }
        if (rightMap.containsKey(0)) {
            min = Math.min(min, rightMap.get(0).getFirst());
            System.out.println(min);
        }
        for (int i = 0; i < p; i++) {
            int j = (p - i) % p;
            if (!lefMap.containsKey(i) || !rightMap.containsKey(j)) {
                continue;
            }
            for (int leftI : lefMap.get(i)) {
                for (int rightJ : rightMap.get(j)) {
                    if (leftI < rightJ) {
                        // System.out.println(leftI + " " + rightJ);
                        min = Math.min(min, rightJ - leftI - 1);
                        break;
                    }
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
// @lc code=end

