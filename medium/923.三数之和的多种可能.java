import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=923 lang=java
 *
 * [923] 三数之和的多种可能
 */

// @lc code=start
class Solution {
    static int MOD = (int) (1e9 + 7);
    public int threeSumMulti(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 2; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int n = arr.length;
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += twoSum(map, target - arr[i]);
            // System.out.println(arr[i] + " " + twoSum(map, target - arr[i]));
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            count %= MOD;
        }
        return count;
    }
    int twoSum(HashMap<Integer, Integer> map, int target) {
        int count = 0;
        for (int key : map.keySet()) {
            int another = target - key;
            if (!map.containsKey(another)) {
                continue;
            }
            if (key < another) {
                count += map.get(key) * map.get(another);
            } else if (key == another) {
                count += map.get(key) * (map.get(key) - 1) / 2;
            }
            count %= MOD;
        }
        return count;
    }
}
// @lc code=end

