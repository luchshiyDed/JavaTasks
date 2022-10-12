import java.util.concurrent.Semaphore;

public class Task_11 {
    static Boolean flag=Boolean.FALSE;
    static Semaphore sem1;
    static Semaphore sem2;
    static void output(String ot){
        System.out.println(ot);
    }
    static class myTread extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    sem2.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                output("Child output #" + (i + 1));
                sem1.release();

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        sem1=new Semaphore(1);
        sem2=new Semaphore(1);
        myTread a = new myTread();
        sem2.acquire();
        a.start();

        for (int i = 0; i < 10; i++) {
            sem1.acquire();
            output("Parent output #" + (i + 1));
            sem2.release();
        }
    }
}