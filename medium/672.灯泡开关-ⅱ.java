import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=672 lang=java
 *
 * [672] 灯泡开关 Ⅱ
 */

// @lc code=start
class Solution {
    // 0  0000
    // 1  0001 0010 0100 1000
    // 2  0000 0011 0110 1100 0101 1001 1010
    // 3  0001 0010 0100 1000 0111 1011 1101 1110
    // 4  0000 0011 0110 1100 0101 1001 1010 1111
    // 5  0001 0010 0100 1000 0111 1011 1101 1110
    // 6  
    public int flipLights(int n, int presses) {
        boolean[] lights = new boolean[n + 1];
        HashMap<String, String> map = new HashMap<>();
        HashMap<Integer, String[]> pat = new HashMap<>();
        pat.put(0, "0000".split(" "));
        pat.put(1, "0001 0010 0100 1000".split(" "));
        pat.put(2, "0000 0011 0110 1100 0101 1001 1010".split(" "));
        pat.put(3, "0001 0010 0100 1000 0111 1011 1101 1110".split(" "));
        pat.put(4, "0000 0011 0110 1100 0101 1001 1010 1111".split(" "));
        Arrays.fill(lights, true);
        for (int a = 0; a < 2; a++) {
            for (int b = 0; b < 2; b++) {
                for (int c = 0; c < 2; c++) {
                    for (int d = 0; d < 2; d++) {
                        Arrays.fill(lights, true);
                        int tmp = a;
                        while (tmp > 0) {
                            for (int i = 1; i <= n; i++) {
                                lights[i] = !lights[i];
                            }
                            tmp--;
                        }
                        tmp = b;
                        while (tmp > 0) {
                            for (int i = 2; i <= n; i += 2) {
                                lights[i] = !lights[i];
                            }
                            tmp--;
                        }
                        tmp = c;
                        while (tmp > 0) {
                            for (int i = 1; i <= n; i += 2) {
                                lights[i] = !lights[i];
                            }
                            tmp--;
                        }
                        tmp = d;
                        while (tmp > 0) {
                            for (int i = 1; i <= n; i += 3) {
                                lights[i] = !lights[i];
                            }
                            tmp--;
                        }
                        if (a == 0 && b == 0 && c == 1 && d == 0) {
                            System.out.println(Arrays.toString(lights));
                        }
                        map.put(a + "" + b + "" + c + "" + d, Arrays.toString(lights));                                                
                    }
                }
            }
        }
        System.out.println(map);
        while (presses > 4) {
            presses -= 2;
        }
        HashSet<String> set = new HashSet<>();
        for (String str : pat.get(presses)) {
            set.add(map.get(str));
        }
        System.out.println(set);
        return set.size();
    }
}
// @lc code=end

