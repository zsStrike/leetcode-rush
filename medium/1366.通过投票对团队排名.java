import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1366 lang=java
 *
 * [1366] 通过投票对团队排名
 */

// @lc code=start
class Solution {
    class Item {
        char c = '0';
        int[] count = new int[26];
    }
    public String rankTeams(String[] votes) {
        Item[] items = new Item[26];
        for (int i = 0; i < 26; i++) {
            items[i] = new Item();
        }
        for (String vote : votes) {
            for (int i = 0; i < vote.length(); i++) {
                items[vote.charAt(i) - 'A'].c = vote.charAt(i);
                items[vote.charAt(i) - 'A'].count[i]++;
            }
        }
        Arrays.sort(items, (a, b) -> Arrays.compare(a.count, b.count) == 0 ? b.c - a.c : Arrays.compare(a.count, b.count));
        StringBuilder sb = new StringBuilder();
        for (Item item : items) {
            sb.append(item.c == '0' ? "" : item.c);
        }
        return sb.reverse().toString();
    }
}
// @lc code=end

