import java.io.InputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Sorter s= new Sorter();
        Scanner scanner= new Scanner(System.in);
        String input=scanner.nextLine();
        while(input.){

            s.add(input);
            input=scanner.nextLine();
        }
    }
}
