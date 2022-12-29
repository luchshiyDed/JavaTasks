public class SortThread implements Runnable{
    private MyList myList;
    public SortThread(MyList myList){
        this.myList = myList;
    }
    @Override
    public void run(){
        while (true){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.myList.bubblesort();
        }
    }
}