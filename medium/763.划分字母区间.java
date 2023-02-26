import java.util.HashMap;
import java.util.LinkedList;

import javafx.scene.control.CheckBox;

/*
 * @lc app=leetcode.cn id=763 lang=java
 *
 * [763] 划分字母区间
 */

// @lc code=start
class Solution {
    public List<Integer> partitionLabels(String s) {
        LinkedList<Integer> list = new LinkedList<>();
        if (s.length() == 0) {
            return list;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), i);
        }      
        int left = 0;
        while (left < n) {
            int right = map.get(s.charAt(left));
            while (right < n) {
                boolean flag = true;
                int tmp = right;
                for (int i = left; i <= right; i++) {
                    if (map.get(s.charAt(i)) > tmp) {
                        flag = false;
                        tmp = map.get(s.charAt(i));
                        break;
                    }
                }
                if (flag) {
                    break;
                }
                right = tmp;
            }            
            list.add(right - left + 1);
            left = right + 1;
        }  
        return list;

    }

}
// @lc code=end

