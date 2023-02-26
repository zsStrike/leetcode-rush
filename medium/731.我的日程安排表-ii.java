import java.util.Arrays;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=731 lang=java
 *
 * [731] 我的日程安排表 II
 */

// @lc code=start
// ["MyCalendarTwo","book","book","book","book","book","book","book","book","book","book"]\n[[],[28,46],[9,21],[21,39],[37,48],[38,50],[22,39],[45,50],[1,12],[40,50],[31,44]]
class MyCalendarTwo {

    TreeMap<Integer, int[]> map;

    public MyCalendarTwo() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        System.out.println(start + " " + end);
        // debug();
        if (map.isEmpty()) {
            map.put(start, new int[]{end, 1});
            return true;
        }
        Integer lower = map.lowerKey(start);
        if (lower != null && map.get(lower)[0] > start) {
            if (map.get(lower)[1] == 2) {
                return false;
            }
            // insert
        }
        Integer higher = map.ceilingKey(start);
        while (higher != null && higher < end) {
            if (map.get(higher)[1] == 2) {
                return false;
            }
            higher = map.higherKey(higher);
        }
        lower = map.lowerKey(start);
        if (lower != null && map.get(lower)[0] > start) {
            System.out.println(lower + " " + map.get(lower)[0]);
            if (map.get(lower)[0] > end) {
                int tmp = map.get(lower)[0];
                map.put(lower, new int[]{start, 1});
                map.put(start, new int[]{end, 2});
                map.put(end, new int[]{tmp, 1});
                // map.remove(lower);
                return true;
            } else if(map.get(lower)[0] == end) {
                map.put(lower, new int[]{start, 1});
                map.put(start, new int[]{end, 2});
                // map.remove(lower);                
                return true;
            } else {
                int tmp = map.get(lower)[0];
                map.put(lower, new int[]{start, 1});
                map.put(start, new int[]{tmp, 2});
                start = tmp;
                // map.remove(lower);                      
            }
        }
        // debug();
        higher = map.ceilingKey(start);
        while (higher != null && higher < end) {
            if (start != higher) {
                map.put(start, new int[]{higher, 1});
            }
            if (map.get(higher)[0] <= end) {
                map.put(higher, new int[]{map.get(higher)[0], 2});
            } else {
                int tmp = map.get(higher)[0];
                map.put(higher, new int[]{end, 2});
                end = tmp;
            }
            start = map.get(higher)[0];
            higher = map.ceilingKey(start);  
        }
        if (start < end) {
            map.put(start, new int[]{end, 1});
        }
        return true;
    }
    void debug() {
        for (int key : map.keySet()) {
            System.out.print(key + "=" + Arrays.toString(map.get(key)));
        }
        System.out.println();
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
// @lc code=end

