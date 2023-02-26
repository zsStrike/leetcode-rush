import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=914 lang=java
 *
 * [914] 卡牌分组
 */

// @lc code=start
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        Arrays.sort(deck);
        int left = 0;
        int size = -1;
        while (left < deck.length) {
            int right = left + 1;
            while (right < deck.length && deck[right] == deck[left]) {
                right++;
            }
            int count = right - left;
            if (size == -1) {
                size = count;
            }
            size = gcd(size, count);
            if (size == 1) {
                return false;
            }
            left = right;
        }
        return true;
    }
    int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
// @lc code=end

