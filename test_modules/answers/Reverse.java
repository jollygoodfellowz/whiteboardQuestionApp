public class Reverse {
    public Node reverse(Node curr){ 
        if(curr == null) return null;
        if(curr.next == null) return curr;

        Node second = curr.next;
        curr.next = null;

        Node rest = reverse(second);
        second.next = curr;

        return rest;
    }
}
