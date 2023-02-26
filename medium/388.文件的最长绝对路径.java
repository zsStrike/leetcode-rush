import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=388 lang=java
 *
 * [388] 文件的最长绝对路径
 */

// @lc code=start
class Solution {
    public int lengthLongestPath(String input) {
        LinkedList<String> list = new LinkedList<>();
        int max = 0;
        String[] paths = input.split("\\n");
        // System.out.println(Arrays.toString(paths));
        int depth = 0;
        int i = 0;
        int n = paths.length;
        while (i < n) {
            // 文件
            int count = 0;
            int idx = 0;
            while (paths[i].indexOf("\t", idx) != -1) {
                count++;
                idx = paths[i].indexOf("\t", idx) + 1;
            }
            // System.out.println(count + " " + paths[i]);
            while (depth > count) {
                list.removeLast();
                depth--;
            }
            // System.out.println(list);
            if (paths[i].indexOf('.') != -1) {
                list.add(paths[i].substring(depth * 1));
                max = Math.max(max, String.join("/", list).length());
                list.removeLast();
            } else {
                list.add(paths[i].substring(depth * 1));
                depth++;
            }
            i++;
        }
        return max;
        // return 0;
    }
}
// @lc code=end

