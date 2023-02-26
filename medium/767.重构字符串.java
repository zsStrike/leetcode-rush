import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 */

// @lc code=start
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=767 lang=java
 *
 * [767] 重构字符串
 */

// @lc code=start
class Solution {
    class Node {
        int count;
        char c;
        Node (int count, char c) {
            this.count = count;
            this.c = c;
        }
    }
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 26; i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }
        int left = s.length() - max;
        if (left < max - 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                pq.offer(new Node(count[i], (char) (i + 'a')));
            }
        }
        while (!pq.isEmpty()) {
            Node mn = pq.poll();
            Node nn = pq.poll();
            
            while (mn.count > 0) {
                sb.append(mn.c);
                mn.count--;
                if (mn.count != 0) {
                    
                    if (nn == null) {
                        for (int i = 0; i < mn.count; i++) {
                            sb.insert(i * 2, mn.c);    
                        }
                                          
                        break;
                    }      
                               
                    sb.append(nn.c);
                    nn.count--;
                    if (nn.count == 0) {
                        nn = pq.poll();
                    }
                }
            }
             
            if (nn != null && nn.count > 0) {
                pq.offer(nn);
            }
        }
        return sb.toString();
    }

}
// @lc code=end


// @lc code=end

