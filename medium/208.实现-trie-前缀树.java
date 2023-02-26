/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    class TrieNode {
        boolean isWord;
        char val;
        TrieNode[] children;
        TrieNode(char i, boolean isWord) {
            this.val = i;
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }

    TrieNode root = null;

    public Trie() {
        root = new TrieNode('0', false);
    }
    
    public void insert(String word) {
        TrieNode node = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode((char)(idx + 'a'), i == len - 1);
            }
            node = node.children[idx];
        }
        node.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        int len = word.length();
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return node.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        int len = prefix.length();
        for (int i = 0; i < len; i++) {
            int idx = prefix.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return false;
            }
            node = node.children[idx];
        }
        return true;        
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
// @lc code=end

