import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=648 lang=java
 *
 * [648] 单词替换
 */

// @lc code=start
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Collections.sort(dictionary, (a, b) -> a.length() < b.length() ? -1 : a.length() == b.length() ? a.compareTo(b) : 1);
        // System.out.println(dictionary);
        String[] dics = dictionary.toArray(new String[0]);
        String[] words = sentence.split(" ");
        List<String> ans = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            int j;
            for (j = 0; j < dics.length; j++) {
                if (words[i].startsWith(dics[j])) {
                    ans.add(dics[j]);
                    break;
                }
            }
            if (j == dics.length) {
                ans.add(words[i]);
            }
        }
        return String.join(" ", ans.toArray(new String[0])); 
    }
}
// @lc code=end

