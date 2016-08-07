import java.util.*;
import java.io.*;

public class ReverseTest {

    public static Node reverse(Node curr) {
        if(curr == null) return null;
        if(curr.next == null) return curr;

        Node second = curr.next;
        curr.next = null;

        Node rest = reverse(second);

        second.next = curr;
        return rest;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner sc = new Scanner(new File("../reverseLinked.txt"));
        Scanner scA = new Scanner(new File("../reverseLinkedAnswer.txt"));

        Reverse list = new Reverse();
       
        boolean correct = true;
        int T = sc.nextInt(); 
        for(int i = 0; i < T; i++) {
            int len = sc.nextInt();
            int next = sc.nextInt();
            Node curr = new Node(next); 
            for(int j = 0; j < len-1; j++) {
                next = sc.nextInt();
                curr.add(next);
            }

            Node ret = list.reverse(curr);

            for(int k = 0; ret != null; k++) {
                if(ret == null || ret.data != scA.nextInt()) {
                    correct = false;
                    System.out.println("Failed on case# " + k);
                }
                ret = ret.next;
            }
        }
        String res = correct ? "Correct!" : "Incorrect";
        System.out.print(res);
    }
}
