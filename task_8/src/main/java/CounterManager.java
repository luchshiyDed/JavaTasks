

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class CounterManager {
    private class Counter implements Callable<Double> {
        private final int threadCnt;
        private long iterationsCnt;
        private final int threadNum; // from zero
        public Counter(int threadCnt,int threadNum){
            this.threadCnt=threadCnt;
            this.iterationsCnt=0;
            this.threadNum=threadNum;
        }
        @Override
        public Double call() throws Exception {
            long foldingNum = this.threadNum;
            double res=0.0;
            while(isRunning){
                res+=(foldingNum%2==0?1:-1)*(1/((double)foldingNum*2+1));
                //System.out.println(res);
                //System.out.println((foldingNum%2==0?1:-1)*(1/((double)foldingNum*2+1)));
                this.iterationsCnt++;
                foldingNum+=this.threadCnt;
                //System.out.println(threadNum+ " " + this.iterationsCnt);
            }
            max_iterations_Cnt.set(Math.max(max_iterations_Cnt.get(), this.iterationsCnt));
            barrier.await();

            for(long i=this.iterationsCnt;i<=max_iterations_Cnt.get();i++){
                res+=(foldingNum%2==0?1:-1)*(1/((double)foldingNum*2+1));
                foldingNum+=this.threadCnt;
            }
            System.out.println(threadNum + "- ended calc " );
            return res;
        }
    }


    private final int threadCnt;
    private final AtomicLong max_iterations_Cnt;
    private volatile boolean isRunning;
    private final CyclicBarrier barrier;
    private  ArrayList<Future<Double>> counterResults;

    public CounterManager(int threadCnt){
        this.threadCnt=threadCnt;
        this.max_iterations_Cnt=new AtomicLong(0);
        this.isRunning=true;
        this.barrier = new CyclicBarrier(threadCnt);
    }
    public void performCalculations() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(this.threadCnt);
        this.counterResults=new ArrayList<>();
        for (int i=0;i<this.threadCnt;i++){
            Counter counter=new Counter(this.threadCnt,i);
            this.counterResults.add(i, executor.submit(counter));
        }
        executor.shutdown();
    }
    double getRes() throws ExecutionException, InterruptedException {
        double res=0.0;
        this.isRunning=false;
        for(int i=0;i<this.threadCnt;i++){
            //System.out.println(counterResults.get(i).get());
            res+=counterResults.get(i).get();
        }
        return res;
    }


}
