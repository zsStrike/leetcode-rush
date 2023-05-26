package contest;
import java.util.*;

public class Contest {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString("/a/b".substring(1).split("/")));
        // System.out.println(sol.makeIntegerBeautiful(4545454545L, 15)); 
    }
    public static int[] parseArr(String arrStr) {
        // arrStr = [1, 2, 3, 4]
        arrStr = arrStr.substring(1, arrStr.length() - 1);
        String[] data = arrStr.split(",\\s?");
        return Arrays.stream(data).mapToInt(a -> Integer.parseInt(a)).toArray();
    }
}

/**
 * InnerContest
 */
class Solution {
    // n * sum1 = n1 * sum
    public boolean splitArraySameAverage(int[] nums) {
        if (nums.length == 1) return false;
        int n = nums.length, m = n / 2;
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] * n - sum;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < (1 << m); i++) {
            int total = 0;
            for (int j = 0; j < m; j++) {
                if ((i & (1 << j)) != 0) {
                    total += nums[j];
                }
            }
            if (total == 0) return true;
            set.add(total);
        }
        int rsum = 0;
        for (int i = m; i < n; i++) {
            rsum += nums[i];
        }
        for (int i = 1; i < (1 << (n - m)); i++) {
            int tot = 0;
            for (int j = m; j < n; j++) {
                if ((i & (1 << (j - m))) != 0) {
                    tot += nums[j];
                }
            }
            if (tot == 0 || (rsum != tot && set.contains(-tot))) {
                return true;
            }
        }    
        return false;    
    }
}


