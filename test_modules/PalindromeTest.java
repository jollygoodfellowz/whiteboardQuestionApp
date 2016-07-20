import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class PalindromeTest {
    
    public static void main(String[] args) throws FileNotFoundException {

        Palindrome test = new Palindrome();

        Scanner sc = new Scanner(new File("../palindromes.txt"));
        Scanner scA = new Scanner(new File("../paliAnswers.txt"));

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
            System.out.print("Correct!");
        }
    }
}
    
