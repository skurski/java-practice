package com.skurski.threads;

public class TestThread {

    public static void printMessage(String msg) {
        String thread = Thread.currentThread().getName();
        System.out.printf("%s: %s%n", thread, msg);
    }

    private static class MessageQueue implements Runnable {

        @Override
        public void run() {
            String[] messages = {
                    "Great work!",
                    "You are doing well!",
                    "It's getting better and better!",
                    "I'm proud of you!",
                    "It was hard but you make it!"
            };

            for (String str : messages) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    printMessage("Interrupted!");
                }

                printMessage(str);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        printMessage("Creating message thread.");
        Thread.sleep(1000L);

        Thread msgThread = new Thread(new MessageQueue(), "Message Thread");
        msgThread.start();

        while (msgThread.isAlive()) {
            printMessage("Waiting for thread msg to finish.");
            msgThread.join(1000L);
        }

        printMessage("Finally!");
    }
}
