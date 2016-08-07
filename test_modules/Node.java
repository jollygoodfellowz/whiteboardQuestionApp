public class Node {
    int data;
    public Node next;
    private Node end;

    public Node(int data) {
        this.data = data;
        next = null;
        end = null;
    }

    public Node() {
    }
    public void add(int data) {
        if(end == null) {
            end = new Node(data);
            next = end;
        } else {
            end.next = new Node(data);
            end = end.next;
        }
    }

    public void print() {
        System.out.print(data + "-->");
        if(next == null) {
            System.out.println();
            return;
        }
        Node temp = next;
        while(temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println();
    }

}
