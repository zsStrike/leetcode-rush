import java.util.Arrays;
import java.util.Random;

/*
 * @lc app=leetcode.cn id=912 lang=java
 *
 * [912] 排序数组
 */

// @lc code=start
class Solution {
    Random rand = new Random();
    public int[] sortArray(int[] nums) {
        // mergeSort(nums);
        // bubbleSort(nums);
        // selectSort(nums);
        // insertSort(nums);
        // quickSort(nums);
        // bucketSort(nums);
        shellSort(nums);
        return nums;
    }
    // TLE 12/20
    void shellSort(int[] nums) {
        int n = nums.length;
        int step = (int) Math.sqrt(n);
        while (step > 0) {
            // insertSort, i 是每组的起点
            for (int i = 0; i < step; i++) {
                for (int j = i; j < n; j += step) {
                    int min = nums[j], idx = j;
                    for (int k = j; k < n; k += step) {
                        if (nums[k] < min) {
                            min = nums[k];
                            idx = k;
                        }
                    }
                    swap(nums, idx, j);
                }
            }
            step /= 2;
        }
    }
    // 99-81
    void heapSort(int[] nums) {
        // lc = 2 * i + 1, rc = 2 * i + 2
        heapify(nums, 0, nums.length - 1);
        int n = nums.length - 1;
        while (n > 0) {
            swap(nums, 0, n);
            n--;
            sink(nums, 0, n);
        }
    }
    void heapify(int[] nums, int start, int end) {
        int len = end - start + 1;
        for (int i = start + len / 2; i >= start; i--) {
            sink(nums, i, end);
        }
    }
    void sink(int[] nums, int i, int end) {
        int lc = 2 * i + 1, rc = 2 * i + 1;
        int max = nums[i], idx = i;
        if (lc <= end && nums[lc] > max) {
            max = nums[lc];
            idx = lc;
        }
        if (rc <= end && nums[rc] > max) {
            max = nums[rc];
            idx = rc;
        }    
        if (idx != i) {
            swap(nums, i, idx);
            sink(nums, idx, end);
        }
    }
    // 99-78
    void bucketSort(int[] nums) {
        if (nums.length < 2) return;
        int min = nums[0], max = nums[0];
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        int[] bucket = new int[max - min + 1];
        for (int num : nums) {
            bucket[num - min]++;
        }
        int j = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                nums[j++] = i + min;
                bucket[i]--;
            }
        }
    }
    // TLE 17/20
    void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }
    void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int[] p = partition(nums, start, end);
        quickSort(nums, start, p[0]);
        quickSort(nums, p[1], end);
    }
    // 26-45, 53-99
    int[] partition(int[] nums, int start, int end) {
        // rand pick
        int rd = rand.nextInt(end - start + 1) + start;
        swap(nums, start, rd);
        int pivot = start;
        int p = start + 1, q = end;
        for (int i = start + 1; i <= q; i++) {
            if (nums[i] > nums[pivot]) {
                swap(nums, i, q);
                q--;
                i--;
            } else if (nums[i] < nums[pivot]) {
                swap(nums, i, p);
                p++;
            }
        }
        swap(nums, pivot, p - 1);
        return new int[] {p - 1, q + 1};
    }
    // TLE 15/20
    void insertSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i;
            while (j > 0 && nums[j - 1] > nums[j]) {
                swap(nums, j - 1, j);
                j--;
            }
        }
    }
    // TLE 14/20
    void selectSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int min = nums[i];
            int k = i;
            for (int j = i; j < n; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    k = j;
                }
            }
            swap(nums, i, k);
        }
    }
    // TLE 10/20
    void bubbleSort(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                if (nums[j - 1] > nums[j]) {
                    swap(nums, j - 1, j);
                }
            }
        }
    }
    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    // 74-45
    void mergeSort(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }
    void mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        int[] tmp = new int[end - start + 1];
        int p = start, q = mid + 1;
        int i = 0;
        for (i = 0; i < tmp.length && p <= mid && q <= end; i++) {
            if (nums[p] < nums[q]) {
                tmp[i] = nums[p];
                p++;
            } else {
                tmp[i] = nums[q];
                q++;
            }
        }
        while (p <= mid) {
            tmp[i] = nums[p];
            i++;
            p++;
        }
        while (q <= end) {
            tmp[i] = nums[q];
            i++;
            q++;
        }
        for (i = 0; i < tmp.length; i++) {
            nums[i + start] = tmp[i];
        }
    }
}
// @lc code=end

