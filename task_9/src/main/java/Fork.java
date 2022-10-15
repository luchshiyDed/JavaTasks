import java.util.concurrent.locks.ReentrantLock;

public class Fork {
    private Integer id;
    public Fork(Integer id){
        this.id = id;
    }
    public Integer getId(){
        return this.id;
    }
}
