import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=1487 lang=java
 *
 * [1487] 保证文件名唯一
 */

// @lc code=start
class Solution {
    public String[] getFolderNames(String[] names) {
        HashMap<String, Integer> map = new HashMap<>();
        int n = names.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(names[i])) {
                map.put(names[i], 1);
                ans[i] = names[i];
            } else {
                String tmp = names[i] + "(" + map.get(names[i]) + ")";
                map.put(names[i], map.get(names[i]) + 1);
                while (map.containsKey(tmp)) {
                    tmp = names[i] + "(" + map.get(names[i]) + ")";
                    map.put(names[i], map.get(names[i]) + 1);
                }
                map.put(tmp, 1);
                ans[i] = tmp;
            }
        }
        return ans;
    }
}
// @lc code=end

