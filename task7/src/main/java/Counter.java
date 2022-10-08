import lombok.AllArgsConstructor;

import java.util.concurrent.Callable;
@AllArgsConstructor
public class Counter implements Callable {
    private int threadCnt;
    private int iterationsCnt;
    private int threadNum; // from zero

    @Override
    public Double call() throws Exception {
        int foldingNum = this.threadNum;
        Double res=0.0;
        for(int i=0;i<this.iterationsCnt;i++){
            res+=(foldingNum%2==0?1:-1)*(1/((double)foldingNum*2+1));
            foldingNum+=this.threadCnt;
        }
        return res;
    }
}
