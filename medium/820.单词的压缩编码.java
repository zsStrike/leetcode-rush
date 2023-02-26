import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode.cn id=820 lang=java
 *
 * [820] 单词的压缩编码
 */

// @lc code=start
class Solution {
    public int minimumLengthEncoding(String[] words) {
        words = Arrays.stream(words).collect(Collectors.toSet()).toArray(new String[0]);
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = new StringBuilder(words[i]).reverse().toString();
            trie.insert(word);
        }
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String word = new StringBuilder(words[i]).reverse().toString();
            if (!trie.prefix(word)) {
                count += word.length() + 1;
            }
        }
        return count;
    }
}
class Trie {
    class Node {
        Node[] cs;
        Node () {
            cs = new Node[26];
        }
    }
    Node root = null;
    Trie () {
        root = new Node();
    }

    void insert(String str) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (node.cs[c - 'a'] == null) {
                node.cs[c - 'a'] = new Node();
            }
            node = node.cs[c - 'a'];
        }
    }

    boolean prefix(String str) {
        Node node = root;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (node.cs[c - 'a'] == null) {
                return false;
            }
            node = node.cs[c - 'a'];
        }
        for (int i = 0; i < 26; i++) {
            if (node.cs[i] != null) {
                return true;
            }
        }
        return false;
    }
}
// @lc code=end

