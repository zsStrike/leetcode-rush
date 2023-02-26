import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start
class Solution {
    static HashSet<Character> set = new HashSet<>();
    static {
        set.add('A');
        set.add('a');
        set.add('E');
        set.add('e');
        set.add('I');
        set.add('i');
        set.add('O');
        set.add('o');
        set.add('U');
        set.add('u');
    }
    public String reverseVowels(String s) {
        int len = s.length();
        int left = 0, right = len - 1;
        char[] cs = s.toCharArray();
        while (left < right) {
            while (left < right && !set.contains(cs[left])) {
                left++;
            }
            while (right > left && !set.contains(cs[right])) {
                right--;
            }
            System.out.println(left + " " + right);
            char tmp = cs[left];
            cs[left] = cs[right];
            cs[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(cs);
    }

}
// @lc code=end

