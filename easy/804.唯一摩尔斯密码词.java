import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=804 lang=java
 *
 * [804] 唯一摩尔斯密码词
 */

// @lc code=start
class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.setLength(0);
            for (char c : word.toCharArray()) {
                sb.append(codes[c - 'a']);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}
// @lc code=end

