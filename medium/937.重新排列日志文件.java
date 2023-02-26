import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=937 lang=java
 *
 * [937] 重新排列日志文件
 */

// @lc code=start
class Solution {
    public String[] reorderLogFiles(String[] logs) {
        LinkedList<String> numLogs = new LinkedList<>();
        LinkedList<String[]> strLogs = new LinkedList<>();
        for (String log : logs) {
            String[] l = splitTagAndData(log);
            if (Character.isDigit(l[1].charAt(0))) {
                numLogs.add(log);
            } else {
                strLogs.add(l);
            }
        }
        Collections.sort(strLogs, (a, b) -> {
            if (a[1].equals(b[1])) {
                return a[0].compareTo(b[0]);
            }
            return a[1].compareTo(b[1]);        
        });
        List<String> slogs = strLogs.stream().map(a -> a[0] + " " + a[1]).collect(Collectors.toList());
        slogs.addAll(numLogs);
        return slogs.toArray(new String[0]);
    }
    String[] splitTagAndData(String log) {
        int i = log.indexOf(" ");
        String tag = log.substring(0, i);
        String data = log.substring(i + 1);
        return new String[] {tag, data};
    }
}
// @lc code=end

