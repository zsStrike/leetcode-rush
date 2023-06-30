package contest;
import java.util.*;

public class Contest {
    public static void main(String[] args) {
        Solution sol = new Solution();
        // sol.count("12", "1", 1, 8);
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
    class Node {
        int x;
        int y;
        int next = -1;
        int res = 0;
        Node (int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public int[] maximumSumQueries(int[] nums1, int[] nums2, int[][] queries) {
        int n = nums1.length;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(nums1[i], nums2[i]);
        }
        Arrays.sort(nodes, (a, b) -> a.x == b.x ? b.y - a.y : a.x - b.x);
        nodes[n - 1].next = n;
        for (int i = n - 2; i >= 0; i--) {
            if (nodes[i].x == nodes[i + 1].x) {
                nodes[i].next = nodes[i + 1].next;
            } else {
                nodes[i].next = i + 1;
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int[] query : queries) {
            int x = query[0], y = query[1];
            int start = bs(nodes, x);
            int max = 0;
            while (start < n) {
                if (nodes[start].y > y) {
                    max = Math.max(max, nodes[start].x + nodes[start].y);
                    start++;
                } else {
                    start = nodes[start].next;
                }
            }
            list.add(max);
        }
        return list.stream().mapToInt(a -> a).toArray();
    }
    int bs(Node[] nodes, int x) {
        int left = 0, right = nodes.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nodes[mid].x == x) {
                left = mid + 1;
            } else if (nodes[mid].x < x) {
                left = mid + 1;
            } else if (nodes[mid].x > x) {
                right = mid;
            }
        }
        return right;
    }
}




