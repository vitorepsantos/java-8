package br.code;

public class ThreadGroupExample1 implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String args[]) {

        ThreadGroup tg1 = new ThreadGroup("Group A");

        ThreadGroupExample1 runnable = new ThreadGroupExample1();

        Thread t1 = new Thread(tg1, runnable, "one");
        Thread t2 = new Thread(tg1, runnable, "two");
        Thread t3 = new Thread(tg1, runnable, "three");

        t1.start();
        t2.start();
        t3.start();

        tg1.list();

    }

}
