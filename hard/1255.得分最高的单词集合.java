import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=1255 lang=java
 *
 * [1255] 得分最高的单词集合
 */

// @lc code=start
class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        char[] lettersCount = new char[26];
        for (char letter : letters) {
            lettersCount[letter - 'a']++;
        }
        char[][] wordsCount = new char[n][26];
        int[] wordScore = new int[n];
        for (int i = 0; i < n; i++) {
            for (char c : words[i].toCharArray()) {
                wordsCount[i][c - 'a']++;
                wordScore[i] += score[c - 'a'];
            }
        }
        // System.out.println(Arrays.toString(wordScore));
        int total = 1 << n;
        int max = 0;
        for (int i = 0; i < total; i++) {
            char[] count = new char[26];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int mask = 1 << j;
                // System.out.println("i = " + i + " j = " + j + "i & mask = " + (i & mask));
                if ((i & mask) != 0) {
                    // 计数
                    // System.out.print(words[j] + " ");
                    countAdd(count, wordsCount[j]);
                    sum += wordScore[j];
                }
            }
            if (less(count, lettersCount)) {
                max = Math.max(max, sum);
            }
            // System.out.println("0b" + Integer.toBinaryString(i) + " " + sum);
        }
        return max;
    }
    void countAdd(char[] a, char[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] += b[i];
        }
    }
    boolean less(char[] a, char[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i]) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end

