import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=784 lang=java
 *
 * [784] 字母大小写全排列
 */

// @lc code=start
class Solution {
    public List<String> letterCasePermutation(String s) {
        return letterCasePermutation(s.toCharArray(), 0, new LinkedList<>());
    }
    List<String> letterCasePermutation(char[] cs, int start, List<String> res) {
        if (start == cs.length) {
            res.add(String.valueOf(cs));
            return res;
        }
        if (Character.isDigit(cs[start])) {
            return letterCasePermutation(cs, start + 1, res);
        }
        letterCasePermutation(cs, start + 1, res);
        if (cs[start] >= 'a' && cs[start] <= 'z') {
            cs[start] -= ' ';
            letterCasePermutation(cs, start + 1, res);
            cs[start] += ' ';
        }
        if (cs[start] >= 'A' && cs[start] <= 'Z') {
            cs[start] += ' ';
            letterCasePermutation(cs, start + 1, res);
            cs[start] -= ' ';
        }
        return res.stream().distinct().collect(Collectors.toList());
    }
}
// @lc code=end

