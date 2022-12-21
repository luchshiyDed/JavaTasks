import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        MyList list = new MyList();
        Thread thread = new Thread(new SortThread(list));
        thread.start();

        while (true){
            String str = input.nextLine();
            if (str.equals(""))
                list.print();
            else {
                list.push(str);
            }
        }
    }
}