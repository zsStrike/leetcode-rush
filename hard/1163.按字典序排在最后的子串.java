import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=1163 lang=java
 *
 * [1163] 按字典序排在最后的子串
 */

// @lc code=start
class Solution {
    class Node {
        char ch;
        int idx;
        Node(char ch, int idx) {
            this.ch = ch;
            this.idx = idx;
        }
    }
    public String lastSubstring(String s) {
        int[] show = new int[26];
        char[] cs = s.toCharArray();
        for (char c : cs) {
            show[c - 'a']++;
        }
        char last = 'z';
        while (show[last - 'a'] == 0) {
            last--;
        }
        if (show[last - 'a'] == cs.length) {
            return s;
        }
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.ch - a.ch);
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == last) {
                queue.offer(new Node(last, i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            PriorityQueue<Node> next = new PriorityQueue<>(queue.comparator());
            char c = queue.peek().ch;
            sb.append(c);
            while (!queue.isEmpty() && queue.peek().ch == c) {
                Node node = queue.poll();
                if (node.idx == cs.length - 1) continue;
                node.idx++;
                node.ch = cs[node.idx];
                next.add(node);
            }
            queue = next;
        }
        return sb.toString();
    }
}
class Trie {
    class Node {
        Node[] next = new Node[26];
        char ch;
        Node(char ch) {
            this.ch = ch;
        }
    }
    Node root = new Node('\0');
    void insert(char[] cs, int start, int end) {
        // System.out.println(String.valueOf(cs, start, end - start + 1));
        Node cur = root;
        for (int i = start; i <= end; i++) {
            char c = cs[i];
            int idx = c - 'a';
            if (cur.next[idx] == null) {
                cur.next[idx] = new Node(c);
            }
            cur = cur.next[idx];
        }
    }
    String getRight() {
        StringBuilder sb = new StringBuilder();
        Node cur = root;
        Node[] next = cur.next;
        boolean flag = true;
        while (next != null && flag == true) {
            flag = false;
            for (int i = 25; i >= 0; i--) {
                if (next[i] != null) {
                    sb.append(next[i].ch);
                    cur = next[i];
                    next = cur.next;
                    flag = true;
                    break;
                }
            }
        }
        return sb.toString();
    }
}
// @lc code=end

