import java.util.Timer;
import java.util.TimerTask;

public class task_4_5 {
    static class MyThread extends Thread {
        public void run() {
            while (!Thread.currentThread().isInterrupted())
                System.out.println("output");
            System.out.println("I'm ending");
        }
    }

    public static void main(String[] args) {
        Timer timer= new Timer();
        MyThread a = new MyThread();
        a.start();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                a.interrupt();
                timer.cancel();
            }
        },2000);
    }
}
