import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=324 lang=java
 *
 * [324] 摆动排序 II
 */

// @lc code=start
class Solution {
    // 1 1 1 4 6 5
    // 5 6
    // 1 1 1 4 5 6
    // 1 4 1 1 5 6
    // 
    // 1 2 3 4 5 6 7
    // 1 4 3 2 5 6 7
    // 1 4 3 5 2 6 7
    // 1 4 3 5 

    // 1 1 2 2 3 3
    public void wiggleSort(int[] nums) {
        //5001个桶
        int[] bucket = new int[5001];
        for (int num : nums) {
            bucket[num]++;
        }
        int j = 5000;
        //插空放 较大元素
        for (int i = 1; i < nums.length; i += 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
        //插空放 较小元素
        for (int i = 0; i < nums.length; i += 2) {
            while (bucket[j] == 0) {
                j--;
            }
            nums[i] = j;
            bucket[j]--;
        }
    }

}
// @lc code=end

