package br.code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample1 implements Runnable {

    private String message;

    public ThreadPoolExample1(String message){
        this.message = message;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + " (Start) message = " + message);
        processMessage();
        System.out.println(Thread.currentThread().getName() + " (End)");
    }

    private void processMessage() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(5);//creating a pool of 5 threads

        for (int i = 0; i < 10; i++) {
            Runnable worker = new ThreadPoolExample1("" + i);
            executor.execute(worker);//calling execute method of ExecutorService
        }

        executor.shutdown();

        while (!executor.isTerminated()) {   }

        System.out.println("Finished all threads");
    }

}
