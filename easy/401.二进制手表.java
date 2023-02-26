import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=401 lang=java
 *
 * [401] 二进制手表
 */

// @lc code=start
class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new LinkedList<>();
        for (int i = 0; i <= turnedOn; i++) {
            List<String> l1 = gen(i, 12);
            List<String> l2 = gen(turnedOn - i, 60);
            if (l1.isEmpty() || l2.isEmpty()) {
                continue;
            }
            for (String hour : l1) {
                for (String mins : l2) {
                    mins = mins.length() == 1 ? "0" + mins : mins;
                    ans.add(hour + ":" + mins);
                }
            }
        }
        return ans;
    }
    List<String> gen(int bits, int max) {
        List<String> list = new LinkedList<>();
        for (int i = 0; i < max; i++) {
            int tmp = 0;
            int j = i;
            while (j != 0) {
                if (j % 2 == 1) {
                    tmp++;
                }
                j /= 2;
            }
            if (tmp == bits) {
                list.add("" + i);
            }
        }
        return list;
    } 
}
// @lc code=end

