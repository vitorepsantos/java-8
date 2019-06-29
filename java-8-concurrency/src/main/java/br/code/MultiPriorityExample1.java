package br.code;

public class MultiPriorityExample1 extends Thread {

    private int sleep;

    public MultiPriorityExample1(int sleep) {
        this.sleep = sleep;
    }

    public void run() {
        if (sleep > 0) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("running thread name is: "+Thread.currentThread().getName()+" with priority: " + Thread.currentThread().getPriority());
    }

    public static void main(String args[]) throws Exception {
        MultiPriorityExample1 t1 = new MultiPriorityExample1(500);
        MultiPriorityExample1 t2 = new MultiPriorityExample1(0);
        MultiPriorityExample1 t3 = new MultiPriorityExample1(0);

        t1.setName("T1");
        t1.setPriority(Thread.MIN_PRIORITY);

        t2.setName("T2");
        t2.setPriority(Thread.NORM_PRIORITY);

        t3.setName("T3");
        t3.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
    }

}
