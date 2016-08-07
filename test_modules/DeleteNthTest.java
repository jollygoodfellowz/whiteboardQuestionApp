import java.util.*;
import java.io.*;

public class DeleteNthTest {
   public static void main(String[] args) throws FileNotFoundException {
       Scanner sc = new Scanner(new File("../DeleteNth.txt"));
       Scanner scA = new Scanner(new File("../DeleteNthAnswer.txt"));
       DeleteNth del = new DeleteNth();
       boolean correct = true;

       int T = sc.nextInt();
       for(int i = 0; i < T; i++) {
           int len = sc.nextInt();
           int delIndex = sc.nextInt();
           Node curr = new Node(sc.nextInt());

           for(int j = 0; j < len-1; j++) {
               curr.add(sc.nextInt());
           }

           curr = del.deleteNth(curr, delIndex);

           for(int k = 0; curr != null; k++) {
               int ans = scA.nextInt();
               if(ans != curr.data) {
                   correct = false;
                   System.out.println("Falied on case# " + i + " Expected " + ans + " but got " + curr.data);
               }
               curr = curr.next;
           } 

           if(len-1 == 0 && curr != null) {
               correct = false;
               scA.nextInt();
               System.out.println("Failed on case# " + i + " Expected null but got " + curr.data);
           } else if(len-1 == 0) {
               scA.nextInt();
           }
       }

       if(correct) {
           System.out.print("Correct!");
       }
    }
}

