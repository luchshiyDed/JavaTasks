public class Task_10 {
    static Boolean flag = Boolean.FALSE;

    static void output(String ot) {
        System.out.println(ot);
    }

    static class myTread extends Thread {
        public void run() {
            synchronized (Task_10.class) {
                while (!flag) {
                    try {
                        Task_10.class.wait();
                    } catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
            for (int i = 0; i < 10; i++) {
                output("Child output #" + (i + 1));
                synchronized (Task_10.class) {
                    flag = !flag;
                    Task_10.class.notify();
                    if (i==9)return;
                    while (!flag) {
                        try {
                            Task_10.class.wait();
                        } catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        myTread a = new myTread();
        a.start();
        Thread.sleep(100);
        for (int i = 0; i < 10; i++) {
            output("Parent output #" + (i + 1));
            synchronized (Task_10.class) {
                flag = !flag;
                Task_10.class.notify();
                while (flag) {
                    try {
                        Task_10.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}