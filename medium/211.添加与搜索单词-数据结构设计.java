/*
 * @lc app=leetcode.cn id=211 lang=java
 *
 * [211] 添加与搜索单词 - 数据结构设计
 */

// @lc code=start
class WordDictionary {

    Trie trie;

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

        public boolean search2(String word, int cur, TrieNode root) {
            int len = word.length();
            if (cur == len) {
                return root.isWord;
            }
            if (word.charAt(cur) == '.') {
                for (int i = 0; i < 26; i++) {
                    if (root.children[i] == null) {
                        continue;
                    }
                    if (search2(word, cur + 1, root.children[i])) {
                        return true;
                    }
                }
                return false;
            } else {
                int idx = word.charAt(cur) - 'a';
                if (root.children[idx] == null) {
                    return false;
                }
                return search2(word, cur + 1, root.children[idx]);
            }
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

    public WordDictionary() {
        trie = new Trie();
    }
    
    public void addWord(String word) {
        trie.insert(word);
    }
    
    public boolean search(String word) {
        return trie.search2(word, 0, trie.root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
// @lc code=end

