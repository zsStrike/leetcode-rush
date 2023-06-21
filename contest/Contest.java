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



class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (arrGcd(nums, 0, n - 1) != 1) return -1;
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int start = i, end = i + len - 1;
                if (arrGcd(nums, start, end) == 1) {
                    return len + n - 1;
                }
            }
        }
        return -1;
    }
    int arrGcd(int[] nums, int start, int end) {
        int res = nums[start];
        for (int i = start; i <= end; i++) {
            res = gcd(res, nums[i]);
        }
        return res;
    }
    int gcd(int a, int b) {
        if (a < b) return gcd(b, a);
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }
}



