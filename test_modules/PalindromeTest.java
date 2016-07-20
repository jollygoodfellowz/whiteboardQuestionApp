import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PalindromeTest {
    
    public static void main(String[] args) throws FileNotFoundException {

        if(args.length < 1) {
            System.out.println("Please pass in a file with palindromes");
            return;
        }

        Palindrome test = new Palindrome();

        Scanner sc = new Scanner(new File(args[0]));
        Scanner scA = new Scanner(new File(args[1]));

        boolean correct = true;
        while(sc.hasNext()) {
            String pali = sc.nextLine();

            boolean ret = test.isPalindrome(pali);
            boolean answer = (scA.next().equals("True")) ? true : false;

            if(answer != ret) {
               System.out.println("Input: " + pali + " Output: " + ret + " Expected: " + answer);
               correct = false;
            }
        }

        if(correct) {
            System.out.println("Correct!");
        }
    }
}
    
