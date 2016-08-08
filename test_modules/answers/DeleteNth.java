public class DeleteNth {
    public Node deleteNth(Node curr, int index) {
        // Empty list
        if(curr == null) return null;
        if(index < 0 ) return curr;

        if(index > 1) return curr.next;
        // Delete the head of the list
        if(index == 0) {
            // Does the list have another element?
            if(curr.next != null) {
                Node temp = curr;
                curr = curr.next;
                curr.next = null;
                temp = null;
            // The list only contains the head
            } else {
                curr = null;
            }
        }

        // The normal case
        else {
            Node temp = curr;
            int count = 0;
            // Keep iterating until the index is one ahead
            while(temp != null && count+1 != index) {
                count++;
                temp = temp.next;
            }

            // Index was invalid
            if(temp == null || temp.next == null) return curr;

            // The node to delete
            Node del = temp.next;
            // Does the node we are trying to delete point to something?
            if(temp.next.next != null) {
                temp.next = temp.next.next;
                del.next = null;
            // This is the end of the list
            } else {
                temp.next = null;
            }    
                
            del = null;
        }
        return curr;
    }
}

