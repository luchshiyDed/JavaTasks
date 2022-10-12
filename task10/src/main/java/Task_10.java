public class Task_10 {
    static Boolean flag=Boolean.FALSE;
    static void output(String ot){
        System.out.println(ot);
    }
    static class myTread extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                while (!flag) {
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
               output("Child output #" + (i + 1));
                synchronized (flag){
                    flag=!flag;
                }

            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        myTread a = new myTread();
        a.start();

        for (int i = 0; i < 10; i++) {
            while (flag) {
                try {
                    Thread.currentThread().sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            output("Parent output #" + (i + 1));
            synchronized (flag){
                flag=!flag;

            }

    }
}
}