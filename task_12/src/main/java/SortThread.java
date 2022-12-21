public class SortThread implements Runnable{
    private MyList myList;
    private Boolean isRunning;
    public SortThread(MyList myList){
        this.myList = myList;
        this.isRunning=true;
    }
    public void end(){
        this.isRunning=false;
    }
    @Override
    public void run(){
        while (isRunning){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            this.myList.bubblesort();
        }
    }
}