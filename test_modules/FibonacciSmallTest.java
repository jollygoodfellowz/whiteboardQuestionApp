import java.util.*;
import java.io.*;

public class FibonacciSmallTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("../FibonacciSmall.txt"));
        Scanner scA = new Scanner(new File("../FibonacciSmallAnswer.txt"));
        boolean correct = true;
        FibonacciSmall fib = new FibonacciSmall();

        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            int ret = fib.fib(sc.nextInt());
            int ans = scA.nextInt();

            if(ret != ans) {
                correct = false;
                System.out.println("Error on case# " + i + ". Expected " + ans + " but got " + ret);
            }
        }

        if(correct) {
            System.out.print("Correct!");
        }
    }
}
