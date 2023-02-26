import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

import javax.management.Query;

/*
 * @lc app=leetcode.cn id=891 lang=java
 *
 * [891] 子序列宽度之和
 */

// @lc code=start

class Solution {
    TreeSet<Integer> set = new TreeSet<>();
    String primes = "2357";
    public int beautifulPartitions(String s, int k, int minLength) {
        int len = s.length();
        if (primes.indexOf(s.charAt(0)) == -1 || primes.indexOf(s.charAt(len - 1)) != -1) {
            return 0;
        }
        return beautifulPartitions(s.toCharArray(), k, minLength, 0);
    }
    int beautifulPartitions(char[] cs, int k, int minLength, int cur) {
        if (k == 1) {
            return 1;
        }
        
    }
    void preProcess(String s) {
        for (int i = 1; i < s.length() - 2; i++) {
            if (primes.indexOf(s.charAt(i)) == -1 && primes.indexOf(s.charAt(i + 1)) != -1) {
                set.add(i);
            }
        }
    }
}

// @lc code=end

