package org.example.blind75.linkedlists;

import java.util.HashMap;
import java.util.Map;

public class VolatileExample {
    private volatile boolean running = true;

    public void start() {
        new Thread(() -> {
            while (running) {
                // Perform some work
                System.out.println("thread is running");
            }
            System.out.println("Thread stopped");
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                System.out.println("thread 2 invoked");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            running = false;
            System.out.println("Variable updated to false");
        }).start();
    }

    public static void main(String[] args) {
        VolatileExample example = new VolatileExample();
        example.start();
    }
}

