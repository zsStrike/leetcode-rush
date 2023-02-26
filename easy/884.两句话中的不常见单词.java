import java.util.Arrays;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=884 lang=java
 *
 * [884] 两句话中的不常见单词
 */

// @lc code=start
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        String[]s1v = s1.split(" ");
        String[]s2v = s2.split(" ");
        HashMap<String ,Integer> map = new HashMap<>();
        for(String s:s1v) map.put(s,map.getOrDefault(s,0)+1);
        for(String s:s2v) map.put(s,map.getOrDefault(s,0)+1);
        
        List<String> list = new ArrayList<>();
        for(String s:map.keySet()){
            if(map.get(s)==1){
                list.add(s);
            }
        }
        String[] result = new String[list.size()];
        int idx = 0;
        for(String s:list){
            result[idx++] = s;
        }
        return result;
    }
}


// @lc code=end

