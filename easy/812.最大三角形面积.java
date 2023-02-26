/*
 * @lc app=leetcode.cn id=812 lang=java
 *
 * [812] 最大三角形面积
 */

// @lc code=start
class Solution {
    // s = 
    public double largestTriangleArea(int[][] points) {
        int n = points.length;
        double max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    double a = getLen(points[i], points[j]);
                    double b = getLen(points[j], points[k]);
                    double c = getLen(points[k], points[i]);
                    double p = (a + b + c) / 2;
                    if (a + b <= c || b + c <= a || c + a <= b) {
                        continue;
                    }
                    max = Math.max(max, Math.sqrt(p * (p - a) * (p - b) * (p - c)));
                }
            }
        }
        return max;
    }
    double getLen(int[] a, int[] b) {
        int dx = a[0] - b[0];
        int dy = a[1] - b[1];
        return Math.sqrt(dx * dx + dy * dy);
    }
}
// @lc code=end

