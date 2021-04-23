package cn.silently9527.timer;

import java.util.concurrent.TimeUnit;

public interface Timer {

    void addTask(Task task, long delay, TimeUnit unit);

}
