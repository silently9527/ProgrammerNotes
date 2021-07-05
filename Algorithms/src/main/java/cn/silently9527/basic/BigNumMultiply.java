package cn.silently9527.basic;

import java.util.Arrays;

/**
 * 两个大位数相乘问题
 * 模拟乘法累加
 *
 * 第一步，是将乘数与被乘数逐位相乘；
 * 第二步，将逐位相乘得到的结果，对应相加起来，这一步不考虑进位。
 * 第三步，从后面开始循环遍历，n/10 表示进位数，n%10 表示当前位的值
 *
 *         9  8
 * ×       2  1
 * -------------
 *        (9)(8)  <---- 第1趟: 98×1的每一位结果
 *   (18)(16)     <---- 第2趟: 98×2的每一位结果
 * -------------
 *   (18)(25)(8)  <---- 这里就是相对位的和，还没有累加进位
 */
public class BigNumMultiply {

    private static String multiply(String str1, String str2) {
        int[] num1 = stringToNumArray(str1);
        int[] num2 = stringToNumArray(str2);

        int[] result = new int[num1.length + num1.length + 1];

        for (int i = num2.length - 1; i >= 0; i--) {
            int[] tmp = _multiply(num1, num2.length - 1 - i, num2[i]);
            arrayAdd(result, tmp);
        }

        for (int i = result.length - 1; i >= 0; i--) {
            int pre = result[i] / 10;
            if (pre > 0) {
                result[i - 1] = result[i - 1] + pre;
                result[i] = result[i] % 10;
            }
        }

        return Arrays.toString(result)
                .replace("[", "")
                .replace("]", "")
                .replace(", ", "")
                .replaceAll("^0*", "");
    }

    private static void arrayAdd(int[] result, int[] tmp) {
        int i = result.length - 1, j = tmp.length - 1;
        while (i >= 0 && j >= 0) {
            result[i] = result[i] + tmp[j];
            i--;
            j--;
        }
    }

    private static int[] _multiply(int[] arr, int offset, int value) {
        int[] tmp = new int[arr.length + offset];
        for (int i = arr.length - 1; i >= 0; i--) {
            tmp[i] = arr[i] * value;
        }
        return tmp;
    }

    private static int[] stringToNumArray(String str) {
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = str.charAt(i) - '0';
        }
        return arr;
    }
}
