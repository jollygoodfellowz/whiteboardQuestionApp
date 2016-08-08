import java.util.*;

public class SortedLinkedList {

    public Node sort(Node curr) { 
        if(curr == null || curr.next == null) return curr;

        LinkedList<Integer> list = new LinkedList<Integer>();
        while(curr != null) {
            list.add(curr.data);
            curr = curr.next;
        }
        
        Collections.sort(list);
        
        curr = new Node(list.poll());
        while(!list.isEmpty()) {
            curr.add(list.poll());
        }

        return curr;
    }
}


