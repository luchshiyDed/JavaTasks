

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class CounterManager {
    private class Counter implements Callable<Double> {
        private Integer threadCnt;
        private Integer iterationsCnt;
        private Integer threadNum; // from zero
        public Counter(int threadCnt,int threadNum){
            this.threadCnt=threadCnt;
            this.iterationsCnt=0;
            this.threadNum=threadNum;
        }
        @Override
        public Double call() throws Exception {
            int foldingNum = this.threadNum;
            double res=0.0;
            while(isRunning){
                res+=(foldingNum%2==0?1:-1)*(1/((double)foldingNum*2+1));
                this.iterationsCnt++;
                foldingNum+=this.threadCnt;
                //System.out.println(threadNum+ " " + this.iterationsCnt);
            }
            max_iterations_Cnt.set(max_iterations_Cnt.get()>this.iterationsCnt?max_iterations_Cnt.get():this.iterationsCnt);
            //System.out.println(1);
            barrier.await();
            //System.out.println(2);

            for(int i=this.iterationsCnt;i<=max_iterations_Cnt.get();i++){
                res+=(foldingNum%2==0?1:-1)*(1/((double)foldingNum*2+1));
                foldingNum+=this.threadCnt;
            }
            System.out.println(threadNum + "- ended calc ");
            return res;
        }
    }


    private int threadCnt;
    private  AtomicInteger max_iterations_Cnt;
    private  Boolean isRunning;
    private CyclicBarrier barrier;
    private  ArrayList<Future<Double>> counterResults;
    private ExecutorService executor;
    public CounterManager(int threadCnt){
        this.threadCnt=threadCnt;
        this.max_iterations_Cnt=new AtomicInteger(0);
        this.isRunning=true;
        this.barrier = new CyclicBarrier(threadCnt);
    }
    public void performCalculations() throws ExecutionException, InterruptedException {
        this.executor = Executors.newFixedThreadPool(this.threadCnt);
        this.counterResults=new ArrayList<>();
        for (int i=0;i<this.threadCnt;i++){
            Counter counter=new Counter(this.threadCnt,i);
            this.counterResults.add(i,executor.submit(counter));
        }
        executor.shutdown();
    }
    Double getRes() throws ExecutionException, InterruptedException {
        Double res=0.0;
        this.isRunning=false;
        for(int i=0;i<this.threadCnt;i++){
            res+=counterResults.get(i).get();
        }
        return res;
    }


}
