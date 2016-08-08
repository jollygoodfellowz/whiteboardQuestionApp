import java.util.*;
import java.io.*;

public class SortedLinkedListTest {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("../SortedLinkedList.txt"));
        Scanner scA = new Scanner(new File("../SortedLinkedListAnswer.txt"));
        SortedLinkedList sort = new SortedLinkedList();
        boolean correct = true;

        int T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            int len = sc.nextInt();
            Node curr = new Node(sc.nextInt());
            for(int j = 0; j < len-1; j++) {
               curr.add(sc.nextInt()); 
            }

            curr = sort.sort(curr);
            for(int k = 0; curr != null; k++, curr=curr.next) {
                int ans = scA.nextInt();
                if(curr.data != ans) {
                    correct = false;
                    System.out.println("Error on case# " + i + ". Expected " + ans + " but got " + curr.data);
                }
            } 
        }

        if(correct) {
            System.out.print("Correct!");
        }
    }
}
