public class DetectCycle {
    public boolean detect(Node curr) {
        if(curr == null || curr.next == null || curr.next.next == null) return false;

        Node slow = curr;
        Node fast = curr.next.next;

        while(fast != null && fast.next != null) {
            if(fast == slow) return true;
            fast = fast.next.next;
            slow = slow.next;
        }

        return false;

    }
}
