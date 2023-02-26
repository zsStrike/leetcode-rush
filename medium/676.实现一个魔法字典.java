import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=676 lang=java
 *
 * [676] 实现一个魔法字典
 */

// @lc code=start
class MagicDictionary {

    HashSet<String> dict;

    public MagicDictionary() {
        dict = new HashSet<>();
    }
    
    public void buildDict(String[] dictionary) {
        for (String word : dictionary) {
            dict.add(word);
        }
    }
    
    public boolean search(String searchWord) {
        StringBuilder sb = new StringBuilder(searchWord);
        int n = sb.length();
        for (int i = 0; i < n; i++) {
            int pre = sb.charAt(i);
            for (int j = 0; j < 26; j++) {
                if (pre != j + 'a') {
                    sb.setCharAt(i, (char) (j + 'a'));
                    if (dict.contains(sb.toString())) {
                        return true;
                    }
                }
            }
            sb.setCharAt(i, (char) pre);
        }
        return false;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */
// @lc code=end

