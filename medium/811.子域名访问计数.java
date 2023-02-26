import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=811 lang=java
 *
 * [811] 子域名访问计数
 */

// @lc code=start
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = cpdomains.length;
        for (int i = 0; i < len; i++) {
            String[] ds = cpdomains[i].split(" ");
            String[] doms = ds[1].split("\\.");
            String key = "";
            int times = Integer.parseInt(ds[0]);
            for (int j = doms.length - 1; j >= 0; j--) {
                // System.out.println(doms[j]);
                key = doms[j] + key;
                map.put(key, map.getOrDefault(key, 0) + times);
                key = "." + key;
            }

        }
        List<String> list = new LinkedList<>();
        for (String key : map.keySet()) {
            list.add(map.get(key) + " " + key);
        }
        return list;
    }
}
// @lc code=end

