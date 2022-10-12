public class Task_10 {
    static Boolean flag = Boolean.TRUE;

    static void output(String ot) {
        System.out.println(ot);
    }

    static class myTread extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                output("Child output #" + (i + 1));
                synchronized (Task_10.class) {
                    flag = !flag;
                    Task_10.class.notify();
                    while (!flag) {
                        try {
                            Task_10.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    if(i==9)return;
                }
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        myTread a = new myTread();
        a.start();

        for (int i = 0; i < 10; i++) {
            output("Parent output #" + (i + 1));
            synchronized (Task_10.class) {
                flag = !flag;
                Task_10.class.notify();
                if (i==9)return;
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