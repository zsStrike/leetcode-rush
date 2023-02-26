import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=609 lang=java
 *
 * [609] 在系统中查找重复文件
 */

// @lc code=start
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] files = path.split(" ");
            for (int i = 1; i < files.length; i++) {
                int idx = files[i].indexOf("(");
                String filename = files[i].substring(0, idx);
                String content = files[i].substring(idx + 1, files[i].length() - 1);
                map.putIfAbsent(content, new ArrayList<>());
                map.get(content).add(files[0] + "/" + filename);
            }        
        }
        return map.keySet().stream().filter(a -> map.get(a).size() > 1).map(a -> map.get(a)).collect(Collectors.toList());
    }

}
// @lc code=end

