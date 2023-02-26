/*
 * @lc app=leetcode.cn id=385 lang=java
 *
 * [385] 迷你语法分析器
 */

// @lc code=start
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        return deserialize(s, 0, s.length() - 1);
    }
    private NestedInteger deserialize(String s, int start, int end) {
        if (s.charAt(start) != '[') {
            return new NestedInteger(Integer.parseInt(s.substring(start, end + 1)));
        }
        NestedInteger ni = new NestedInteger();
        int pre = start + 1;
        for (int i = pre; i < end; i++) {
            if (s.charAt(i) == ',') {
                continue;
            }
            pre = i;
            if (s.charAt(i) == '[') {
                int count = 1;
                i++;
                while (i < end && count != 0) {
                    if (s.charAt(i) == '[') {
                        count++;
                    } else if (s.charAt(i) == ']') {
                        count--;
                    }
                    i++;
                }
                i--;
                ni.add(deserialize(s, pre, i));
            } else {
                int num = 1;
                while (i < end && s.charAt(i) != ',') {
                    i++;
                }
                i--;
                ni.add(deserialize(s, pre, i));
            }
        }
        return ni;
    }
}
// @lc code=end

