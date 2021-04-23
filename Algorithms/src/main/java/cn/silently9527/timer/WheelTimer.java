package cn.silently9527.timer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class WheelTimer implements Timer {
    private final int wheelSize; //时间刻度大小；
    private final long tickDuration; //每次拨动表盘指针的最小时间 最小单位到毫秒
    private final Bucket[] buckets;

    private long tick; //指针从启动总共跳动了多少次
    private final long startTime; //时间轮启动时间

    public WheelTimer(int wheelSize, long tickDuration, TimeUnit unit) {
        this.tickDuration = unit.toMillis(tickDuration);

        this.wheelSize = wheelSize;
        this.buckets = new Bucket[wheelSize];
        for (int i = 0; i < wheelSize; i++) {
            this.buckets[i] = new Bucket();
        }

        this.startTime = System.currentTimeMillis();
        CompletableFuture.runAsync(worker())
                .exceptionally(e -> {
                    e.printStackTrace();
                    return null;
                });
    }


    /**
     * 时间轮时间工作线程
     */
    private Runnable worker() {
        return () -> {
            while (true) {
                try {
                    Thread.sleep(this.tickDuration);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                tick++;
                int index = (int) (tick % this.wheelSize);
                System.out.println(tick);
                long deadline = (this.startTime + this.tick * this.tickDuration) / 1000;
                this.buckets[index].checkAndExecuteTask(deadline);
            }
        };
    }

    @Override
    public void addTask(Task task, long delay, TimeUnit unit) {
        long deadline = (System.currentTimeMillis() + unit.toMillis(delay)) / 1000;
        long totalTick = unit.toMillis(delay) / tickDuration;
        int index = (int) (totalTick % wheelSize);

        this.buckets[index].addWrapTask(new WrapTask(task, deadline));
    }

    /**
     * 时间轮中的刻度桶
     */
    private static class Bucket {
        private WrapTask head;
        private WrapTask last;

        public void addWrapTask(WrapTask wrapTask) {
            WrapTask lastWrapList = last;
            last = wrapTask;
            if (head == null) {
                head = wrapTask;
            } else {
                last.pre = lastWrapList;
                lastWrapList.next = last;
            }
        }

        public void checkAndExecuteTask(long deadline) {
            WrapTask task = head;
            while (task != null) {
                WrapTask next = task.next;
                if (head.deadline <= deadline) {
                    task.execute();
                    next = remove(task);
                }

                task = next;
            }
        }

        private WrapTask remove(WrapTask task) {
            WrapTask next = task.next;
            if (task.pre != null) {
                task.pre.next = task.next;
            }
            if (task.next != null) {
                task.next.pre = task.pre;
            }
            if (task == head) {
                if (task == last) {
                    head = null;
                    last = null;
                } else {
                    head = head.next;
                }
            }
            return next;
        }
    }

    /**
     * 待执行任务的包装
     */
    private static class WrapTask {
        private final Task task;
        private final long deadline;

        private WrapTask pre;
        private WrapTask next;

        public WrapTask(Task task, long deadline) {
            this.task = task;
            this.deadline = deadline;
        }

        public void execute() {
            CompletableFuture.runAsync(task::run);
        }
    }

}
