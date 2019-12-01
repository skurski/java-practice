package com.skurski.threading;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);

        Runnable runnableTasks = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Callable<String> callableTasks = () -> {
            TimeUnit.MILLISECONDS.sleep(500L);
            return "The task is finished!";
        };

        List<Callable<String>> callTasks = new ArrayList<>();
        callTasks.add(callableTasks);
        callTasks.add(callableTasks);
        callTasks.add(callableTasks);

        service.execute(runnableTasks);
//        Future<String> results = service.submit(callableTasks);

        try {
            List<Future<String>> resList = service.invokeAll(callTasks);
            for (Future<String> fut : resList) {
                String finished = fut.get();
                System.out.println(finished);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        service.shutdown();
    }
}
