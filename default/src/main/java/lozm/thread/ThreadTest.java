package lozm.thread;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        List<Callable<String>> taskList = new ArrayList<>();
        taskList.add(getTask1());
        taskList.add(getTask2());
        taskList.add(getTask3());

        List<Future<String>> futureList = executorService.invokeAll(taskList);

        for (Future<String> stringFuture : futureList) {
            stringFuture.get();
        }

        System.out.println("allDone");

        executorService.shutdown();
    }

    private static Callable<String> getTask1() {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Thread1 start");
                for (int i = 0; i < 1; i++) {
                    System.out.println("Thread1 ...");
                    Thread.sleep(1000);
                }
                System.out.println("Thread1 end");
                return "Thread1";
            }
        };
    }

    private static Callable<String> getTask3() {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Thread3 start");
                for (int i = 0; i < 2; i++) {
                    System.out.println("Thread3 ...");
                    Thread.sleep(1000);
                }
                System.out.println("Thread3 end");
                return "Thread3";
            }
        };
    }

    private static Callable<String> getTask2() {
        return () -> {
            System.out.println("Thread2 start");
            for (int i = 0; i < 3; i++) {
                System.out.println("Thread2 ...");
                Thread.sleep(1000);
            }
            System.out.println("Thread2 end");
            return "Thread2";
        };
    }

}
