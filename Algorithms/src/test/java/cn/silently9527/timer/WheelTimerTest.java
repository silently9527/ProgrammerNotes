package cn.silently9527.timer;

import org.junit.Test;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class WheelTimerTest {

    @Test
    public void addTask() throws InterruptedException {
        WheelTimer timer = new WheelTimer(60, 1, TimeUnit.SECONDS);
        long startSeconds = System.currentTimeMillis() / 1000;
        timer.addTask(() -> {
            System.out.println(new Date());
            System.out.println("Task1:" + ((System.currentTimeMillis() / 1000) - startSeconds));
        }, 10, TimeUnit.SECONDS);

        timer.addTask(() -> {
            System.out.println(new Date());
            System.out.println("Task2:" + ((System.currentTimeMillis() / 1000) - startSeconds));
        }, 1, TimeUnit.MINUTES);

        timer.addTask(() -> {
            System.out.println(new Date());
            System.out.println("Task4:" + ((System.currentTimeMillis() / 1000) - startSeconds));
        }, 70, TimeUnit.SECONDS);

        timer.addTask(() -> {
            System.out.println(new Date());
            System.out.println("Task3:" + ((System.currentTimeMillis() / 1000) - startSeconds));
        }, 75, TimeUnit.SECONDS);


        Thread.sleep(60 * 60 * 60 * 1000);
    }
}