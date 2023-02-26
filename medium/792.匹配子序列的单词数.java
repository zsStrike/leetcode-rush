/*
 * @lc app=leetcode.cn id=792 lang=java
 *
 * [792] 匹配子序列的单词数
 */

// @lc code=start
class Solution {

    class TrieNode {
        char c;
        int idx;
        boolean isWord;
        TrieNode[] nodes;
        TrieNode(char c) {
            this.c = c;
            this.idx = -1;
            this.isWord = false;
            nodes = new TrieNode[26];
        }
    }

    TrieNode root = new TrieNode('0');
    int count = 0;

    void insert(String str, String ss) {
        TrieNode pre = null;
        TrieNode node = root;
        for (char ch : str.toCharArray()) {
            int i = ch - 'a';
            if (node.nodes[i] == null) {
                node.nodes[i] = new TrieNode(ch);
                for (int j = node.idx + 1; j < ss.length(); j++) {
                    if (ss.charAt(j) == ch) {
                        node.nodes[i].idx = j;
                        break;
                    }
                }
                if (node.nodes[i].idx == -1) {
                    node.nodes[i].idx = ss.length();
                }
            }
            // System.out.println(node.c + " " + node.idx);
            pre = node;
            node = node.nodes[i];
        }
        node.isWord = true;
        System.out.println(str + " " + node.idx);
        // System.out.println(ss.substring(0, node.idx + 1));
        count += node.idx == ss.length() ? 0 : 1;
    }

    public int numMatchingSubseq(String s, String[] words) {        
        for (String word : words) {
            insert(word, s);
        }
        return count;
    }
}


// @lc code=end

