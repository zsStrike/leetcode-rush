import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=824 lang=java
 *
 * [824] 山羊拉丁文
 */

// @lc code=start
class Solution {
    public String toGoatLatin(String sentence) {
        String data = "AaEeIiOoUu";
        HashSet<Character> set = new HashSet<>();
        for (char c : data.toCharArray()) {
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        String as = "a";
        for (String word : sentence.split(" ")) {
            if (set.contains(word.charAt(0))) {
            } else {
                word = word.substring(1) + word.substring(0, 1);
            }
            word = word + "ma";
            word = word + as;
            as = as + "a";
            sb.append(word + " ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
// @lc code=end

