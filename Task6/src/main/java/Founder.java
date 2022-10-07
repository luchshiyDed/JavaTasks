import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public final class Founder {
    private class Worker implements Runnable{
        private Department dep;
        private CyclicBarrier bar;
        Worker(Department dep,CyclicBarrier bar){
            this.dep=dep;
            this.bar=bar;
        }
        @Override
        public void run() {
            dep.performCalculations();
            System.out.println("department #" + dep.getIdentifier() + " ended calculations");
            try {
                bar.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
    private final List<Runnable> workers;
    public Founder(final Company company) {
        this.workers = new ArrayList<>(company.getDepartmentsCount());
        CyclicBarrier bar=new CyclicBarrier(company.getDepartmentsCount(),company::showCollaborativeResult);
        for(int i=0;i< company.getDepartmentsCount();i++){
            workers.add(new Worker(company.getFreeDepartment(i),bar));
        }
    }
    public void start() {
        for (final Runnable worker : workers) {
            new Thread(worker).start();
        }
    }
}