import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=854 lang=java
 *
 * [854] 相似度为 K 的字符串
 */

// @lc code=start
class Solution {
    public int kSimilarity(String s1, String s2) {
        char[] cs1 = s1.toCharArray();
        char[] cs2 = s2.toCharArray();
        int n = cs1.length;
        Queue<char[]> queue = new LinkedList<>();
        queue.offer(cs1);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int iter = 0; iter < size; iter++) {
                char[] s = queue.poll();
                // System.out.println(s);
                if (isEqual(s, cs2)) {
                    return count;
                }
                int i = 0;
                for (i = 0; i < n; i++) {
                    if (s[i] != cs2[i]) {
                        break;
                    }
                }
                for (int j = i + 1; j < n; j++) {
                    if (s[j] == cs2[i]) {
                        char[] tmp = Arrays.copyOf(s, n);
                        tmp[i] = s[j];
                        tmp[j] = s[i];
                        queue.offer(tmp);
                    }
                }
            }
            count++;
        }
        return s1.length();
    }
    boolean isEqual(char[] c1, char[] c2) {
        int n = c1.length;
        for (int i = 0; i < n; i++) {
            if (c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
    
}
// @lc code=end

