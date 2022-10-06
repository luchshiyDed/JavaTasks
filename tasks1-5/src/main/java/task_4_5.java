import javax.naming.InterruptedNamingException;

public class task_4_5 {
    static class myThread extends Thread {
        public void run() {
            while (!Thread.currentThread().isInterrupted())
                System.out.println("output");
            System.out.println("I'm ending");
        }
    }

    public static void main(String[] args) {
        Thread a= new myThread();
        a.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.interrupt();
    }
}
