package cn.silently9527.leetcode;

public class IntReverse {

    public static int reverse(int x) {
        long result = 0;

        while (x != 0) {
            result = result * 10 + (x % 10);
            x = x / 10;
            if (result > Integer.MAX_VALUE || result < -Integer.MAX_VALUE) {
                return 0;
            }
        }

        return (int) result;
    }


    public static void main(String[] args) {
        System.out.println(IntReverse.reverse(1534236469));

    }
}
