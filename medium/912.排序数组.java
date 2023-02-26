/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }
    void mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int i = start;
        int j = mid + 1;
        int[] tmp = new int[end - start + 1];
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] < nums[j]) {
                tmp[k] = nums[i];
                i++;
            } else {
                tmp[k] = nums[j];
                j++;
            }
            k++;
        }
        while (i <= mid) {
            tmp[k] = nums[i];
            k++;
            i++;
        }   
        while (j <= end) {
            tmp[k] = nums[j];
            k++;
            j++;
        }
        for (int p = 0; p < end - start + 1; p++) {
            nums[p + start] = tmp[p];
        }
    }
}
// @lc code=end

