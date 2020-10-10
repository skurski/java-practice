package com.skurski.threads;

import java.util.Collection;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.concurrent.*;
import java.util.stream.Stream;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(5);

        Runnable eventTask = () -> System.out.println("EventTask: " + Thread.currentThread().getName());

        service.submit(eventTask);
        service.submit(eventTask);
        service.submit(eventTask);
        service.submit(eventTask);
        service.submit(eventTask);
        service.submit(eventTask);
        service.submit(eventTask);
        service.shutdown();

        Callable<Integer> sumTask = () -> {
            return Stream.iterate(1, (elem) -> elem * elem)
                    .limit(10)
                    .reduce(0, (prev, next) -> prev + next);
        };

        ExecutorService callableService = Executors.newFixedThreadPool(3);
        Future<Integer> future = callableService.submit(sumTask);
        callableService.shutdown();

        System.out.println(future.get().intValue());

    }

}
