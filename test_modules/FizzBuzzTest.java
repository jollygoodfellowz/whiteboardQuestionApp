import java.util.Scanner;
import java.io.*;

public class FizzBuzzTest {

    public static void main(String[] args) throws FileNotFoundException {

        FizzBuzz test = new FizzBuzz();

        boolean correct = true;
        String answer = "";
        for(int i = 1; i < 101; i++) {
            String ret = test.multiplesof3and5(i); 

            if(i % 3 == 0 && i % 5 == 0) {
                answer = "FizzBuzz";
            } else if(i % 3 == 0 ) {
                answer = "Fizz";
            } else if (i % 5 == 0) {
                answer = "Buzz";
            } else {
                answer = "";
            }
            if(!answer.equals(ret)) {
                correct = false;
                System.out.println("Input: " + i + " Output: " + ret + "Expected: " + answer);
            }
        }

        if(correct) {
            System.out.print("Correct!");
        }
    }
}

