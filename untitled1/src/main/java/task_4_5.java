public class task_4_5 {
    static class myThread extends Thread {
        public void run() {
            try {
            while (1 == 1)
                System.out.println("output");
            } catch (ThreadDeath e) {
                System.out.println("I'm ending");
                return;
            }
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
        a.stop();
    }
}
