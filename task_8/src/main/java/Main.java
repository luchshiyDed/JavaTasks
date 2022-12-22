import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int threadCnt=0;
        try {
            threadCnt=Integer.parseInt(args[0]);
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("no params");
            return;
        }
        catch (NumberFormatException e1){
            System.out.println("wrong format");
            return;
        }

        CounterManager counterManager=new CounterManager(threadCnt);
        Thread endThread=new Thread(()->{
            try {
                System.out.println(counterManager.getRes());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Runtime.getRuntime().addShutdownHook(endThread);
        System.out.println("Calculations started");
        counterManager.performCalculations();

    }
}
