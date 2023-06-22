package contest;
import java.util.*;

public class Contest {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.count("12", "1", 1, 8);
        // System.out.println(Arrays.toString("/a/b".substring(1).split("/")));
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
    public static final int MOD = (int) (1e9 + 7);
    HashMap<String, Long> memo = new HashMap<>();
    public int count(String num1, String num2, int min_sum, int max_sum) {
        long a = count(num2.toCharArray(), 0, true, 0, min_sum, max_sum);
        // System.out.println(a);
        memo.clear();
        long b = count(num1.toCharArray(), 0, true, 0, min_sum, max_sum);
        System.out.println(b);
        int tmp = (int) ((a + MOD - b ) % MOD);
        int s = 0;
        for (char c : num1.toCharArray()) {
            s += c - '0';
        }
        if (s >= min_sum && s <= max_sum) {
            return tmp + 1;
        }
        return tmp;
        // String.format("%25s", num1).replaceAll(" ", "0")
    }
    // 1-num1 满足条件的数字  n*MOD + a
    // 1-num2               m*MOD + b
    // (n - m)*MOD + (a - b)  % MOD  =>  n == m, a - b  n > m  a + MOD - b % MOD
    private long count(char[] cs, int index, boolean isLimit, int digitCount, int minSum, int maxSum) {
        String key = digitCount + " " + index + " " + isLimit;
        if (memo.containsKey(key)) return memo.get(key);
        int n = cs.length;
        if (index >= n) {
            if (digitCount >= minSum && digitCount <= maxSum) {
                return 1;
            } else {
                return 0;
            }
        }
        char min = '0';
        char max = isLimit ? cs[index] : '9';
        long sum = 0;
        for (char c = min; c <= max; c++) {
            if (digitCount + c - '0' > maxSum) {
                continue;
            }
            sum += count(cs, index + 1, isLimit && c == max, digitCount + c - '0', minSum, maxSum);
            System.out.println(c + " " + index + " " + sum);
            sum %= MOD;
        }
        if (index > 0) {
            memo.put(key, sum);
        }
        return sum;
    }
}




