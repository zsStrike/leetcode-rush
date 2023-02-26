import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=491 lang=java
 *
 * [491] 递增子序列
 */

// @lc code=start
class Solution {
    HashSet<String> set = new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        int n = nums.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(nums[i] + " ");
            for (int j = i + 1; j < n; j++) {
                if (nums[j] >= nums[i]) {
                    int start = sb.length();
                    sb.append(nums[j] + " ");
                    String str = sb.toString();
                    set.add(str.substring(0, str.length() - 1));                      
                    dfs(nums, j, sb);
                    sb.delete(start, sb.length());
                }
            }
            sb.delete(0, sb.length());
        }
        List<List<Integer>> list = new LinkedList<>();
        for (String str : set) {
            list.add(Arrays.stream(str.split(" ")).map(a -> Integer.valueOf(a)).collect(Collectors.toList()));
        }
        return list;
    }
    void dfs(int[] nums, int idx, StringBuilder sb) {
        for (int i = idx + 1; i < nums.length; i++) {
            if (nums[idx] > nums[i]) {
                continue;
            }
            int preLen = sb.length();
            sb.append(nums[i] + " ");
            String str = sb.toString();
            set.add(str.substring(0, str.length() - 1));            
            dfs(nums, i, sb);
            sb.delete(preLen, sb.length());
        }
    }
}
// @lc code=end

