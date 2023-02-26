import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=752 lang=java
 *
 * [752] 打开转盘锁
 */

// @lc code=start
class Solution {
    public int openLock(String[] deadends, String target) {
        // bfs    
        Set<String> deads = Arrays.stream(deadends).collect(Collectors.toSet());
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        if (deads.contains("0000")) {
            return -1;
        }
        queue.offer("0000");
        int count = 0;
        while (!queue.isEmpty()) {
            System.out.println(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(target)) {
                    return count;
                }
                for (int j = 0; j < 4; j++) {
                    StringBuilder sb = new StringBuilder(cur);
                    char c = sb.charAt(j);
                    char left = (char) (((c - '0' + 1) % 10) + '0');
                    char right = (char) ((c - '0' - 1 + 10) % 10 + '0');
                    sb.setCharAt(j, left);
                    if (!visited.contains(sb.toString()) && !deads.contains(sb.toString())) {
                        visited.add(sb.toString());
                        queue.offer(sb.toString());
                    }
                    sb.setCharAt(j, right);
                    if (!visited.contains(sb.toString()) && !deads.contains(sb.toString())) {
                        visited.add(sb.toString());
                        queue.offer(sb.toString());
                    }                    
                }
            }
            count++;
        }
        return -1;
    }
    
}
// @lc code=end

