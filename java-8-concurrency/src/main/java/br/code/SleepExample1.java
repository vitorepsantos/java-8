package br.code;

public class SleepExample1 extends Thread {

    private int sleep;

    public SleepExample1(int sleep) {
        this.sleep = sleep;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " Start sleeping:" + sleep);
            if (sleep > 0) {
                Thread.sleep(sleep);
            }
            System.out.println(Thread.currentThread().getName() + " Finish sleeping:" + sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws Exception {
        SleepExample1 t1 = new SleepExample1(5000);
        SleepExample1 t2 = new SleepExample1(1000);

        t1.start();

        t2.start();
    }
}
