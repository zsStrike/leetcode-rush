import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=658 lang=java
 *
 * [658] 找到 K 个最接近的元素
 */

// @lc code=start
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) {
                left = mid;
                right = mid + 1;
                break;
            } else if (arr[mid] < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left > right) {
            int tmp = left;
            left = right;
            right = tmp;
        }
        LinkedList<Integer> list = new LinkedList<>();
        while (k > 0) {
            if (left < 0) {
                list.add(arr[right]);
                right++;
            } else if (right >= n) {
                list.add(arr[left]);
                left--;
            } else {
                int da = Math.abs(arr[left] - x);
                int db = Math.abs(arr[right] - x);
                if (da < db) {
                    list.add(arr[left]);

                    left--;
                } else if (da > db) {
                    list.add(arr[right]);

                    right++;
                } else {
                    list.add(arr[left]);

                    left--;
                }
            }
            k--;
        }
        Collections.sort(list);
        return list;
        // return Arrays.copyOfRange(arr, left, right);
    }
}
// @lc code=end

