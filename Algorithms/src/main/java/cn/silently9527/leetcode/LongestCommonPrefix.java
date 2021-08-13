package cn.silently9527.leetcode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        String longestCommonPrefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            longestCommonPrefix = _commonPrefix(longestCommonPrefix, strs[i]);
        }
        return longestCommonPrefix;
    }

    private String _commonPrefix(String str1, String str2) {
        int i = 0;
        for (; i < str1.length() && i < str2.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                break;
            }
        }
        return str1.substring(0, i);
    }
}
