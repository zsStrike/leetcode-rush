/*
 * @lc app=leetcode.cn id=717 lang=java
 *
 * [717] 1 比特与 2 比特字符
 */

// @lc code=start
class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int len = bits.length;
        if (len == 1) {
            return true;
        }
        if (bits[len - 2] == 0) {
            return true;
        } else {
            return !isValid(bits, 0, len - 3);
        }
    }
    private boolean isValid(int[] bits, int left, int right) {
        if (left > right) {
            return true;
        }
        if (left == right) {
            return bits[left] == 0;
        }
        if (bits[right] == 0) {
            if (bits[right - 1] == 0) {
                return isValid(bits, left, right - 1);
            } else {
                return isValid(bits, left, right - 1) || isValid(bits, left, right - 2);
            }
        } else {
            if (bits[right - 1] == 0) {
                return false;
            } else {
                return isValid(bits, left, right - 2);
            }
        }
    }
}
// @lc code=end

