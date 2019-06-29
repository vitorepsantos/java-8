package br.code;

public class JoinExample1 extends Thread {

    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                Thread.sleep(500);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
    }

    public static void main(String args[]) throws Exception {
        JoinExample1 t1 = new JoinExample1();
        JoinExample1 t2 = new JoinExample1();
        JoinExample1 t3 = new JoinExample1();

        t1.start();
        t1.join();

        t2.start();
        t3.start();
    }

}
