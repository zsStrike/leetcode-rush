import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=593 lang=java
 *
 * [593] 有效的正方形
 */

// @lc code=start
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] edges = new int[4][2];
        edges[0] = p1;
        edges[1] = p2;
        edges[2] = p3;
        edges[3] = p4;
        Arrays.sort(edges, (a, b) -> a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]);
        if (edges[0][0] == edges[1][0]) {
            long len = getLen(edges[0], edges[1]);
            if (len == getLen(edges[0], edges[2]) && len == getLen(edges[2], edges[3]) && len == getLen(edges[1], edges[3])) {
                if (edges[0][1] == edges[2][1] && len != 0) {
                    return true;
                }
            }
            return false;
        } else {
            long len = getLen(edges[0], edges[1]);
            if (len == getLen(edges[0], edges[2]) && len == getLen(edges[2], edges[3]) && len == getLen(edges[1], edges[3])) {
                int x1 = edges[0][0] - edges[1][0];
                int y1 = edges[0][1] - edges[1][1];
                int x2 = edges[0][0] - edges[2][0];
                int y2 = edges[0][1] - edges[2][1];
                if (x1 * x2 + y1 * y2 == 0 && len != 0) {
                    return true;
                }
            }
            return false;            
        }
    }
    private long getLen(int[] p1, int[] p2) {
        int da = p1[0] - p2[0];
        int db = p1[1] - p2[1];
        return da * da + db * db;
    }
}
// @lc code=end

