package br.code;

public class DaemonExample1 extends Thread {

    public void run() {
        if (isDaemon()) {
            System.out.println("Daemon Thread");
            try {
                Thread.sleep(500000000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Non-daemon Thread");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        DaemonExample1 t1 = new DaemonExample1();
        DaemonExample1 t2 = new DaemonExample1();

        t1.setDaemon(true);

        t1.start();
        t2.start();
    }

}
