import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=838 lang=java
 *
 * [838] 推多米诺
 */

// @lc code=start
class Solution {
    public String pushDominoes(String dominoes) {
        char[] cs = dominoes.toCharArray();
        int n = cs.length;
        HashSet<Integer> left = new HashSet<>();
        HashSet<Integer> right = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'L') {
                left.add(i);
            } else if (cs[i] == 'R') {
                right.add(i);
            }
        }
        while (!(left.isEmpty() && right.isEmpty())) {
            HashSet<Integer> ltmp = new HashSet<>();
            for (int i : left) {
                if (i - 1 >= 0 && cs[i - 1] != '.') {
                    continue;
                }
                if (i - 1 == 0 || i - 1 > 0 && !right.contains(i - 2)) {
                    ltmp.add(i - 1);
                    cs[i - 1] = 'L';
                }
            }
            HashSet<Integer> rtmp = new HashSet<>();
            for (int i : right) {
                if (i + 1 < n && cs[i + 1] != '.') {
                    continue;
                }                
                if (i + 1 == n - 1 || i + 1 < n - 1 && !left.contains(i + 2)) {
                    rtmp.add(i + 1);
                    cs[i + 1] = 'R';
                }
            }
            System.out.println(new String(cs));
            left = ltmp;
            right = rtmp;
        }
        return new String(cs);
    }
}
// @lc code=end

