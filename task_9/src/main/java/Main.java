import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
    final int Cnt=5;
    ArrayList<Fork> forks=new ArrayList<>();
    for (int i=0;i<Cnt;i++){
        forks.add(new Fork(i));
    }
    ArrayList<Philosopher> philosophers=new ArrayList<>();
    philosophers.add(new Philosopher(forks.get(0),forks.get(Cnt-1),0)); // с этой дедлока не будет этот философ берет первой не левую вилку а правую
    //philosophers.add(new Philosopher(forks.get(Cnt-1),forks.get(0),0)); // тут будет
    for (int i=1;i<Cnt;i++){
        philosophers.add(new Philosopher(forks.get(i-1),forks.get(i),i));
    }
    for(Runnable philosopher:philosophers)
        new Thread(philosopher).start();
    }
}
