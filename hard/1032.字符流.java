import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=1032 lang=java
 *
 * [1032] 字符流
 */

// @lc code=start
class StreamChecker {
    Trie trie;
    ArrayList<Character> list;
    public StreamChecker(String[] words) {
        list = new ArrayList<>();
        trie = new Trie();
        for (String word : words) {
            trie.add(new StringBuilder(word).reverse().toString().toCharArray());
        }
    }
    
    public boolean query(char letter) {
        list.add(letter);
        return trie.query(list);
    }
}

class Trie {
    class TrieNode {
        TrieNode[] nodes = new TrieNode[26];
        boolean isEnd = false;
    }
    private TrieNode root = new TrieNode();
    void add(char[] cs) {
        TrieNode cur = root;
        for (int i = 0, n = cs.length; i < n; i++) {
            int idx = cs[i] - 'a';
            if (cur.nodes[idx] == null) {
                cur.nodes[idx] = new TrieNode();
            }
            cur = cur.nodes[idx];
        }
        cur.isEnd = true;
    }
    boolean query(ArrayList<Character> chars) {
        int size = chars.size();
        TrieNode cur = root;
        for (int i = size - 1; i >= 0; i--) {
            int idx = chars.get(i) - 'a';
            if (cur.nodes[idx] == null) {
                return false;
            }
            cur = cur.nodes[idx];
            if (cur.isEnd) {
                return true;
            }
        }
        return false;
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */
// @lc code=end

