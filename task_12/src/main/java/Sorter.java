import java.util.LinkedList;

public class Sorter implements Runnable {
    LinkedList<String> list;
    public Sorter() {
        this.list = new LinkedList<>();
        new Thread(this).start();
    }
    private synchronized void BubbleSort() {
        for (int i = 0; i < this.list.size(); i++) {
            for (int j = i; j < this.list.size(); j++) {
                String str1 = this.list.get(i);
                String str2 = this.list.get(j);
                if (str2.compareTo(str1) < 0) {
                    this.list.set(j, str1);
                    this.list.set(i, str2);
                }
            }
        }
    }

    public synchronized void add(String str) {
        if (str == "")
            this.printList();
        else
            list.addFirst(str);
    }

    private synchronized void printList() {
        list.forEach(t -> System.out.println(t));
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.BubbleSort();
        }
    }
}
