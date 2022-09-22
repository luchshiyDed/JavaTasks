public class Task_3 {
    public static void main(String[] args) {
        String[] input1= {"a1","b1"};
        String[] input2= {"a2","b2","c2"};
        String[] input3= {"a3","b3","c3","d3"};
        String[] input4= {"a4","b4","c4","d4","e4"};

        myTread t1 = new myTread();
        t1.setArgs(input1);
        myTread t2 = new myTread();
        t2.setArgs(input2);
        myTread t3 = new myTread();
        t3.setArgs(input3);
        myTread t4 = new myTread();
        t4.setArgs(input4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
class myTread extends Thread{
    static void method(String[] args){
        for(int i=0;i<args.length;i++)
            System.out.print(args[i]);
        //System.out.println();
    }
   private String[] args;
   public void setArgs(String[] a){
     args=a;
    }
    public void run() {
        this.method(args);
    }
}