

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CounterManager {
    private int threadCnt;
    private int iterationsCnt;
    public CounterManager(int threadCnt,int iterationsCnt){
        this.threadCnt=threadCnt;
        this.iterationsCnt=iterationsCnt;
    }
    public Double performCalculations() throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(threadCnt);
        ArrayList<Future<Double>> counterResults=new ArrayList<>();
        for (int i=0;i<threadCnt;i++){
            counterResults.add(i,executor.submit(new Counter(threadCnt,iterationsCnt,i)));
        }
        Double res=0.0;
        executor.shutdown();
        for(int i=0;i<threadCnt;i++){
            res+=counterResults.get(i).get();
        }
        return res;
    }
}
