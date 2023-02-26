import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=638 lang=java
 *
 * [638] 大礼包
 */

// @lc code=start
class Solution {
    // 尽可能购买大礼包，买不了的时候 直接单个买即可
    HashMap<String, Integer> memo = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(special, needs, price);
    }
    int dfs(List<List<Integer>> special, List<Integer> needs, List<Integer> price) {
        String key = genKey(needs);
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        int n = needs.size();
        int min = 0;
        for (int i = 0; i < n; i++) {
            min += price.get(i) * needs.get(i);
        }
        List<Integer> left = new LinkedList<>();
        for (List<Integer> spe : special) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (spe.get(i) > needs.get(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                for (int i = 0; i < n; i++) {
                    needs.set(i, needs.get(i) - spe.get(i));
                }
                int tmp = dfs(special, needs, price) + spe.get(n);
                if (tmp < min) {
                    min = tmp;
                    left = new LinkedList<>(needs);
                }
                for (int i = 0; i < n; i++) {
                    needs.set(i, needs.get(i) + spe.get(i));
                }                
            }
        }
        memo.put(key, min);
        return min;
        // if (min != Integer.MAX_VALUE) {

        // } else {
        //     min = 0;
        //     for (int i = 0; i < n; i++) {
        //         min += price.get(i) * needs.get(i);
        //     }
        //     memo.put(key, min);
        //     return min;
        // }
        
    }
    String genKey(List<Integer> needs) {
        return needs.toString();
    }
}
// @lc code=end

