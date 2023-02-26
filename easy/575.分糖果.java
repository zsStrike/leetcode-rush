import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=575 lang=java
 *
 * [575] 分糖果
 */

// @lc code=start
class Solution {
    public int distributeCandies(int[] candyType) {
        int types = Arrays.stream(candyType).mapToObj(a -> Integer.valueOf(a)).collect(Collectors.toSet()).size();
        return Math.min(types, candyType.length / 2);
    }
}
// @lc code=end

