import java.util.concurrent.ThreadLocalRandom;

public class Philosopher implements Runnable {
    void think() {
        try {
            Thread.sleep(ThreadLocalRandom.current().nextLong(1000, 4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Integer id;
    private Fork left;
    private Fork right;

    public Philosopher(Fork left, Fork right, Integer id) {
        this.left = left;
        this.right = right;
        this.id = id;
    }

    @Override
    public void run() {
        while (Boolean.TRUE) {
            this.think();
            System.out.println(id + " is hungry");
            synchronized (left) {
                //this.think(); // взял вилку - подумал, почти сразу даст возможный дедлок
                System.out.println(id + " got left fork №"+ left.getId());
                synchronized (right) {
                    System.out.println(id + " got right fork №" + right.getId());
                    this.think();
                }
                System.out.println(id + " ate");
            }
        }
    }
}
