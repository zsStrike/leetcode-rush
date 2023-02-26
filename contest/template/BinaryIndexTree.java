
package contest.template;

/**
 * BinaryIndexTree 树状数组  https://pic.leetcode-cn.com/1649012850-nVvqGg-image.png
 * 用于解决区间问题，适用于点修改的情况，注意**索引从 1 开始**
 * lowbit(idx)：获取二进制表示的最后一位 1 表示的元素大小，用于向上传递或者向下传递
 * update(idx, val): 将 x 索引的位置元素修改为 val，需要向上传递
 * query(idx): 在 [0, idx] 区间内计算 sum 或者 最大值等统计量
 * 下面的实现方式基于求区间和实现
 */
class BinaryIndexTree {

    int[] nums;
    int[] sum;

    BinaryIndexTree(int[] nums) {
        int n = nums.length;
        this.nums = new int[n];
        sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update(i, nums[i]);
        }
    }

    int lowbit(int x) {
        return x & (-x);
    }

    void update(int idx, int val) {
        int delta = val - nums[idx];
        nums[idx] = val;
        idx += 1;
        int n = sum.length;
        while (idx < n) {
            sum[idx] += delta;
            idx += lowbit(idx);
        }
    }

    int query(int idx) {
        idx += 1;
        int ans = 0;
        while (idx > 0) {
            ans += sum[idx];
            idx -= lowbit(idx);
        }
        return ans;
    }

}