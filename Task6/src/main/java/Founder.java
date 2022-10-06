import java.util.ArrayList;
import java.util.List;

public final class Founder {
    private class Worker implements Runnable{
        private Department dep;
        Worker(Department dep){
            this.dep=dep;
        }
        @Override
        public void run() {
            dep.performCalculations();
        }
    }
    private final List<Runnable> workers;
    public Founder(final Company company) {
        this.workers = new ArrayList<>(company.getDepartmentsCount());
        for(int i=0;i< workers.size();i++){
            workers.add(new Worker());
        }
    }
    public void start() {
        for (final Runnable worker : workers) {
            new Thread(worker).start();
        }
    }
}