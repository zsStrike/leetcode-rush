import java.util.ArrayDeque;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=402 lang=java
 *
 * [402] 移掉 K 位数字
 */

// @lc code=start
class Solution {
    // 54321 3 21
    // 54213 
    // 12345 3 345
    // 15434745 3 
    class Node {
        char c;
        int idx;
        Node (char c, int idx) {
            this.c = c;
            this.idx = idx;
        }
    }
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        ArrayDeque<Node> stack = new ArrayDeque<>();
        LinkedList<Integer> dels = new LinkedList<>();
        int len = num.length();
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            if (stack.isEmpty()) {
                stack.push(new Node(c, i));
            } else {
                while (!stack.isEmpty() && k > 0 && stack.peek().c > c) {
                    dels.add(stack.pop().idx);
                    // System.out.println(dels);
                    k--;
                }
                if (k == 0) {
                    break;
                }
                stack.push(new Node(c, i));
            }
        }
        // while (k > 0) {
        //     dels.add(stack.pop().idx);
        //     k--;
        // }
        System.out.println(dels);
        StringBuilder sb = new StringBuilder(num);
        Collections.sort(dels);
        while (!dels.isEmpty()) {
            // System.out.println(sb + " " + dels.peekFirst());
            sb.deleteCharAt(dels.removeLast());
        }
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        String ans = sb.toString();
        int cur = 0;
        while (cur < ans.length() && ans.charAt(cur) == '0') {
            cur++;
        }
        return ans.substring(cur).equals("") ? "0" : ans.substring(cur);
    }
    
}
// @lc code=end

