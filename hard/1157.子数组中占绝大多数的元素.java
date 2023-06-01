import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1157 lang=java
 *
 * [1157] 子数组中占绝大多数的元素
 */

// @lc code=start
class MajorityChecker {

    int[] arr;

    public MajorityChecker(int[] arr) {
        this.arr = arr;
    }
    
    public int query(int left, int right, int threshold) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = left; i <= right; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            if (map.get(arr[i]) >= threshold) {
                return arr[i];
            }
        }
        return -1;
    }
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr);
 * int param_1 = obj.query(left,right,threshold);
 */
// @lc code=end

