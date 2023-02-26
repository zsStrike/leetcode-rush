import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=893 lang=java
 *
 * [893] 特殊等价字符串组
 */

// @lc code=start
class Solution {
    public int numSpecialEquivGroups(String[] words) {
        // 偶数下标对换，奇数下标对换
        // 分为两组，奇数组和偶数组按照自然序构成字符串
        HashSet<String> set = new HashSet<>();
        for (String word : words) {
            set.add(get(word));
        }
        return set.size();
    }
    String get(String word) {
        LinkedList<Character> list1 = new LinkedList<>();
        LinkedList<Character> list2 = new LinkedList<>();
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                list2.add(word.charAt(i));
            } else {
                list1.add(word.charAt(i));
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);
        return list1.toString() + " " + list2.toString();
    }
}
// @lc code=end

