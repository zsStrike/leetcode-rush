import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * @lc app=leetcode.cn id=331 lang=java
 *
 * [331] 验证二叉树的前序序列化
 */

// @lc code=start
class Solution {
    public boolean isValidSerialization(String preorder) {
        while (preorder.split(",").length > 1) {
            String next = preorder.replaceAll("\\d+,#,#", "#");
            if (next.equals(preorder)) {
                return false;
            }
            preorder = next;
        }
        return preorder.equals("#");
    }
}
// @lc code=end

