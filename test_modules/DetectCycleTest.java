import java.util.*;
import java.io.*;

public class DetectCycleTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("../DetectCycle.txt"));
        Scanner scA = new Scanner(new File("../DetectCycleAnswer.txt"));
        DetectCycle detect = new DetectCycle();
        boolean correct = true;

        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int len = sc.nextInt();
            Node curr = new Node(sc.nextInt());
            for(int j = 0; j < len-1; j++) {
                curr.add(sc.nextInt()); 
            }

            boolean ans = scA.nextBoolean();
            // If the answer is true create the cycle 
            if(ans) {
                Node temp = curr;
                while(temp.next != null) {
                    temp = temp.next;
                }
                temp.next = curr;
            }

            boolean check = detect.detect(curr);
            if(ans != check) {
                correct = false;
                System.out.println("Failed on case# " + i);
            }
        }

        if(correct) {
            System.out.print("Correct!");
        }
    }
}

