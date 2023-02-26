import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=690 lang=java
 *
 * [690] 员工的重要性
 */

// @lc code=start
/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Integer> impMap = new HashMap<>();
        HashMap<Integer, List<Integer>> subMap = new HashMap<>();
        for (Employee emp : employees) {
            impMap.put(emp.id, emp.importance);
            subMap.put(emp.id, emp.subordinates);
        }
        int ans = impMap.get(id);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(id);
        List<Integer> cur = subMap.get(id);
        while (cur.size() != 0) {
            LinkedList<Integer> next = new LinkedList<>();
            for (int i : cur) {
                ans += impMap.get(i);
                for (int j : subMap.get(i)) {
                    if (!visited.contains(j)) {
                        visited.add(j);
                        next.add(j);
                    }
                }
            }
            cur = next;
        }
        return ans;
    }
}
// @lc code=end

