package cn.silently9527.leetcode;
//给你两个二进制字符串，返回它们的和（用二进制表示）。
//
// 输入为 非空 字符串且只包含数字 1 和 0。
//
//
//
// 示例 1:
//
// 输入: a = "11", b = "1"
//输出: "100"
//
// 示例 2:
//
// 输入: a = "1010", b = "1011"
//输出: "10101"
//
//
//
// 提示：
//
//
// 每个字符串仅由字符 '0' 或 '1' 组成。
// 1 <= a.length, b.length <= 10^4
// 字符串如果不是 "0" ，就都不含前导零。
//
// Related Topics 位运算 数学 字符串 模拟
// 👍 640 👎 0


import java.util.Arrays;

public class AddBinary {
    public static void main(String[] args) {
        System.out.println(AddBinary.addBinary("101", "111"));
    }

    public static String addBinary(String a, String b) {
        if ("0".equals(a) && "0".equals(b)) {
            return "0";
        }
        int[] aIntArr = stringToArr(a);
        int[] bIntArr = stringToArr(b);

        int[] maxArr = aIntArr.length > bIntArr.length ? aIntArr : bIntArr;
        int[] minArr = aIntArr.length > bIntArr.length ? bIntArr : aIntArr;

        int i = maxArr.length - 1, j = minArr.length - 1;
        while (i > 0 && j > 0) {
            maxArr[i] = maxArr[i--] + minArr[j--];
        }

        for (int k = maxArr.length - 1; k > 0; k--) {
            if (maxArr[k] > 1) {
                maxArr[k - 1] += 1;
                maxArr[k] %= 2;
            }
        }

        return Arrays.toString(maxArr)
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "")
                .replaceAll("^0*", "");
    }

    private static int[] stringToArr(String str) {
        int[] arr = new int[str.length() + 1];
        for (int i = 1; i <= str.length(); i++) {
            arr[i] = str.charAt(i - 1) - '0';
        }
        return arr;
    }
}
