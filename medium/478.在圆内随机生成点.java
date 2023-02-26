import java.util.Random;

/*
 * @lc app=leetcode.cn id=478 lang=java
 *
 * [478] 在圆内随机生成点
 */

// @lc code=start
class Solution {
    // 极坐标
    // theta r
    double x_center, y_center, radius;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }
    
    public double[] randPoint() {
        Random random = new Random();
        double theta = random.nextDouble() * 2 * Math.PI;
        double len = Math.sqrt(random.nextDouble()) * radius;
        // [0, 1) [0, 1]
        double x = x_center + len * Math.cos(theta);
        double y = y_center + len * Math.sin(theta);
        return new double[] {x, y};
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */
// @lc code=end

