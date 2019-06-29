package br.code;

public class CreateExample1 {

    public static void main(String args[]) {

        SqrtThread1 st1 = new SqrtThread1(4);
        SqrtThread2 st2 = new SqrtThread2(4);

        st1.start();

        new Thread(st2).start();
    }

}

class SqrtThread1 extends Thread {

    long sqrt;

    public SqrtThread1(long sqrt) {
        this.sqrt = sqrt;
    }

    public void run() {
        System.out.println(getClass().getCanonicalName() + " " + Math.sqrt(sqrt));
    }

}

class SqrtThread2 implements Runnable {

    long sqrt;

    public SqrtThread2(long sqrt) {
        this.sqrt = sqrt;
    }

    public void run() {
        System.out.println(getClass().getCanonicalName() + " " + Math.sqrt(sqrt));
    }

}

