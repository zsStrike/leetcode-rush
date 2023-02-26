/*
 * @lc app=leetcode.cn id=745 lang=java
 *
 * [745] 前缀和后缀搜索
 */

// @lc code=start
class WordFilter {

    class TrieNode {
        int index;
        boolean isWord;
        char c;
        TrieNode[] children;
        TrieNode(char c) {
            this.c = c;
            children = new TrieNode[26];
            isWord = false;
            index = -1;
        }
    }

    TrieNode root;

    public WordFilter(String[] words) {
        int len = words.length;
        for (int i = 0; i < len; i++) {
            insert(words[i], i);
        }
    }
    
    public int f(String pref, String suff) {
        TrieNode node = findPrefixNode(pref);
        if (node == null) {
            return -1;
        }
        StringBuilder sb = new StringBuilder(pref);
        int max = dfs(node, suff, sb);
        return max;
    }

    int dfs(TrieNode node, String suff, StringBuilder sb) {
        if (node == null) {
            return -1;
        }
        int max = -1;
        if (node.isWord && sb.toString().endsWith(suff)) {
            max = Math.max(node.index, max);;
        }
        for (int i = 0; i < 26; i++) {
            if (node.children[i] == null) {
                continue;
            }
            sb.append((char)(i + 'a'));
            max = Math.max(dfs(node.children[i], suff, sb), max);
            sb.deleteCharAt(sb.length() - 1);
        }
        return max;
    }


    TrieNode findPrefixNode(String pref) {
        TrieNode node = root;
        int len = pref.length();
        for (int i = 0; i < len; i++) {
            int idx = pref.charAt(i) - 'a';
            if (node.children[idx] == null) {
                return null;
            }
            node = node.children[idx];
        }
        return node;
    }


    void insert(String word, int index) {
        if (root == null) {
            root = new TrieNode('0');
        }
        int len = word.length();
        TrieNode node = root;
        for (int i = 0; i < len; i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode((char)(idx + '0'));
            }
            node = node.children[idx];
        }
        node.isWord = true;
        node.index = index;
    }
}

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(pref,suff);
 */
// @lc code=end

