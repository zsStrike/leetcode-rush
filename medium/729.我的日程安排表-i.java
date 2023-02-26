import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=729 lang=java
 *
 * [729] 我的日程安排表 I
 */

// @lc code=start
class MyCalendar {
    TreeMap<Integer, Integer> map;;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        if (map.isEmpty()) {
            map.put(start, end);
            return true;
        }
        Integer lower = map.lowerKey(start);
        if (lower != null) {
            if (map.get(lower) > start) {
                return false;
            } else {
                lower = map.higherKey(lower);
            }
        } else {
            lower = map.ceilingKey(start);
        }
        while (lower != null) {
            if (lower < end) {
                return false;
            }
            lower = map.higherKey(lower);
        }        
        map.put(start, end);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

