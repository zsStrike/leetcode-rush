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
// 左右贪心遍历 ？
class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        Collections.sort(robot);
        int[][] copy = new int[factory.length][2];
        for (int i = 0; i < factory.length; i++) {
            copy[i] = Arrays.copyOf(factory[i], 2);
        }
        return Math.min(leftTravel(robot, factory), rightTravel(robot, copy));
    }
    public long leftTravel(List<Integer> robot, int[][] factory) {
        long sum = 0;
        for (int i = 0; i < robot.size(); i++) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int j = 0; j < factory.length; j++) {
                if (factory[j][1] == 0) {
                    continue;
                }
                int dis = Math.abs(robot.get(i) - factory[j][0]);
                if (min > dis) {
                    min = dis;
                    idx = j;
                }
            }
            factory[idx][1]--;
            sum += min;
        }
        return sum;
    }
    public long rightTravel(List<Integer> robot, int[][] factory) {
        long sum = 0;
        for (int i = robot.size() - 1; i >= 0; i--) {
            int min = Integer.MAX_VALUE;
            int idx = -1;
            for (int j = 0; j < factory.length; j++) {
                if (factory[j][1] == 0) {
                    continue;
                }
                int dis = Math.abs(robot.get(i) - factory[j][0]);
                if (min > dis) {
                    min = dis;
                    idx = j;
                }
            }
            factory[idx][1]--;
            sum += min;
        }
        return sum;
    }    
}



