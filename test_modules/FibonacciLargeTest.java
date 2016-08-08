import java.util.*;
import java.io.*;

public class FibonacciLargeTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("../FibonacciLarge.txt"));
        Scanner scA = new Scanner(new File("../FibonacciLargeAnswer.txt"));
        boolean correct = true;
        FibonacciLarge fib = new FibonacciLarge();

        int T = sc.nextInt();

        for(int i = 0; i < T; i++) {
            String ret = fib.fib(sc.nextInt());
            String ans = scA.next();

            if(!ret.equals(ans)) {
                correct = false;
                System.out.println("Error on case# " + i + ". Expected " + ans + " but got " + ret);
            }
        }

        if(correct) {
            System.out.print("Correct!");
        }
    }
}

