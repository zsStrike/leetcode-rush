import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=735 lang=java
 *
 * [735] 行星碰撞
 */

// @lc code=start
class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int num : asteroids) {
            // System.out.println(list);
            if (list.isEmpty()) {
                list.add(num);
                continue;
            }
            if (list.peekLast() * num > 0) {
                list.add(num);
                continue;
            }
            boolean noAdd = false;
            while (!list.isEmpty()) {
                if (list.peekLast() * num > 0 || (list.peekLast() < 0 && num > 0)) {
                    // noAdd = true;
                    break;
                }
                if (list.peekLast() + num == 0) {
                    list.removeLast();
                    noAdd = true;
                    break;
                }
                if ((list.peekLast() + num) * num > 0) {
                    list.removeLast();
                    continue;
                }
                // System.out.println(list + "---");
                noAdd = true;
                break;
            }
            if (!noAdd) {
                list.add(num);
            }
        }
        return list.stream().mapToInt(a -> a).toArray();
    }
}
// @lc code=end

