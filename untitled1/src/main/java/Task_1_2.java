public class Task_1_2 {
    static class myTread extends Thread{
        public void run() {
            for(int i=0;i<10;i++)
                System.out.println("Child output #" + (i+1));
        }
    }
    public static void main(String[] args){
        myTread a =new myTread();
        a.start();
        try {
            a.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for(int i=0;i<10;i++)
            System.out.println("Parent output #" + (i+1));
    }
}
