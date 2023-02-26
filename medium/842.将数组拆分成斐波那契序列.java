import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=842 lang=java
 *
 * [842] 将数组拆分成斐波那契序列
 */

// @lc code=start
class Solution {
    public List<Integer> splitIntoFibonacci(String num) {
        int n = num.length();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i < n; i++) {
            if (num.charAt(0) == '0' && i != 1) {
                continue;
            }
            if (i > 13 || Long.parseLong(num.substring(0, i)) > Integer.MAX_VALUE) {
                continue;
            }
            int first = Integer.parseInt(num.substring(0, i));
            list.add(first);
            for (int j = i + 1; j < n; j++) {
                if (num.charAt(i) == '0' && j != i + 1) {
                    continue;
                }
                if (j - i > 13 || Long.parseLong(num.substring(i, j)) > Integer.MAX_VALUE) {
                    continue;
                }
                int second = Integer.parseInt(num.substring(i, j));
                list.add(second);
                if (dfs(num, j, first, second, list)) {
                    return list;
                }
                list.removeLast();
            }
            list.removeLast();
        }
        return list;
    }
    boolean dfs(String num, int cur, int first, int second, LinkedList<Integer> list) {
        if (cur == num.length()) {
            return true;
        }
        int target = first + second;
        char[] cs = String.valueOf(target).toCharArray();
        int i = 0;
        while (i < cs.length && cur + i < num.length() && cs[i] == num.charAt(cur + i)) {
            i++;
        }
        if (i == cs.length) {
            list.add(target);
            if (dfs(num, cur + i, second, target, list)) {
                return true;
            }
            list.removeLast();
        }
        return false;
    }
}
// @lc code=end

