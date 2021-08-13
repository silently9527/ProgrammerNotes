package cn.silently9527.leetcode;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
//
// 说明：本题中，我们将空字符串定义为有效的回文串。
//
// 示例 1:
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
//
//
// 示例 2:
//
// 输入: "race a car"
//输出: false
//
// Related Topics 双指针 字符串
// 👍 396 👎 0


public class CheckPalindrome {
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            String s1 = String.valueOf(s.charAt(i));
            if (!s1.matches("[0-9]|[a-z]|[A-Z]")) {
                i++;
                continue;
            }

            String s2 = String.valueOf(s.charAt(j));
            if (!s2.matches("[0-9]|[a-z]|[A-Z]")) {
                j--;
                continue;
            }

            if (!s1.equalsIgnoreCase(s2)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(CheckPalindrome.isPalindrome("race a car"));
    }
}
