package cn.silently9527.basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class EvaluateTest {

    @Test
    public void calculate() {
        System.out.println(Evaluate.calculate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
        System.out.println(Evaluate.calculate("( 1 + ( 2 + 3 ) )"));

    }
}